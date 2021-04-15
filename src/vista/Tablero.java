package vista;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	
	private int contador;
	
	private TableroInterno tablero;
	
	private int filas, columnas;
	
	public Tablero(int nFilas,int nColumnas, int cantMinas) {
		
		filas = nFilas;
		columnas = nColumnas;
		
		setLayout(new GridLayout(nFilas,nColumnas));
		tablero = new TableroInterno(nFilas, nColumnas, cantMinas);
		contador = 0;
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				add(new Casilla(i,j, "*"));
			}
		}
		
	}
	private void actualizarElementos() {
		super.removeAll();
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				add(new Casilla(i,j, tablero.getVista()[i][j]));
			}
		}
	}
	/*
	public void añadirCasillas(int fila,int columna,String simbolo) {
		add(new Casilla(fila,columna,simbolo));
	}*/
	
	class Casilla extends JButton implements MouseListener{
		private Posicion pos;
		//private int contador;
		public Casilla(int x,int y,String simbolo) {
			super(simbolo);
			pos = new Posicion(x, y);
			addMouseListener(this);
		}	
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		    if (e.getButton()==MouseEvent.BUTTON1){
		        //Se presiono el boton izquierdo
		    	System.out.println(pos);
		    	
		    	
		    	if(!tablero.isHayMina()) {
		    		if(!tablero.isGanoJuego()){
		    			if(contador==0) {
				    		tablero.iniciarPrimeraVez(pos);
				    		contador++;
				    		super.setText(tablero.getVista()[pos.getF()][pos.getC()]);
				    	}else {
				    		contador++;
				    		tablero.insertar(pos);
				    		super.setText(tablero.getVista()[pos.getF()][pos.getC()]);
				    	}
		    			
		    			actualizarElementos();
		    			
		    		}else {
		    			System.out.println("Gano el juego :)");
		    		}
		    	}else {
		    		System.out.println("Perdio el juego :(");
		    	}
		    	
		    	
		    	
		    }
		    if(e.getButton()==MouseEvent.BUTTON3){
		        //Se presiono el boton derecho
		    	System.out.println("derecho");
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
