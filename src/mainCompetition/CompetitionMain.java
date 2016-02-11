package mainCompetition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompetitionMain {

	public static void main(String[] args) throws IOException {
		
		/* ====================== Reading input file ====================== */
		BufferedReader in = new BufferedReader(new FileReader("competition.txt"));
		String row_col[] = in.readLine().split(" ");

		int rows = Integer.parseInt(row_col[0]);
		int cols = Integer.parseInt(row_col[1]);
		
		String board[][] = new String[rows][cols];
		
		for(int i = 0; i < rows; i++)
		{
			board[i] = in.readLine().split("");
		}	
		in.close();
		/* ====================== Reading file finished ====================== */
		
		
		
	}

}
