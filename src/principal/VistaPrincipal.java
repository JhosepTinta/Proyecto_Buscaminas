package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import vista.*;

public class VistaPrincipal extends JFrame {
	public static PanelPrincipal inicio = new PanelPrincipal();
	private PanelJuego juego;
	private static JScrollPane scrollPaneles;

	public VistaPrincipal() {
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(0, 0, 1130, 640);
		scrollPaneles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		juego =  new PanelJuego();
		setBounds(200, 100, 1130, 640);
		add(scrollPaneles);
		definirPaneles(inicio);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		inicio.darCerrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		inicio.darPrincipiante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				definirPaneles(juego);
			}
		});

		inicio.darMedio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				juego.modificarTamañoTablero(170, 50, 500, 500);
				
				definirPaneles(juego);
			}
		});

		inicio.darAvanzado().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				definirPaneles(juego);
			}
		});

		juego.darVolver().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				definirPaneles(inicio);
			}
		});
	}

	public static void definirPaneles(JPanel panel) {
		scrollPaneles.setViewportView(panel);
	}
}
