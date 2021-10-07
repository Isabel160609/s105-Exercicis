/*Exercici 2. Afegeixi a la classe del nivell anterior la funcionalitat de llistar un arbre de directoris amb el contingut 
 * de tots els seus nivells (recursivamente) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell, 
 * indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.*/
package s105Nivell1Exercici2;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Date;

public class Main {
	   public static void main(String[] args) {
	    	
	        listarContenidoDirectorio(new File("C:/prova"));
	        
	    }
	   
	    public static void listarContenidoDirectorio(File directorio) {
	    	//imprimimos el directorio con su tipo y hora de ultima modificacion
	        System.out.println("D " + directorio+" "+ new Date(directorio.lastModified()));
	        //creamos un array con los archivos que hay dentro
	        File[] listado = directorio.listFiles();
	        
	        if (listado!=null) {
	        	//recorremos la lista de achivos
	            for(File file:listado) {
	            	//si lo que encontramos es un directorio llamamos recursivamente a la funcion listarContenidoDirectorio
	                if (file.isDirectory())
	                	listarContenidoDirectorio(file);
	                //si son archivos pedimos que los imprima
	                else {
	                	
	                    System.out.println("F "+file+ " "+new Date(file.lastModified()));
	                }
	            }
	        }

	    }
	}
