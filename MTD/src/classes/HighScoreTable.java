package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoreTable {
	
	public HighScoreTable()
	{

	}
	
	public void addScore(int score)
	{
		try {
			FileWriter writer = new FileWriter("highscores.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			//bufferedWriter.write("sülo");
			//bufferedWriter.append("asdas");
			bufferedWriter.write("Name: Anonymous, Score: ");
			bufferedWriter.newLine();
			bufferedWriter.write("" + score);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void putScoreOnTable(int score)
	{
		addScore(score);
		
		try {
			///READ/////////////////////////
			ArrayList<Integer> allScores = new ArrayList<Integer>();
			
			BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
			String line = br.readLine();
			//System.out.println(line);
			line = br.readLine();
			//System.out.println(line);
			allScores.add(Integer.parseInt(line));
			line = br.readLine();
			//System.out.println(line);
			while(line!=null)
			{
				line = br.readLine();
				//System.out.println(line);
				allScores.add(Integer.parseInt(line));
				//int nextScore = Integer.parseInt(line);
				line = br.readLine();
				System.out.println(line);
			}
			
			
			br.close();
			//SORT THE LIST
			Collections.sort(allScores);
			/// CLEAR THE FILE
			PrintWriter pw = new PrintWriter("highscores.txt");
			
			/// WRITE THE SORTED SCORES TO THE TXT FILE
			for(int i=allScores.size() - 1; i>=0; i--)
			{
				addScore(allScores.get(i));
				//System.out.println("ALL SCORES " + allScores.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public String getHighScoreContents()
	{
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
			String line = br.readLine();
			if(line!=null)
			{
				s = s+line;
				s = s+ "\n";
			}
			while(line!=null)
			{
				line = br.readLine();
				s = s+ "\n";
				s = s+line;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public void givenUsingJava7_whenWritingToFile_thenCorrect() 
			  throws IOException {
			    String str = "Hello";
			 
			    Path path = Paths.get("highscores.txt");
			    byte[] strToBytes = str.getBytes();
			 
			    Files.write(path, strToBytes);
			 
			    String read = Files.readAllLines(path).get(0);
			    //assertEquals(str, read);
			}
	private String scoreFile = "highscores.txt";
	
	public void writeScore(int score)
	{

	}


}
