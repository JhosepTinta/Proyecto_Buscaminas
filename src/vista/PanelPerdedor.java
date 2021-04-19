package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import principal.VistaPrincipal;

public class PanelPerdedor extends JPanel{
	private Image portada = new ImageIcon(getClass().getResource("/imagenes/vistaPerdio.jpg")).getImage();
	private JLabel tiempo;
	private JLabel puntaje;
	private JButton volverInicio;
	private PanelTablero solucion;
	public PanelPerdedor(String tiempoP,String puntajeP,PanelTablero solucion) {
		setLayout(null);
		this.solucion=solucion;
		tiempo = new JLabel(tiempoP);
		puntaje = new JLabel(puntajeP);
		volverInicio = new JButton(new ImageIcon(getClass().getResource("/imagenes/volver.png")));
		volverInicio.setBounds(430, 500, 233, 60);
		volverInicio.setOpaque(false);
		volverInicio.setContentAreaFilled(false);
		volverInicio.setBorderPainted(false);
		volverInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VistaPrincipal.definirPaneles(VistaPrincipal.inicio);
			}
		});
		tiempo.setForeground(Color.WHITE);
		tiempo.setFont(new Font("Century Gothic", 0, 27));
		tiempo.setBounds(305, 325,80, 27);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Century Gothic", 0, 27));
		puntaje.setBounds(305,403, 80, 27);
		solucion.setBounds(600, 210, 250, 250);
		add(tiempo);
		add(puntaje);
		add(volverInicio);
		add(solucion);
	}
	
	public void paint(Graphics g) {
		g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}
