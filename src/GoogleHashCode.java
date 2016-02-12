import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GoogleHashCode {

	public static void main(String[]args) throws IOException
	{
//		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
//		BufferedReader in = new BufferedReader(new FileReader("logo.in"));
		BufferedReader in = new BufferedReader(new FileReader("right_angle.in"));
//		BufferedReader in = new BufferedReader(new FileReader("learn_and_teach.in"));
		
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
//		r.printInput();

		System.out.println();
		
//		System.out.println(r.calculateCanvas());
//		r.printCanvas();
		
		
		/* Stan's Code Here */
		ArrayList<Vector> vectors = new VectorGenerator(board).generateVectors();
		
		/* Print size of list */
		System.out.println("Number of vectors:" + vectors.size());
		
		/* Sort array in ascending order */
		Collections.sort(vectors);
		
		
		
		int counter = 0;
		ArrayList<String> operations = new ArrayList<String>();
		for(Vector vector: vectors)
		{
			int[] start = vector.getStartPosition();
			int[] end = vector.getEndPosition();
			if(r.canDrawVectorOnBoard(vector))
			{
				System.out.println("start:(" + start[0] + ", " + start[1] + ") , end:(" + end[0] + ", " +end[1]+ ")");
				operations.add(r.writeLine(start[0], start[1], end[0], end[1]));
				counter++;
			}
			else 
				continue;
		}
//		r.printCanvas();
		System.out.println("Number of instructions = " + counter);
		System.out.println("Points earned = "+ (rows*cols - counter));
		System.out.println("Canvas are matched:" + r.compareInputWithOutput());
		File file = new File("rigthAngleOutput.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(operations.size() + "\n");
        for(String str:operations){
        	bw.write(str + "\n");
        }
        
        bw.close();

	}
	
}
