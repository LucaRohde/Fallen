package application.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	public static void createFile(String pathOfFile) throws IOException {
		File f = new File("src/application/resource/" + pathOfFile);

		f.getParentFile().mkdirs();
		f.createNewFile();

	}

	public static void writeInFile(String pathOfFile, ArrayList<String> content) throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;

		fw = new FileWriter("src/application/resource/" + pathOfFile);
		bw = new BufferedWriter(fw);
		for (int i = 0; i < content.size(); i++) {
			bw.write(content.get(i) + "\n");
		}

		if (bw != null)
			bw.close();

		if (fw != null)
			fw.close();
	}

	// returns every name of the files in the folder as an observable list
	public static ObservableList<String> getNameOfFilesInFolder(String pathOfFolder) {

		File[] listOfFiles = new File("src/application/resource/"+pathOfFolder).listFiles();
		ObservableList<String> obsList =  FXCollections.observableArrayList();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				obsList.add(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				
			}

		}
		return obsList;
	}
}
