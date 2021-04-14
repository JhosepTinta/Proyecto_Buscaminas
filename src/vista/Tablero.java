package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	private TableroInterno tablero;
	public Tablero(int nFilas,int nColumnas) {
		setLayout(new GridLayout(nFilas,nColumnas));
		agregarElementos(nFilas,nColumnas);
		tablero = new TableroInterno(nFilas, nColumnas);
		
	}
	private void agregarElementos(int filas,int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				add(new Casilla(i,j, "*"));
			}
		}
	}
	/*
	public void aņadirCasillas(int fila,int columna,String simbolo) {
		add(new Casilla(fila,columna,simbolo));
	}*/
	
}
