package vista;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import control.ControladorTablero;
//hola mundo

public class Ventana extends JFrame{
	//private TableroInterno modelo = new TableroInterno(8,8);
	private Tablero vista;
	//private ControladorTablero control= new ControladorTablero(modelo,vista);
	public Ventana() {
		setBounds(400,300,500,350);
		vista= new Tablero(8,8, 12);
		setLayout(new BorderLayout());
		Cabecera head = new Cabecera();
		add(head,BorderLayout.NORTH);
		add(vista,BorderLayout.CENTER);
		setVisible(true);
	}
}
