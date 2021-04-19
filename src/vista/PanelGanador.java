package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import principal.VistaPrincipal;

public class PanelGanador extends JPanel {
	private Image portada = new ImageIcon(getClass().getResource("/imagenes/vistaGano.jpg")).getImage();
	private JLabel tiempo;
	private JLabel puntaje;
	private JButton volverInicio;
	public PanelGanador(String tiempoP,String puntajeP) {
		setLayout(null);
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
		tiempo.setBounds(350, 250,80, 27);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Century Gothic", 0, 27));
		puntaje.setBounds(350,323, 80, 27);
		add(tiempo);
		add(puntaje);
		add(volverInicio);
	}
	
	public void paint(Graphics g) {
		g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}
