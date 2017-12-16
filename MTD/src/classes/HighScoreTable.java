package classes;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HighScoreTable {
	
	public HighScoreTable()
	{

	}
	
	public void addScore(int score)
	{
		try {
			FileWriter writer = new FileWriter("highscores.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
bufferedWriter.write("sülo");
			//bufferedWriter.append("asdas");
			bufferedWriter.write("HighScore: " + score);
			bufferedWriter.newLine();
			//System.out.println("SÜLOOOOOOOo");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
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
