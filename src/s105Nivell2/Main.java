/*Executi l'exercici 1 del nivell anterior parametritzant tots els mètodes en un file de configuració. Pot utilitzar un file
 *  Java Properties, o bé la llibreria Apache Commons Configuration si ho desitja. De l'exercici anterior, parametritzi el
 *   següent:

Directori a llegir
Arbre de directoris a llegir
Nom i directori del fitxer txt resultant
Nom i directori del fitxer txt a llegir*/
package s105Nivell2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

public class Main {

	static FileWriter fw;

	public static void main(String[] args) throws IOException {
		
		 Properties properties= new Properties();
		 String fileCreado="";
		 String fileRecorrer="";
		    try {
		      properties.load(new FileInputStream(new File("configuracion.txt")));
		      
		     fileCreado=(String) properties.get("FILECREADO");
		     fileRecorrer=(String) properties.get("FILERECORRER");
		     
		    } catch (FileNotFoundException ex) {
		      // TODO Auto-generated catch block
		      ex.printStackTrace();
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		// creamos un archivo de texto
		fw = new FileWriter(new File(fileCreado));
		// llamamos a la funcion para que nos escriba el contenido dentro
		listarContenidoDirectorio(new File(fileRecorrer));
		// cerramos la escritura
		fw.close();
	}

	// funcion para escribir en un fichero
	public static void agregaFichero(String st) {
		try {
			fw.append(st + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// funcion de listar el contenido
	public static void listarContenidoDirectorio(File directorio) {
		// aqui ademas de listar el contenido llamamos a la funcion de escribir para que
		// lo añada en nuestro fichero
		agregaFichero("D " + directorio + " " + new Date(directorio.lastModified()));
		System.out.println("D " + directorio + " " + new Date(directorio.lastModified()));
		File[] listado = directorio.listFiles();
		if (listado != null) {
			for (File file : listado) {
				if (file.isDirectory())
					listarContenidoDirectorio(file);
				else {
					// aqui cuando haya un archivo tambien llamamos a la funcion escribir para que
					// mo introduzca en e archivo
					System.out.println("F " + file + " " + new Date(file.lastModified()));
					agregaFichero("F " + file + " " + new Date(file.lastModified()));
				}
			}
		}
	}
}
