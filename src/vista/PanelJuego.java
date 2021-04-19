package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;


//import control.Controlador;

public class PanelJuego extends JPanel{

	private int csdf = 0;
	
	private Image portada = new ImageIcon(getClass().getResource("/imagenes/vistaJuego.jpg")).getImage();
	private PanelTablero panelTablero;
	private JButton rendirse;
	private JButton volverInicio;
	private JLabel tiempo;
	private static JLabel cantBanderas;
	//private Controlador controlJuego;
	
	public static Hilo miHilo;
	public static int cantBanderasNum;
	
	public PanelJuego() {
		//controlJuego = new Controlador(this);
		rendirse = new JButton(new ImageIcon(getClass().getResource("/imagenes/rendirse.png")));
		volverInicio = new JButton(new ImageIcon(getClass().getResource("/imagenes/volver.png")));
		tiempo = new JLabel("00");
		cantBanderas = new JLabel("10");
		cantBanderasNum = 10;
		panelTablero  = new PanelTablero(8,8,12);
		setLayout(null);
		agregarComponentes();
		miHilo = new Hilo();
	}
	
	public void paint(Graphics g) {
		g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	private void agregarComponentes() {
		add(panelTablero);
		rendirse.setBounds(822, 380, 233, 60);
		rendirse.setOpaque(false);
		rendirse.setContentAreaFilled(false);
		rendirse.setBorderPainted(false);
		volverInicio.setBounds(822, 470, 233, 60);
		volverInicio.setOpaque(false);
		volverInicio.setContentAreaFilled(false);
		volverInicio.setBorderPainted(false);
		tiempo.setBounds(950, 80, 60, 20);
		tiempo.setForeground(new Color(255,255,255));
		tiempo.setFont(new Font("Century Gothic",0,24));
		cantBanderas.setBounds(960, 160, 40, 20);
		cantBanderas.setForeground(new Color(255,255,255));
		cantBanderas.setFont(new Font("Century Gothic",0,24));
		add(rendirse);
		add(volverInicio);
		add(tiempo);
		add(cantBanderas);
	}
	
	public JButton darVolver() {
		return volverInicio;
	}
	
	public JButton darRendirse() {
		return rendirse;
	}
	
	public void modificarTamañoTablero(int x,int y,int w,int h) {
		panelTablero.setBounds(x, y, w, h);
	}
	
	public static void iniciarTiempo(boolean bb) {
		//tiempo.setText(t);
		if(bb) {
			miHilo.start();
		}else {
			miHilo.setPausado(true);
		}
		
	}
	
	public static boolean gastarBandera() {
		cantBanderasNum--;
		boolean bb = false;
		if(cantBanderasNum>=0) {
			bb = true;
			cantBanderas.setText(""+cantBanderasNum);
		}
		return bb;
	}

	
	class Hilo extends Thread {
	    private boolean pausado;
	    //private Button conexion;
	    private String tiempoVar;

	    //private Hand handler;

	    public Hilo(){
	        //conexion = button;
	        pausado = false;
	        //handler = new Hand(button);
	    }

	    public void run(){
	        int minutos = 0, segundos = 0;
	        while(!pausado){
	            try {
	                ponerTiempoBoton(minutos, segundos);
	                
	                segundos++;
	                
	                if(segundos==60){
	                    segundos = 0;
	                    minutos++;
	                    /*if(minutos == 1){
	                        pausado = true;
	                    }*/
	                }

	                this.sleep(1000);
	            } catch (Exception ex) {
	                //Toast.makeText(JugarOnline.this, "Algo salió mal", Toast.LENGTH_SHORT).show();
	            }
	        }
	    }

	    private void ponerTiempoBoton(int minutos, int segundos){

	        if(segundos<60&&minutos==0) {
	        	if(segundos<10){
	            	tiempoVar = "0"+segundos;
	            }else{
	            	tiempoVar = ""+segundos;
	            }
	        }else if(minutos<60){//cantidad limite minutos
	            if(segundos<10){
	            	tiempoVar = minutos+":0"+segundos;
	            }else{
	            	tiempoVar = minutos+":0"+segundos;
	            }

	        }else{
	            tiempoVar = "Fin del Juego";
	            //handler.setHcron(tiempoVar);
	            //handler.act();
	            //conexion.callOnClick();
	            pausado= true;
	            //Toast.makeText(this, "tiempo pausado por true", Toast.LENGTH_SHORT).show();
	        }
	        
	        //System.out.println(tiempoVar);
	        //tiempo.setText(tiempoVar);

	        tiempo.setText(tiempoVar);
	        
	        //handler.setHcron(tiempoVar);
	        //handler.act();

	    }

	    public void setPausado(boolean bb){
	        pausado = bb;
	    }

	    public String getTiempoVar(){
	        return tiempoVar;
	    }
	    
	    
	    
	}
	
}
