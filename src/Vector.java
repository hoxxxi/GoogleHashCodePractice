public class Vector implements Comparable<Vector>{
	private int xStart, xEnd;
	private int yStart, yEnd;
	private int length;

	public Vector(int xS, int yS, int xE, int yE) {
		this.xStart = xS;
		this.yStart = yS;
		this.xEnd = xE;
		this.yEnd = yE;
		this.length = Math.abs(xStart - xEnd + yStart - yEnd);
	}

	public int getLength() {
		return length;
	}

	public int[] getStartPosition() {
		return new int[] { xStart, yStart };
	}

	public int[] getEndPosition() {
		return new int[] { xEnd, yEnd };
	}

	@Override
	public int compareTo(Vector o) {
		return Integer.compare(o.getLength(), length );
	}
}
