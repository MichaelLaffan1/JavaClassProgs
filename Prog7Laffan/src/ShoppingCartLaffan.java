
/**
 * 
 * @author Michael Laffan <br>
 * 
 * This is the class definition for ShoppingCartLaffan
 *
 */
public class ShoppingCartLaffan 
{
	/**
	 * Instance variable for the list of items in shopping Cart
	 */
	private ItemLaffan[] myItems;
	/**
	 * Instance variable for number of items in cart
	 */
	private int mySize;
	
	/**
	 * The default constructor for ShoppingCartLaffan
	 */
	public ShoppingCartLaffan()
	{
		int i = 0;
		myItems = new ItemLaffan[10];
		for (i = 0; i < myItems.length; i++)
		{
			myItems[i] = null;
		}//for i
		mySize = 0;
	}//ShoppingCartLaffan
	
	/**
	 * The getter for the number of items in cart
	 * @return The number of items in cart
	 */
	public int getSize()
		{ return mySize; } //getSize
	
	/**
	 * Adds an item to the cart and returns whether item was added or not
	 * @param theItem The item that the user wants to add to the cart
	 * @return Whether item was added or not
	 */
	public boolean addToCart(ItemLaffan theItem)
	{
		boolean ans = false;
		
		if (mySize < myItems.length)
		{
			ans = true;
			myItems[mySize] = theItem;
			mySize++;
		}//if
		return ans;
	}//addToCart
	
	/**
	 * Finds the most expensive item in the cart
	 * @return Details about most expensive item in cart
	 */
	public ItemLaffan findMostExpensive()
	{
		ItemLaffan answer = null;
		double max = Double.MIN_VALUE;
		int i = 0;
		for (i = 0; i < mySize; i++)
		{
			if (myItems[i].getPrice() > max)
			{
				max = myItems[i].getPrice();
				answer = myItems[i];
			}//if
		}//for i
		return answer;
	}//findMostExpensive
	
	/**
	 * Finds the least expensive item in cart
	 * @return Details about least expensive item in cart
	 */
	public ItemLaffan findLeastExpensive()
	{
		ItemLaffan number = null;
		double min = Double.MAX_VALUE;
		int i = 0;
		for (i = 0; i < mySize; i++)
		{
			if (min > myItems[i].getPrice())
			{
				min = myItems[i].getPrice();
				number = myItems[i];
			}//if
		}//for i
		return number;
	}//findLeastExpensive
	
	/**
	 * Calculates total price of all items in shopping cart
	 * @return Total price of all items in cart
	 */
	public double calcTotal()
	{
		double total = 0.0;
		int i = 0;
		for (i = 0; i < mySize; i++)
		{
			total += (myItems[i].getPrice() * myItems[i].getQuant());
		}//for i
		return total;
	}//calcTotal
	
	/**
	 * Prints out details about each item in cart
	 */
	public void printList()
	{
		int i = 0;
		for (i = 0; i < mySize; i++)
		{
			System.out.println(myItems[i].toString());
		}//for i
	}//printList
	
	/**
	 * Removes the most expensive item and replaces it with last item in cart
	 * @return Whether most expensive item was removed or not
	 */
	public boolean removeMostExpensive()
	{
		boolean value = false;
		if (getSize() != 0)
		{
			double price = findMostExpensive().getPrice();
			ItemLaffan last = myItems[mySize-1];
			int count = 0;
			int priceValues = 0;
			while ((count < mySize) && !(priceValues > 1))
			{
				if (price == myItems[count].getPrice())
				{
					priceValues++;
				}//if
				count++;
			}//while
			if (!(priceValues > 1))
			{
				int i = 0;
				for (i = 0; i < mySize; i++)
				{
					if (price == myItems[i].getPrice())
					{
						last = myItems[i];
					}//if
				}//for i
				myItems[mySize-1] = null;
				mySize--;
				value = true;
			}//if
		}//if
		return value;
	}//removeMostExpensive
	
}//ShoppingCartLaffan
