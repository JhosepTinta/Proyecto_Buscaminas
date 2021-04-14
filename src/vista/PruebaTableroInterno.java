package vista;

import java.util.Scanner;

public class PruebaTableroInterno {
	public static void main(String[] args) {

		TableroInterno tablero = new TableroInterno(9, 9);
		
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int c = sc.nextInt();
		
		tablero.iniciarPrimeraVez(new Posicion(f,c));
		
	}
}
