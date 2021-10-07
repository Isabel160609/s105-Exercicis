package S105Nivell1Ejemple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	static String [] nombres= {"Isabel","Josep","Ana","Pepe"};
	static int[] edad = {43,12,46,25};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file =new File("datosPersonas4.txt");
		PrintWriter printWriter=null;
		try {
			printWriter= new PrintWriter(new PrintWriter(file));
			for(int i=0;i<nombres.length;i++) {
				printWriter.println((i+1)+" "+nombres[i]+" "+edad[i]);
			}
		}catch(FileNotFoundException ex) {
			System.err.println("fichero no existe "+ex);
		}catch(IOException ex) {
			System.err.println("no es posible escribir en el fichero "+ex);
		}finally {
			if(printWriter!=null) {
				printWriter.close();
			}
		}
		
		BufferedReader bufferedReader=null;
		
		try {
			bufferedReader=new BufferedReader(new FileReader(file));
			
			String linea;
			
			while((linea=bufferedReader.readLine())!=null) {
				System.out.println(linea);
			}
		}catch(FileNotFoundException ex){
			System.err.println("fichero no existe "+ex);
		}catch(IOException ex) {
			System.err.println("no es posible escribir en el fichero "+ex);
		}finally {
			
			try {
				bufferedReader.close();
			} catch (IOException ex) {
				System.err.println("no es posible escribir en el fichero "+ex);;
			}
		}
	}
	
}
