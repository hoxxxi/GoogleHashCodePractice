import java.util.Arrays;

public class Robot {

	public int counter = 0;
	String board[][];
	String canvas[][];

	public Robot(String boardIn[][]) {
		this.counter = 0;
		this.board = boardIn;

		int r = board.length;
		int c = 0;

		try {
			c = board[0].length;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Empty input");
		}

		this.canvas = new String[r][c];
		for (int i = 0; i < canvas.length; i++)
			Arrays.fill(canvas[i], ".");

	}

	public String writeSquare(int row, int col, int size) {
		size = 2 * size + 1;

		int x = 0;
		int y = 0;

		x = row - size / 2;
		y = col - size / 2;

		try {
			for (int i = x; i < size; i++) {
				for (int k = y; k < size; k++) {
					this.canvas[i][k] = "#";
				}
			}
			this.counter++;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Drawing square outside board boundaries.");
		}

		return "Print Square - X: " + x + " Y: " + y + " Size: " + size;
	}

	public String writeLine(int r1, int c1, int r2, int c2) {
		try {
			if (r1 == r2 || c1 == c2) {
				for (int i = r1; i <= r2; i++) {
					for (int k = c1; k <= c2; k++) {
						this.canvas[i][k] = "#";
					}
				}
				this.counter++;
			} else {
				System.err.println("Input does not mach a single line vector.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Vector dimensions outside board boundaries.");
		}

		return "PAINT_LINE " + r1 + " " + c1 + " " + r2 + " " + c2;
	}

	public String eraseCell(int row, int col) {
		try {
			this.canvas[row][col] = ".";
			this.counter++;
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Erase cell outside board boundaries.");
		}

		return "Erase Cell - X: " + row + " Y: " + col;
	}

	public void printCanvas() {
		try {
			for (int i = 0; i < canvas.length; i++) {
				for (int k = 0; k < canvas[0].length; k++)
					System.out.print(canvas[i][k]);
				System.out.println();
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Empty canvas.");
		}
	}

	public boolean compareInputWithOutput() {
		int mismatched = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!board[i][j].equals(canvas[i][j]))
					mismatched++;
			}
		}
		if(mismatched == 0)
			return true;
		else{
			System.err.println("Number of mismatched:" + mismatched);
			return false;
		}
	}

	public void printInput() {
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[0].length; k++) {
				System.out.print(board[i][k]);
			}
			System.out.println();
		}
	}

	public String calculateCanvas() {
		String result = "";
		try {
			for (int i = 0; i < canvas.length; i++) {
				for (int k = 0; k < canvas[0].length; k++) {
					if (board[i][k].equals("#")) {
						result += this.writeLine(i, k, i, k) + "\n";
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("You fcuked up!");
		}
		result = this.counter + "\n" + result;
		return result;
	}

	public boolean canDrawVectorOnBoard(Vector v) {
		int[] startPos = v.getStartPosition();
		int[] endPos = v.getEndPosition();

		boolean isHorizontal = startPos[1] - endPos[1] == 0;

		for (int i = 0; i < v.getLength() + 1; i++) {
			if (isHorizontal) {
				if (canvas[startPos[0] + i][startPos[1]].equals("#")) {
					return false;
				}
			} else {
				if (canvas[startPos[0]][startPos[1] + i].equals("#")) {
					return false;
				}
			}
		}
		return true;
	}

	public int getCounter() {
		return counter;
	}

}
