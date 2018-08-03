package application.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {

	
	//Gibt die erste Zeile des txt-Dokuments als String zurück
	public static String readOutString(String string) throws IOException {
		
		FileReader fr = new FileReader("src/application/resource/"+string+".txt"); 
		BufferedReader br = new BufferedReader(fr); 
		String s; 
		while((s = br.readLine()) != null) { 
		System.out.println(s);
		return s;
		} 
		fr.close(); 
		
		return s;
	}

}
