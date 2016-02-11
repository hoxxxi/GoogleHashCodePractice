package competition;

public class Order {
	int ID;
	Location location;
	String []itemIDs;
	public Order( Location loc, String[]itemsIDsIn)
	{
		this.location = loc;
		this.itemIDs=itemsIDsIn;
	}
}
