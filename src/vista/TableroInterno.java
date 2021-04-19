package vista;

import java.util.ArrayList;

import modelo.Posicion;

public class TableroInterno {
	
	private int Dise�o[][];//almacena los datos internos del juego
    private String Vista[][];//almacena los datos a mostrarse para el usuario
    
    private ArrayList<Posicion>PosMinas;//almacena las posiciones de todas las minas
    private Posicion pos_ini;//almacena la posicion inicial que ingresa el usuario
    
    private boolean hayMina;
    private boolean ganoJuego;
    
    private int cantidadMinas;
    
    public TableroInterno(int filas, int columnas, int cantidadMinas){
        Dise�o=new int[filas][columnas];
        Vista=new String[filas][columnas];
        PosMinas=new ArrayList();
        hayMina = false;
        ganoJuego = false;
        this.cantidadMinas = cantidadMinas;
    }
    
    public void iniciarPrimeraVez(Posicion p) {
    	pos_ini = p;
    	llenarVistaInicial();
        imprimir(Vista);
        llenarMinas();
        llenarDise�o();
        llenarVista(p);
    	explosionBlancos(p.getF(), p.getC());
    	imprimir(Dise�o);
    	imprimir(Vista);
    }
    
    public void insertar(Posicion p) {
    	
    	if(!ganoElJuego()) {
    		if(Dise�o[p.getF()][p.getC()]==9) {
    			hayMina = true;
    			Vista[p.getF()][p.getC()]="F";
    			imprimir(Dise�o);
                imprimir(Vista);
                System.out.println("Fin del Juego, perdiste :')");
	        }else{
	            explosionBlancos(p.getF(),p.getC());
	            imprimir(Dise�o);
	            imprimir(Vista);
	        
	    	}
    		
    		ganoElJuego();
    		
	    }
    
    	
   
    }
    
    /*public void jugar(){
        PedirDato d=new PedirDato(Dise�o.length, Dise�o[0].length);
        llenarVistaInicial();
        imprimir(Vista);
        System.out.print("Ingrese la Fila: ");
        int f=d.setF();
        System.out.print("Ingrese la Columna: ");
        int c=d.setC();
        pos_ini=new Posicion(f,c);
        llenarMinas();
        llenarDise�o();
        llenarVista(pos_ini);
        
        explosionBlancos(pos_ini.getF(),pos_ini.getC());
        imprimir(Dise�o);
        imprimir(Vista);
        
        boolean noMina=true;
        while(noMina){
            if(sePuedeJugar()){
                System.out.print("Ingrese la Fila: ");
                f=d.setF();
                System.out.print("Ingrese la Columna: ");
                c=d.setC();
                if(Dise�o[f][c]==9){//el numero 9 representa la bomba
                    noMina=false;
                    Vista[f][c]="F";
                    imprimir(Dise�o);
                    imprimir(Vista);
                    System.out.println("Fin del Juego, perdiste :')");
                }else{
                    explosionBlancos(f,c);
                    imprimir(Dise�o);
                    imprimir(Vista);
                }
            }else{
                System.out.println("Felicidades, has ganado");
                noMina=false;
            }
        }
    }*/ 
    
       
    /**llenarVistaInicial**/
    //llenarVistaInicial___llena la matriz de la vista del usuario con *
    private void llenarVistaInicial(){
        for(int i=0;i<Vista[0].length;i++){
            for(int j=0;j<Vista.length;j++){
                Vista[i][j]="*";
            }
        }
    }
    /**llenarMinas**/
    //generamos posicones aleatorias en la matriz para colocar las minas
    private void llenarMinas(){
        genPosMinas();
        insertarminas();
    }
    //genPosMinas
    private void genPosMinas(){
        for(int i=0;i<cantidadMinas;i++){
            Posicion aux=generar();
            if(i>0){
                boolean hay=buscar(aux,i);
                while(hay||aux.sonIguales(pos_ini)){
                    aux=generar();
                    hay=buscar(aux,i);
                }
            }
            PosMinas.add(aux);
        }
    }
    private Posicion generar(){
        int f=(int)(Math.random()*Vista[0].length);
        int c=(int)(Math.random()*Vista.length);
        return new Posicion(f,c);
    }
    private boolean buscar(Posicion n, int j){
        boolean res=false;
        for(int i=0;i<j&&!res;i++){
            if(n.sonIguales(PosMinas.get(i))){
                res=true;
            }
        }
        return res;
    }
    //insertarminas
    private void insertarminas(){
        for(int i=0;i<PosMinas.size();i++){
            Dise�o[PosMinas.get(i).getF()][PosMinas.get(i).getC()]=9;
        }
    }
    /**llenarDise�o**/
    private void llenarDise�o(){
        insertContMinas();        
    }
    private void insertContMinas(){
        for(int i=0;i<Dise�o[0].length;i++){
            for(int j=0;j<Dise�o.length;j++){
                if(noesMina(i,j)){
                    Dise�o[i][j]=buscarminas(i,j);
                }
            }
        }
    }    
    private boolean noesMina(int i, int j){
        boolean res=false;
        for(int k=0;k<PosMinas.size()&&!res;k++){
            if(PosMinas.get(k).getF()==i&&PosMinas.get(k).getC()==j){
                res=true;
            }
        }
        return !res;
    }
    private int buscarminas(int f, int c){
        ArrayList<Posicion>movimientos=new ArrayList();
        movimientos.add(new Posicion(1,-1));
        movimientos.add(new Posicion(0,-1));
        movimientos.add(new Posicion(-1,-1));
        movimientos.add(new Posicion(-1,0));
        movimientos.add(new Posicion(-1,1));
        movimientos.add(new Posicion(0,1));
        movimientos.add(new Posicion(1,1));
        movimientos.add(new Posicion(1,0));
        int cont=0;
        for(int i=0;i<movimientos.size();i++){
            int pruebaF=movimientos.get(i).getF()+f;
            int pruebaC=movimientos.get(i).getC()+c;
            if((pruebaF>=0&&pruebaF<Dise�o.length)&&(pruebaC>=0&&pruebaC<Dise�o[0].length)){
                if(Dise�o[pruebaF][pruebaC]==9){
                    cont++;
                }
            }
        }
        return cont;
    }
    
