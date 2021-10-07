/*Exercici 5. Mostri com serialitzar un Objecte Java a un fitxer .ser i deserialícelo després.*/
package s105Nivell1Exercici5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	static String[] nombres = { "Isabel", "Josep", "Ana", "Pepe" };
	static int[] edad = { 43, 12, 46, 25 };

	public static void main(String[] args) {
		//aqui esta la serializacion de escritura
		
		//creamos el fichero donde escribir
		File file=new File("c:/prova/prova.ser");
		//el archivo y el objeto
		FileOutputStream fileOut=null;
		ObjectOutputStream dataOut=null;
		
		try {
			//abrimos Stream y escribimos el objeto en el archivo
			fileOut= new FileOutputStream(file);
			dataOut=new ObjectOutputStream(fileOut);
			for(int i=0;i<nombres.length;i++) {
				Persona persona=new Persona(nombres[i],edad[i]);
			dataOut.writeObject(persona);
			}
			//capturamos todos los errores posibles
		}catch(FileNotFoundException ex) {
			System.err.println("fichero no existe "+ex);
		}catch(IOException ex) {
			System.err.println("no es posible escribir en el fichero "+ex);
		}finally {
			//cerramos todo
			try {
				fileOut.close();
				dataOut.close();
			}catch(IOException ex) {
				System.err.println("no es posible cerrar el fichero "+ex);
			}
		}
		
		//aqui esta la serializacion de lectura
		
		//creamos el archivo para leer archibo y objeto
		FileInputStream fileIn=null;
		ObjectInputStream dataIn=null;
		//lo abrimos
		try {
			fileIn=new FileInputStream(file);
			dataIn = new ObjectInputStream(fileIn);
			
			try {
				//mientras haya objetos leemos y sacamos por pantalla
				while(true) {
					Persona persona =(Persona) dataIn.readObject();
					System.out.println(persona.toString());
				}
				//capturamos excepciones
			}catch(EOFException ex){
				System.out.println("fin de fichero detectado");
			}
		}catch(FileNotFoundException ex) {
			System.err.println("fichero no existe "+ex);
		}catch(IOException ex) {
			System.err.println("Error I/O "+ex);
		}catch(ClassNotFoundException ex) {
			System.err.println("clase no encontrada"+ex);
		}finally {
			try {
				//cerramos todo
				fileIn.close();
				dataIn.close();

			}catch(IOException ex) {
				System.err.println("No es posible cerrar el fichero"+ex);
			}
		}
	}

}
