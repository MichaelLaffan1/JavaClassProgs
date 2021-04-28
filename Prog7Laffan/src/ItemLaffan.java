
import java.text.*;

/**
 * 
 * @author Michael Laffan <br>
 *
 * This is the class definition for ItemLaffan
 * 
 */
public class ItemLaffan 
{
	/**
	 * Declares a format for outputting an item's price
	 */
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	/**
	 * Instance variable for an item's name
	 */
	private String myName;
	/**
	 * Instance variable for an item's quantity
	 */
	private int myQuant;
	/**
	 * Instance variable for an item's price
	 */
	private double myPrice;
	
	/**
	 * The default constructor for ItemLaffan
	 */
	public ItemLaffan()
	{
		myName = "None";
		myQuant = 0;
		myPrice = 0.0;
	}//ItemLaffan
	
	/**
	 * Sets the variables equal to new values
	 * @param newName The incoming name for an item
	 * @param newQuant The incoming quantity for an item
	 * @param newPrice The incoming price for an item
	 */
	public ItemLaffan(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;
	}//ItemLaffan
	
	/**
	 * The setter for an item's name
	 * @param newName The incoming name for an item
	 */
	public void setName(String newName)
		{ myName = newName; } //setName
	
	/**
	 * The setter for an item's quantity
	 * @param newQuant The incoming quantity for an item
	 */
	public void setQuant(int newQuant)
		{ myQuant = newQuant; } //setQuant
	
	/**
	 * The setter for an item's price
	 * @param newPrice The incoming price for an item
	 */
	public void setPrice(double newPrice)
		{ myPrice = newPrice; } //setPrice
	
	/**
	 * The getter for an item's name
	 * @return The name of an item
	 */
	public String getName()
		{ return myName;} //getName
	
	/**
	 * The getter for an item's quantity
	 * @return The quantity of an item
	 */
	public int getQuant()
		{ return myQuant; } //getQuant
	
	/**
	 * The getter for an item's price
	 * @return The price of an item
	 */
	public double getPrice()
		{ return myPrice; } //getPrice
	
	/**
	 * Prints out details about an item
	 */
	public String toString()
	{
		String ans = "\nName: " + myName + "\n";
		ans += "Quantity: " + myQuant + "\n";
		ans += "Price is $" + moneyStyle.format(myPrice) + "\n";
		return ans;
	}//toString
	
}//ItemLaffan
