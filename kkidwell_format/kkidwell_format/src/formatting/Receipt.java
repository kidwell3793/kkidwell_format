package formatting;

import java.util.*;

public class Receipt {

	private double total = 0;
	
	private Invoice[] items;
	
	private int column1Width = determineColumn1Width();
	private int column2Width = 10;
	private int column3Width = 10;
	
	private Formatter f = new Formatter(System.out);
	
	public int determineColumn1Width()
	{
		populateArray();
		int highestValue = 0;
		for(int i = 0; i < items.length; i++)
		{
			if(items[i].getDescritpion().length()>highestValue)
				highestValue = items[i].getDescritpion().length();
		}
		return highestValue;
	}
	
	public void printTitle()
	{
		f.format("%-" + column1Width + "s %" + column2Width + "s %" + column3Width + "s\n", "Item", "Qty", "Price");
		f.format("%-" + column1Width + "s %" + column2Width + "s %" + column3Width + "s\n", "----", "---", "-----");
	}
	
	public void print(String name, int qty, double price)
	{
		f.format("%-" + column1Width + "s %" + column2Width + "d %" + column3Width + ".2f\n", name, qty, price);
		total += price * qty;
	}
	
	public void printTotal()
	{
		f.format("%-" + column1Width + "s %" + column2Width + "s %" + column3Width + ".2f\n", "Tax", "", total*0.06);
		f.format("%-" + column1Width + "s %" + column2Width + "s %" + column3Width + "s\n", "", "", "-----");
		f.format("%-" + column1Width + "s %" + column2Width + "s %" + column3Width + ".2f\n", "Total", "", total*1.06);
	}
	
	public void populateArray()
	{
		items = new Invoice[3];
		items[0] = new Invoice("Hard Drive Enclosure", 3, 19.99);
		items[1] = new Invoice("SATA Cable", 10, 11.50);
		items[2] = new Invoice("1 TB HD", 1, 145.80);
	}
	
	public static void main(String[] args) 
	{
		Receipt receipt = new Receipt();
		receipt.printTitle();
		for(int i = 0; i < receipt.items.length; i++)
		{
			receipt.print(receipt.items[i].getDescritpion(), receipt.items[i].getQuantity(), receipt.items[i].getPrice());
		}
		receipt.printTotal();
	}
	

}
