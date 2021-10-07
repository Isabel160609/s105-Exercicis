/*Exercici 3. Executi l'exercici anterior guardant a un fitxer txt el resultat*/
package s105Nivell1Exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class Main {
	static FileWriter fw;

	public static void main(String[] args) throws IOException {
		//creamos un archivo de texto
		fw = new FileWriter(new File("c:/prova/pepe.txt"));
		//llamamos a la funcion para que nos escriba el contenido dentro
		listarContenidoDirectorio(new File("C:/xampp/htdocs"));
		//cerramos la escritura
		fw.close();
	}
	//funcion para escribir en un fichero
	public static void agregaFichero(String st) {
		try {
			fw.append(st + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//funcion de listar el contenido
	public static void listarContenidoDirectorio(File directorio) {
		//aqui ademas de listar el contenido llamamos a la funcion de escribir para que lo añada en nuestro fichero
		agregaFichero("D " + directorio + " " + new Date(directorio.lastModified()));
		System.out.println("D " + directorio + " " + new Date(directorio.lastModified()));
		File[] listado = directorio.listFiles();
		if (listado != null) {
			for (File file : listado) {
				if (file.isDirectory())
					listarContenidoDirectorio(file);
				else {
					//aqui cuando haya un archivo tambien llamamos a la funcion escribir para que mo introduzca en e archivo
					System.out.println("F " + file + " " + new Date(file.lastModified()));
					agregaFichero("F " + file + " " + new Date(file.lastModified()));
				}
			}
		}
	}

}
