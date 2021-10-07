/*Exercici 1. Creu una classe Java que llisti el contingut d'un directori rebut per paràmetre ordenat alfabèticament.*/
package s105Nivell1Exercici1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
    public static void main(String[] args) {
    	
    	listarContenidoDirectorio(new File("C:/"));
        
    }
    //creamos una funcion para listar el contenido del directorio
    public static void listarContenidoDirectorio(File directorio) {
        //creamos un array con todo el contenido del directorio
        File[] listado = directorio.listFiles();
        
        //para ordenarlo lo pasamos a un arrayList
        ArrayList <String>listadoOrdenado=new ArrayList();
        for(File file:listado) {
        	listadoOrdenado.add(file.getName());
        }
        //ordenamos con sort
        Collections.sort(listadoOrdenado);
        
        //imprimimos todo lo que hay en la lista
        if (listadoOrdenado!=null) {
            for(String file:listadoOrdenado) {
                    System.out.println(file);
                
            }
        }

    }
}
