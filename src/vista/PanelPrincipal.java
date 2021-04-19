package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class PanelPrincipal extends JPanel{
	Image portada = new ImageIcon(getClass().getResource("/imagenes/vistaPrincipal.jpg")).getImage();
	ImageIcon cerrar = new ImageIcon(getClass().getResource("/imagenes/cerrar.png"));
	private JButton botonCerrar = new JButton(cerrar);
	private JButton botonPrincipiante;
	private JButton botonMedio;
	private JButton botonAvanzado;
	private JButton botonPersonalizado;
	private Color colorBoton = new Color(0, 0, 0);
	private Color colorTextoBoton = new Color(255,255,255);
	public PanelPrincipal() {
		botonPrincipiante  = new JButton(new ImageIcon(getClass().getResource("/imagenes/principiante.png")));
		botonMedio  = new JButton(new ImageIcon(getClass().getResource("/imagenes/medio.png")));
		botonAvanzado  = new JButton(new ImageIcon(getClass().getResource("/imagenes/avanzado.png")));
		botonPersonalizado  = new JButton(new ImageIcon(getClass().getResource("/imagenes/personalizado.png")));
		setLayout(null);
		insertarComponentes();
	}
	
	public void insertarComponentes() {
		botonCerrar.setBounds(1020,23,64,64);
		botonCerrar.setOpaque(false);
		botonCerrar.setContentAreaFilled(false);
		botonCerrar.setBorderPainted(false);
		botonPrincipiante.setBounds(710, 155, 250, 60);
		botonPrincipiante.setOpaque(false);
		botonPrincipiante.setContentAreaFilled(false);
		botonPrincipiante.setBorderPainted(false);
		botonMedio.setBounds(710, 245, 250, 60);
		botonMedio.setOpaque(false);
		botonMedio.setContentAreaFilled(false);
		botonMedio.setBorderPainted(false);
		botonAvanzado.setBounds(710,335, 250, 60);
		botonAvanzado.setOpaque(false);
		botonAvanzado.setContentAreaFilled(false);
		botonAvanzado.setBorderPainted(false);
		botonPersonalizado.setBounds(710, 425, 250, 60);
		botonPersonalizado.setOpaque(false);
		botonPersonalizado.setContentAreaFilled(false);
		botonPersonalizado.setBorderPainted(false);
		
		botonCerrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent a) {
				botonCerrar.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/imagenes/cerrar64.png")));
			}
			public void mouseExited(MouseEvent a) {
				botonCerrar.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/imagenes/cerrar.png")));
			}
		});
		
		add(botonCerrar);
		add(botonPrincipiante);
		add(botonMedio);
		add(botonAvanzado);
		add(botonPersonalizado);
	}
	
	public void paint(Graphics g) {
		g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	public JButton darCerrar() {
		return botonCerrar;
	}
	
	public JButton darPrincipiante() {
		return botonPrincipiante;
	}
	
	public JButton darMedio() {
		return botonMedio;
	}
	
	public JButton darAvanzado() {
		return botonAvanzado;
	}
	
	
}


	

