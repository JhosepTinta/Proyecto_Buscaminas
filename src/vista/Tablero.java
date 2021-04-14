package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	public Tablero(int nFilas,int nColumnas) {
		setLayout(new GridLayout(nFilas,nColumnas));
		agregarElementos(nFilas,nColumnas);
		
	}
	private void agregarElementos(int filas,int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				add(new Casilla(i,j));
			}
		}
	}
	
}
