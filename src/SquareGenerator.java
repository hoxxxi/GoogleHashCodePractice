import java.util.ArrayList;

public class SquareGenerator {
	String[][] inputCanvas;
	int rows, cols;
	ArrayList<Square> squaresGenerated;

	public SquareGenerator(String input[][]) {
		this.inputCanvas = input;
		this.rows = input.length;
		this.cols = input[0].length;
		this.squaresGenerated = new ArrayList<Square>();
	}

	public ArrayList<Square> generateSquares() {
		
		for (int m = Math.min(rows,cols); m >= 1; m--) {
			int searchSize = m;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {

					if (inputCanvas[i][j].equals("#")) {
						if (i - searchSize >= 0 && i + searchSize < rows
								&& j - searchSize >= 0 && j + searchSize < cols) {
							int painted = 0;
							for (int k = i - searchSize; k < i + searchSize; k++) {
								for (int l = j - searchSize; l < j + searchSize; l++) {
									if (inputCanvas[k][l].equals("#"))
										painted++;
								}
							}
						
							if (painted >= (2 * searchSize + 1)
									* (2 * searchSize + 1) * (1- (searchSize-2/(searchSize*searchSize)))) {
								squaresGenerated.add(new Square(i, j,
										searchSize));
							}
							
						}

					}
				}
			}
		}
		return squaresGenerated;
	}

}
