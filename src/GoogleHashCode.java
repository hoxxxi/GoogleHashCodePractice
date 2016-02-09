import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GoogleHashCode {

	public static void main(String[]args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String row_col[] = in.readLine().split(" ");

		int rows = Integer.parseInt(row_col[0]);
		int cols = Integer.parseInt(row_col[1]);
		
		String board[][] = new String[rows][cols];
		
		for(int i = 0; i < rows; i++)
		{
			board[i] = in.readLine().split("");
		}	
		in.close();
				
		Robot r = new Robot(board);
		r.printInput();

		System.out.println();
		
		System.out.println(r.calculateCanvas());
		r.printCanvas();
		
		
		/* Stan's Code Here */
		ArrayList<Vector> vectors = new VectorGenerator(board).generateVectors();
		
		/* Print size of list */
		System.out.println("Number of vectors:" + vectors.size());
		
		/* Sort array in ascending order */
		Collections.sort(vectors);
		
		for(Vector vector: vectors)
		{
			System.out.println(vector.getLength());
		}
	}
}
