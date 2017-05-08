package Scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*@author Christian Leunig */

public class Highscore {
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args){
		
		Score eintrag = new Score("Anna", 100);
		PrintStream aenderung = null;
		String einlesen = null;
		
		ArrayList<Score> punkteliste = new ArrayList<>();
		Scanner scan = null;
		FileOutputStream fos = null;
		try{
			scan = new Scanner(new File("C:\\penis\\penis.txt"));
			while(scan.hasNextLine()){
				einlesen=scan.nextLine();
				String[] werte = einlesen.split(" ");
				if(werte.length == 2){
					Score score = new Score(werte[0], Integer.parseInt(werte[1]));
					punkteliste.add(score);
				}
			}
			fos = new FileOutputStream(new File("C:\\penis\\penis"));
			aenderung = new PrintStream(fos);
			
			punkteliste.add(eintrag);
			Collections.sort(punkteliste);
			punkteliste.remove(10);
		
			StringBuilder sb = new StringBuilder();
			for(Score s : punkteliste){
				sb.append(s.toString()+ "\n");
			}
			aenderung.append(sb);
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage()+ "Datei konnte nicht gefunden werden");
		}finally{
			if(scan != null || aenderung != null || fos != null){    
				scan.close();
				aenderung.close();
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
