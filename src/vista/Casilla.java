package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Casilla extends JButton implements MouseListener{
	private Posicion pos;
	public Casilla(int x,int y) {
		pos = new Posicion(x, y);
		addMouseListener(this);
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	    if (e.getButton()==MouseEvent.BUTTON1){
	        //Se presiono el boton izquierdo
	    	System.out.println(pos.getPosicion());
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
