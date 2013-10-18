package formatting;

public class Invoice {

	public String description;
	public int quantity;
	public double price;
	
	public Invoice(String _description, int _quantity, double _price)
	{
		this.description = _description;
		this.quantity = _quantity;
		this.price = _price;
	}
	
	public String getDescritpion()
	{
		return description;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
}
