
public class Square implements Comparable<Square>{
	
	private int centreX;
	public int getCentreX() {
		return centreX;
	}
	public void setCentreX(int centreX) {
		this.centreX = centreX;
	}
	public int getCentreY() {
		return centreY;
	}
	public void setCentreY(int centreY) {
		this.centreY = centreY;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	private int centreY;
	private int size;
	
	public Square(int centreX, int centreY, int size) {
		super();
		this.centreX = centreX;
		this.centreY = centreY;
		this.size = size;
	}
	@Override
	public int compareTo(Square o) {
		return Integer.compare(o.getSize(), size );
	}
	
	
	
}
