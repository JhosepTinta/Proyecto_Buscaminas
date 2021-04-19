package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.*;

//import control.Controlador;
import modelo.Posicion;
import vista.*;

public class PanelTablero extends JPanel {
	private JButton[][] tablero;
	private int filas;
	private int columnas;
	// private Controlador c;
	private int contador;

	private boolean[][] banderas;

	private TableroInterno tableroInterno;

	public PanelTablero(int filas, int columnas, int cantMinas) {
		tablero = new JButton[filas][columnas];
		// this.c = c;
		this.filas = filas;
		this.columnas = columnas;

		banderas = new boolean[filas][columnas];

		setLayout(new GridLayout(filas, columnas));
		setBounds(170, 50, 500, 500);
		tableroInterno = new TableroInterno(filas, columnas, cantMinas);
		agregarBotones();
	}

	private void agregarBotones() {
		for (int i = 0; i < tablero[0].length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				Casilla aux = new Casilla(i, j, "");
				// aux.ponerControl(c);
				tablero[i][j] = aux;
				if (i % 2 == 0) {
					if (j % 2 != 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				} else {
					if (j % 2 == 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				}
				add(tablero[i][j]);
			}
		}
	}

	private void actualizarElementos() {
		super.removeAll();

		boolean bb = false;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				String elemento = tableroInterno.getVista()[i][j];

				if (elemento.equals("*")) {
					elemento = "";
				}

				Casilla aux = new Casilla(i, j, elemento);
				aux.setForeground(Color.WHITE);
				aux.setFont(new Font("Century Gothic", 0, 20));
				// aux.ponerControl(c)
				tablero[i][j] = aux;

				if (i % 2 == 0) {
					if (j % 2 != 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				} else {
					if (j % 2 == 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				}

				if (banderas[i][j]) {
					aux.setText("");
					aux.setIcon(new ImageIcon(getClass().getResource("/imagenes/bandera.png")));
				} else if (esNumerico(elemento)) {
					int n = Integer.parseInt(elemento);
					if (n % 2 == 0) {
						aux.setBackground(new Color(206, 154, 104));
					} else {
						aux.setBackground(new Color(158, 106, 56));
					}
				}

				add(tablero[i][j]);

				if (elemento.equals("F")) {
					bb = true;
				}

				// add(new Casilla(i,j, elemento));

			}
		}

		if (bb) {
			llenarBombas();
		}
	}

	boolean esNumerico(String valorString) {
		try {
			Integer.parseInt(valorString);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	private void llenarBombas() {
		super.removeAll();

		PanelJuego.iniciarTiempo(false);
		
		String[][] tablafin = tableroInterno.getVistaFinal();

		boolean bb = false;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				String elemento = tablafin[i][j];

				if (elemento.equals("*")) {
					elemento = "";
				}

				Casilla aux = new Casilla(i, j, elemento);
				aux.setForeground(Color.WHITE);
				aux.setFont(new Font("Century Gothic", 0, 20));
				// aux.ponerControl(c);
				tablero[i][j] = aux;
				if (i % 2 == 0) {
					if (j % 2 != 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				} else {
					if (j % 2 == 0) {
						aux.setBackground(new Color(15, 156, 80));
					} else {
						aux.setBackground(new Color(20, 199, 102));
					}
				}

				if (esNumerico(elemento)) {
					int n = Integer.parseInt(elemento);
					if (n % 2 == 0) {
						aux.setBackground(new Color(206, 154, 104));
					} else {
						aux.setBackground(new Color(158, 106, 56));
					}
				}

				if (elemento.equals("F")) {
					aux.setText("");
					aux.setBackground(new Color(128, 64, 0));
					aux.setIcon(new ImageIcon(getClass().getResource("/imagenes/bomba.png")));
				}

				add(tablero[i][j]);

				// add(new Casilla(i,j, tablafin[i][j]));

			}
		}

	}

	class Casilla extends JButton implements MouseListener {
		private Posicion pos;

		// private int contador;
		public Casilla(int x, int y, String simbolo) {
			super(simbolo);
			pos = new Posicion(x, y);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getButton() == MouseEvent.BUTTON1) {
				// Se presiono el boton izquierdo
				System.out.println(pos);

				if (!banderas[pos.getF()][pos.getC()]) {
					if (!tableroInterno.isHayMina()) {
						if (!tableroInterno.isGanoJuego()) {
							if (contador == 0) {
								PanelJuego.iniciarTiempo(true);
								tableroInterno.iniciarPrimeraVez(pos);
								contador++;
								super.setText(tableroInterno.getVista()[pos.getF()][pos.getC()]);
							} else {
								contador++;
								tableroInterno.insertar(pos);
								super.setText(tableroInterno.getVista()[pos.getF()][pos.getC()]);
							}

							actualizarElementos();

						} else {
							System.out.println("Gano el juego :)");
						}
					} else {
						System.out.println("Perdio el juego :(");
					}
				}

			}
			if (e.getButton() == MouseEvent.BUTTON3) {
				// Se presiono el boton derecho
				// System.out.println("derecho");

				if (!tableroInterno.isHayMina()) {
					if (!tableroInterno.isGanoJuego()) {
						if (super.getText().length() == 0) {
							
							
							
							banderas[pos.getF()][pos.getC()] = !banderas[pos.getF()][pos.getC()];
							if (banderas[pos.getF()][pos.getC()]) {
								if(PanelJuego.gastarBandera()) {
									super.setIcon(new ImageIcon(getClass().getResource("/imagenes/bandera.png")));
								}else {
									banderas[pos.getF()][pos.getC()] = false;
								}
								
							} else {
								super.setIcon(null);
							}
						}
					} else {
						System.out.println("Gano el juego :)");
					}
				} else {
					System.out.println("Perdio el juego :(");
				}

				/*if (super.getText().length() == 0) {
					banderas[pos.getF()][pos.getC()] = !banderas[pos.getF()][pos.getC()];
					if (banderas[pos.getF()][pos.getC()]) {
						super.setIcon(new ImageIcon(getClass().getResource("/imagenes/bandera.png")));
					} else {
						super.setIcon(null);
					}
				}*/
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
