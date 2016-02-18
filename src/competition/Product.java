package competition;

public class Product implements Comparable<Product> {
	int ID;
	int weight;
	public Product(int IDin, int weightIn)
	{
		this.ID = IDin;
		this.weight = weightIn;
	}
	public int getWeight()
	{
		return this.weight;
	}
	@Override
	public int compareTo(Product o) {
		return ((Integer)this.weight).compareTo(o.getWeight());
	}
	
	public String toString(){
		return "Product with id"+this.ID+" and weight "+this.weight;
	}
}
