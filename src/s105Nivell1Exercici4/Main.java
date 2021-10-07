/*Exercici 4. Afegeixi la funcionalitat de llegir qualsevol fitxer txt i mostrar per consola el seu contingut.*/
package s105Nivell1Exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//llamamos a la funcion introduciendo la ruta del archivo que deseamos
		LeerTxt(new File("c:/prova/pepe.txt"));
	}

	static void LeerTxt(File file) {
		
		// inicializamos el lector
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(file));

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException ex) {
			System.err.println("fichero no existe " + ex);
		} catch (IOException ex) {
			System.err.println("no es posible escribir en el fichero " + ex);
		} finally {

			try {
				bufferedReader.close();
			} catch (IOException ex) {
				System.err.println("no es posible escribir en el fichero " + ex);
				;
			}
		}
	}
}
