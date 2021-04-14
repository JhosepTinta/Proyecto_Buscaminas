package control;

import vista.Casilla;
import vista.Tablero;
import vista.TableroInterno;

public class ControladorTablero {
	private TableroInterno logica;
	private Tablero visual;
	private String[][] tableroInterno;
	public ControladorTablero(TableroInterno logica,Tablero visual) {
		this.logica=logica;
		this.visual=visual;
		tableroInterno = logica.getVista();
	}
	
	public void agregarCasillas() {
		for (int i = 0; i < tableroInterno[0].length; i++) {
			for (int j = 0; j < tableroInterno.length; j++) {
				visual.add(new Casilla(i,j,tableroInterno[i][j]));
			}
		}
	}
}
