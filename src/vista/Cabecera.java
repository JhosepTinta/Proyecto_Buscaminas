package vista;

import java.awt.BorderLayout;

import javax.swing.*;

public class Cabecera extends JPanel{
	private JLabel tiempo =  new JLabel();
	private JButton boton = new JButton("iniciar");

	public Cabecera() {
		setLayout(new BorderLayout());
		add(new JLabel("nivel"),BorderLayout.CENTER);

		add(tiempo,BorderLayout.EAST);
		//Hilos hilo = new Hilos();
		//hilo.start();
		
	}
	
	
		

}

