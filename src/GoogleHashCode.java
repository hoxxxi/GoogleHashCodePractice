import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GoogleHashCode {

	public static void main(String[]args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\input.txt"));
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
	}
}