    private boolean ganoElJuego() {
        int c=0;
        for(int i=0;i<Vista[0].length;i++){
            for(int j=0;j<Vista.length;j++){
                if(Vista[i][j].equals("*")){
                    c++;
                }
            }
        }
        
        ganoJuego = c == cantidadMinas;
        
        if(ganoJuego) {
        	System.out.println("Felicidades, has ganado");
        }
        
        return ganoJuego;
    }
    
    /*private boolean sePuedeJugar(){//verificamos si a�n existen numeros que no sean minas
        boolean res=false;
        int c=0;
        for(int i=0;i<Vista[0].length;i++){
            for(int j=0;j<Vista.length;j++){
                if(Vista[i][j].equals("*")){
                    c++;
                }
            }
        }
        return c>12;
    }*/
    /**llenarVista**/
    private void llenarVista(Posicion pos){
        explosionBlancos(pos.getF(),pos.getC());
    }
    private void explosionBlancos(int f, int c){//probar con fila 0, columna 4
        if(f>=0&&f<Dise�o.length){
            if(c>=0&&c<Dise�o[f].length){
                if(Dise�o[f][c]==0){ //si posicion es un blanco
                    Vista[f][c]=""+Dise�o[f][c];
                    Dise�o[f][c]=-5; //lo colocamos como una marca para las explosiones
                    explosionBlancos(f-1,c-1);
                    explosionBlancos(f-1,c);
                    explosionBlancos(f-1,c+1);
                    explosionBlancos(f,c+1);
                    explosionBlancos(f+1,c+1);
                    explosionBlancos(f+1,c);
                    explosionBlancos(f-1,c-1);
                    explosionBlancos(f+1,c-1);
                    explosionBlancos(f,c-1);
                }
                if(Dise�o[f][c]>0&&Dise�o[f][c]!=9){ //si no es parte de  la explosion y tampoco es mina
                    Vista[f][c]=""+Dise�o[f][c];
                }
            }
        }  
    }
    /**imprimir**/
    //para la matriz Dise�o
    private void imprimir(int z[][]){
        System.out.println("______Vista Dise�o______");
        System.out.println("    1__2__3__4__5__6__7__8__9");
        for(int i=0;i<z[0].length;i++){
            for(int j=0;j<z.length;j++){
                if(j==0){
                    System.out.print("|"+(i+1)+"|");
                }
                if(z[i][j]!=-5){
                    System.out.print(" "+z[i][j]+" ");
                }else{
                    System.out.print(z[i][j]+" ");
                }
            }
            System.out.println("");
        }
    }
    //para la matriz Vista
    private void imprimir(String z[][]){
        System.out.println("______Vista juego______");
        System.out.println("    1__2__3__4__5__6__7__8__9");
        for(int i=0;i<z[0].length;i++){
            for(int j=0;j<z.length;j++){
                if(j==0){
                    System.out.print("|"+(i+1)+"|");
                }
                System.out.print(" "+z[i][j]+" ");
            }
            System.out.println("");
        }
    }

	public int[][] getDise�o() {
		return Dise�o;
	}

	public void setDise�o(int[][] dise�o) {
		Dise�o = dise�o;
	}

	public String[][] getVista() {
		return Vista;
	}

	public void setVista(String[][] vista) {
		Vista = vista;
	}

	public ArrayList<Posicion> getPosMinas() {
		return PosMinas;
	}

	public void setPosMinas(ArrayList<Posicion> posMinas) {
		PosMinas = posMinas;
	}

	public Posicion getPos_ini() {
		return pos_ini;
	}

	public void setPos_ini(Posicion pos_ini) {
		this.pos_ini = pos_ini;
	}

	public boolean isHayMina() {
		return hayMina;
	}

	public void setHayMina(boolean hayMina) {
		this.hayMina = hayMina;
	}

	public boolean isGanoJuego() {
		return ganoJuego;
	}

	public void setGanoJuego(boolean ganoJuego) {
		this.ganoJuego = ganoJuego;
	}
    
    
	public String[][]getVistaFinal(){
		String res[][]= new String[Vista[0].length][Vista.length];
		
        for(int i=0;i<Vista[0].length;i++){
            for(int j=0;j<Vista.length;j++){
            	res[i][j]=Vista[i][j];
            	if(Dise�o[i][j]==9) {
            		res[i][j]="F";
            	}
            }
        }
        
        imprimir(res);
		
		return res;
	}
    
}
