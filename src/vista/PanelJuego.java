package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

//import control.Controlador;

public class PanelJuego extends JPanel{
	
	private Image portada = new ImageIcon(getClass().getResource("/imagenes/vistaJuego.jpg")).getImage();
	private PanelTablero panelTablero;
	private JButton rendirse;
	private JButton volverInicio;
	private JLabel tiempo;
	private JLabel cantBanderas;
	//private Controlador controlJuego;
	public PanelJuego() {
		//controlJuego = new Controlador(this);
		rendirse = new JButton(new ImageIcon(getClass().getResource("/imagenes/rendirse.png")));
		volverInicio = new JButton(new ImageIcon(getClass().getResource("/imagenes/volver.png")));
		tiempo = new JLabel("00:00");
		cantBanderas = new JLabel("10");
		panelTablero  = new PanelTablero(8,8,12);
		setLayout(null);
		agregarComponentes();
	}
	
	public void paint(Graphics g) {
		g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	private void agregarComponentes() {
		add(panelTablero);
		rendirse.setBounds(822, 380, 233, 60);
		rendirse.setOpaque(false);
		rendirse.setContentAreaFilled(false);
		rendirse.setBorderPainted(false);
		volverInicio.setBounds(822, 470, 233, 60);
		volverInicio.setOpaque(false);
		volverInicio.setContentAreaFilled(false);
		volverInicio.setBorderPainted(false);
		tiempo.setBounds(950, 80, 60, 20);
		tiempo.setForeground(new Color(255,255,255));
		tiempo.setFont(new Font("Century Gothic",0,24));
		cantBanderas.setBounds(960, 160, 40, 20);
		cantBanderas.setForeground(new Color(255,255,255));
		cantBanderas.setFont(new Font("Century Gothic",0,24));
		add(rendirse);
		add(volverInicio);
		add(tiempo);
		add(cantBanderas);
	}
	
	public JButton darVolver() {
		return volverInicio;
	}
	
	public JButton darRendirse() {
		return rendirse;
	}
	
	public void modificarTamañoTablero(int x,int y,int w,int h) {
		panelTablero.setBounds(x, y, w, h);
	}
	
	public void iniciarTiempo(String t) {
		tiempo.setText(t);
	}
}
