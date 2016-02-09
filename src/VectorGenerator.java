import java.util.ArrayList;

public class VectorGenerator {
	String[][] inputCanvas;
	int rows, cols;
	ArrayList<Vector> vectorsGenerated;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	public VectorGenerator(String[][] input) {
		this.inputCanvas = input;
		this.vectorsGenerated = new ArrayList<Vector>();
		this.rows = input.length;
		this.cols = input[0].length;
	}

	public ArrayList<Vector> generateVectors() {
		for (int i = 0; i < inputCanvas.length; i++) {
			for (int j = 0; j < inputCanvas[0].length; j++) {
				
				if (inputCanvas[i][j].equals("#") ) {
					
					for (Direction direction : Direction.values()) {
						int counter = 0;

						switch (direction) {
//						case UP:
//							while (i - counter > -1 ) {
//								if (!inputCanvas[i - counter][j].equals("."))
//									counter++;
//								else
//									break;
//							}
//							vectorsGenerated.add(new Vector(i, j, i - counter, j));
//							break;
							
						case DOWN:
							while (i + counter < rows ) {
								if(inputCanvas[i + counter][j].equals("#"))
									counter++;
								else
									break;
							}
							vectorsGenerated.add(new Vector(i, j, i + counter, j));
							break;
							
//						case LEFT:
//							while (j - counter > -1 ) {
//								if(!inputCanvas[i][j - counter].equals("."))
//									counter++;
//								else
//									break;
//								}
//							vectorsGenerated.add(new Vector(i, j, i, j - counter));
//							break;
							
						case RIGHT:
							while (j + counter < cols ) {
								if(inputCanvas[i][j + counter].equals("#"))
									counter++;
								else
									break;
							}
							vectorsGenerated.add(new Vector(i, j, i, j + counter));
							break;
						}
					}
				}
			}
		}
		return vectorsGenerated;
	}

}
