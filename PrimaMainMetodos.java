package entornos;

import java.util.Scanner;

/**
 * 
 * <h1>Programa en JAVA</h1>
 *
 *<P> Se trata de calcular las primas que corresponden a un conjunto de empleados de una empresa según un conjunto de normas</P>
 * 
 *<p> Los parametros se introducen por el teclado</p>
 * 
 * 
 * @author jrubioa
 * @version 1.0
 *
 */

public class PrimaMainMetodos {
	

	/**
	 * Llamamiento al teclado para poder insertar valores por consola. Por tanto, es una variable estatica
	 */
	static Scanner teclado=new Scanner(System.in);

	/**
	 * Metodo principal (main)
	 * @param args
	 */
	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;
		

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			
			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');		
	}


	/**
	 * Metodo llamado hallarPrima. Halla el tipo de prima
	 * @param esDirectivo - valor ingresado por el usuario. En este caso tiene que ser de tipo char
	 * @param meses - valor ingresado por el usuario. En este caso tiene que ser de tipo int
	 * @return - valor que retona este metodo en funcion de sus parametros de entrada. En este caso es un String:
	 * P1 a los directivos con, al menos, 12 meses de antigüedad
	 * P2 a los no directivos con, al menos, 12 meses de antigüedad
     * P3 a los directivos sin un mínimo de 12 meses de antigüedad
     * P4 a los no directivos sin un mínimo de 12 meses de antigüedad
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

	
	/**
	 * Metodo leerNumEmple
	 * @return - valor que retona este metodo. En este caso retorna numEmple
	 */
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	
	/**
	 * Metodo leerNomEmple
	 * @return - valor que retona este metodo. En este caso retorna nomEmple
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	

	/**
	 * Metodo leerMeses
	 * @return - valor que retona este metodo. En este caso retorna meses
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	

	/**
	 * Metodo leerEsDirectivo
	 * @return - valor que retona este metodo. En este caso esDirectivo
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}
