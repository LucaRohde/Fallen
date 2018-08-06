package application.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.FileChooser;

public class FileHandler {

	public final static FileChooser fileChooser = new FileChooser();
	
	
	// Gibt die erste Zeile des txt-Dokuments als ArrayList<String> zurück
	public static ArrayList<String> readOutString(String string) throws IOException {

		FileReader fr = new FileReader("src/application/resource/" + string);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> arrayListofWholeText = new ArrayList<String>();
		String readLine;
		while ((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			arrayListofWholeText.add(readLine);
		}
		fr.close();

		return arrayListofWholeText;
	}

	// Erstellt eine Txt im Resource Ordner
	public static void createFile(String nameOfFile) throws IOException {
		File f = new File("src/application/resource/" + nameOfFile);

		f.getParentFile().mkdirs();
		f.createNewFile();

	}

	public static void writeInFile(String nameOfFile, ArrayList<String> content) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;

		fw = new FileWriter("src/application/resource/" + nameOfFile);
		bw = new BufferedWriter(fw);
		for (int i = 0; i < content.size(); i++) {
			bw.write(content.get(i)+"\n");
		}

		if (bw != null)
			bw.close();

		if (fw != null)
			fw.close();
	}

}
