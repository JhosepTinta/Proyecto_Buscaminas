package modelo;

public class Posicion {
	private int fila;
    private int columna;
    public Posicion(int f, int c){
        fila=f;
        columna=c;
    }
    public int getF(){
        return fila;
    }
    public int getC(){
        return columna;
    }
    public boolean sonIguales(Posicion p2){
        boolean bb=false;
        if(fila==p2.getF()&&columna==p2.getC()){
            bb=true;
        }
        return bb;
    }
    public String toString() {
		return fila+","+columna;
	}
}