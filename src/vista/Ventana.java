package vista;
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Ventana extends JFrame{
	
	public Ventana() {
		setBounds(400,300,500,350);
		Tablero nivel= new Tablero(8,8);
		setLayout(new BorderLayout());
		Cabecera head = new Cabecera();
		add(head,BorderLayout.NORTH);
		add(nivel,BorderLayout.CENTER);
		setVisible(true);
	}
}
