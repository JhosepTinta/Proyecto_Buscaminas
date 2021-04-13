package vista;

import java.awt.BorderLayout;

import javax.swing.*;

public class Cabecera extends JPanel{
	private JLabel tiempo =  new JLabel();
	private JButton boton = new JButton("iniciar");

	public Cabecera() {
		setLayout(new BorderLayout());
		add(new JLabel("nivel"),BorderLayout.CENTER);

		add(tiempo,BorderLayout.EAST);
		Hilos hilo = new Hilos();
		hilo.start();
		
	}
	
	
		class Hilos extends Thread {
		    private boolean pausado;
		    //private Button conexion;
		    private String tiempoVar;

		    //private Hand handler;

		    public Hilos(){
		        //conexion = button;
		        pausado = false;
		        //handler = new Hand(button);
		    }

		    public void run(){
		        int minutos = 0, segundos = 0, centesimas = -1;
		        while(!pausado){
		            try {
		                centesimas++;
		                ponerTiempoBoton(minutos, segundos, centesimas);
		                if(centesimas == 99){
		                    segundos++;
		                    centesimas = -1;
		                    if(segundos==60){
		                        segundos = 0;
		                        minutos++;
		                        /*if(minutos == 1){
		                            pausado = true;
		                        }*/
		                    }
		                }

		                this.sleep(9, 600000);
		            } catch (Exception ex) {
		                //Toast.makeText(JugarOnline.this, "Algo salió mal", Toast.LENGTH_SHORT).show();
		            }
		        }
		    }

		    private void ponerTiempoBoton(int minutos, int segundos, int centesimas){

		        if(segundos<60&&minutos==0) {
		            if (centesimas < 10) {
		                tiempoVar = segundos+".0"+centesimas;
		            }else{
		                tiempoVar = segundos+"."+centesimas;
		            }
		        }else if(minutos<60){//cantidad limite minutos
		            if(segundos<10){
		                if (centesimas < 10) {
		                    tiempoVar = minutos+":0"+segundos+".0"+centesimas;
		                }else{
		                    tiempoVar = minutos+":0"+segundos+"."+centesimas;
		                }
		            }else{
		                if (centesimas < 10) {
		                    tiempoVar = minutos+":"+segundos+".0"+centesimas;
		                }else{
		                    tiempoVar = minutos+":"+segundos+"."+centesimas;
		                }
		            }

		        }else{
		            tiempoVar = "Fin del Juego";
		            //handler.setHcron(tiempoVar);
		            //handler.act();
		            //conexion.callOnClick();
		            pausado= true;
		            //Toast.makeText(this, "tiempo pausado por true", Toast.LENGTH_SHORT).show();
		        }
		        
		        System.out.println(tiempoVar);
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

