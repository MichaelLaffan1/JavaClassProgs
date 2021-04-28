
import java.io.*;
import java.util.*;
import java.text.*;

/**
*
* @author Michael Laffan <br>
* 
* Prog 7 <br>
* Due Date and Time: 4/22/21 at 9:00 am <br>
*
* Purpose: This program allows the user enter a file name with a list of items <br>
* that they wish to add the cart. Afterwards, the items will be read in and added <br>
* to the cart. Then, the user will be prompted to enter a choice value <br>
* from a menu of choices and perform certain actions regarding <br>
* shopping. For example, entering A will allow the user to add <br>
* an item to the shopping cart and entering N will output the <br>
* number of items in the cart. <br>
*
* Input: The inputs are the file name, an item's name, quantity, price, and <br>
* the choice values. <br>
*
* Output: The outputs are whether item was added to cart or not, least <br>
* expensive item, most expensive item, number of items in cart, details <br>
* about each item, total price of all items and whether most expensive <br>
* item was removed or not.<br>
* 
* Certification of Authenticity: <br>
* I certify that this lab is entirely my own work. <br>
*/
public class ShoppingDemoLaffan 
{
	/**
	 * declare one keyboard for the project
	 */
	static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * declares a format for outputting prices
	 */
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	
	public static void main(String[] args) 
	{
		//declare and initialize variables
		ItemLaffan anItem = null;
		ShoppingCartLaffan cart = new ShoppingCartLaffan();
		String fileName = null;
		File inputFile = null;
		int numItems = 0;
		int i = 0;
		String name = " ";
		int quantity = 0;
		double price = 0.0;
		char choice = ' ';
		boolean added = false;
		ItemLaffan leastExpensive = null;
		ItemLaffan mostExpensive = null;
		
		//ask the user for a path and name to the file
		System.out.println("Enter a filename: ");
		fileName = keyboard.next();
		
		//tries to open and use the file if possible
		try
		{
			//declares the reference for the file
			inputFile = new File(fileName);
			
			//creates a second Scanner object, this one for reading
			//from the file
			Scanner input = new Scanner(inputFile);
			
			//Reads first line of the file to determine
			//how many items will be inputted
			numItems = input.nextInt();
			
			//loop that inputs all the items
			//from the file
			for (i = 0; i < numItems; i++)
			{
				name = input.next();
				quantity = input.nextInt();
				price = input.nextDouble();
				anItem = new ItemLaffan(name, quantity, price);
				added = cart.addToCart(anItem);
				if (added)
				{
					System.out.println("Item " + (i+1) + " was added.");
				}//if
				else
				{
					System.out.println("Item " + (i+1) + " was not added.");
				}//else
			}//for i
			
			//A loop that performs various shopping
			//methods and actions until choice 
			//value equals Q or q
			do
			{
				//Greets the user and describes what the program does
				System.out.println("\nWelcome to the shopping program.");
				System.out.println("Enter a choice value from the menu below");
				System.out.println("and I will perform certain actions that has");
				System.out.println("to do with shopping. For option A, I will allow");
				System.out.println("you to add an item to the cart by inputting its name,");
				System.out.println("quantity, and price. For options L and M, I will output");
				System.out.println("the least and most expensive items. For options N and T,");
				System.out.println("I will output the number of items in the cart and");
				System.out.println("output the total price of all items in the cart.");
				System.out.println("For options P and D, I will output the details about");
				System.out.println("each item and remove the most expensive item from the cart.");
				System.out.println("I will keep performing these actions until you input Q as a value.");
				System.out.println("When that happens, I will say goodbye and close out.");
			
				//outputs the shopping menu
				System.out.println("\nShopping Menu: ");
				System.out.println("A – Add an Item to the Cart");
				System.out.println("L – Find the Least Expensive Item in the Cart");
				System.out.println("M – Find the Most Expensive Item in the Cart");
				System.out.println("N – Find the number of Items in the Cart");
				System.out.println("T – Find the total cost of all Items in the Cart");
				System.out.println("P – Print out details about all Items in the Cart");
				System.out.println("D – Delete the Most Expensive Item from the Cart");
				System.out.println("Q - Quit");
			
				//Gets user input for choice value
				System.out.println("\nEnter a choice value from the menu above: ");
				choice = keyboard.next().charAt(0);
			
				switch (choice)
				{
					case 'A':
					case 'a':
							System.out.println("Enter item name: ");
							name = keyboard.next();
							do
							{
								System.out.println("Enter item quantity: ");
								quantity = keyboard.nextInt();
							}//do
							while (!(quantity > 0));
							do
							{
								System.out.println("Enter item price: ");
								price = keyboard.nextDouble();
							}//do
							while (!(price > 0));
							anItem = new ItemLaffan(name, quantity, price);
							added = cart.addToCart(anItem);
							if (added)
							{
								System.out.println("The item was added.");
							}//if
							else
							{
								System.out.println("The item was not added.");
							}//else
							break;
					case 'L':
					case 'l':
							leastExpensive = cart.findLeastExpensive();
							if (leastExpensive != null)
							{
								System.out.println("Least expensive is " + leastExpensive.toString());
							}//if
							else
							{
								System.out.println("No items in cart.");
							}//else
							break;
					case 'M':
					case 'm':
							mostExpensive = cart.findMostExpensive();
							if (mostExpensive != null)
							{
								System.out.println("Most expensive is " + mostExpensive.toString());
							}//if
							else
							{
								System.out.println("No items in cart.");
							}//else
							break;
					case 'N':
					case 'n':
							System.out.println("Number of items in cart: " + cart.getSize());
							break;
					case 'T':
					case 't':
							System.out.println("Total Cost is $" + moneyStyle.format(cart.calcTotal()));
							break;
					case 'P':
					case 'p':
							if (cart.getSize() != 0)
							{
								cart.printList();
							}//if
							else
							{
								System.out.println("No items in cart.");
							}//else
							break;
					case 'D':
					case 'd':
							if (cart.removeMostExpensive())
							{
								System.out.println("Most expensive item removed.");
							}//if
							else
							{
								System.out.println("Most expensive item not removed.");
							}//else
							break;
					case 'Q':
					case 'q':
							System.out.println("\nThanks for your time. Have a nice day!");
							break;
					default:
							System.out.println("Invalid input.");
							break;
				}//switch	
			}//do
			while (!((choice == 'Q') || (choice == 'q')));
			
		//program closes out	
		keyboard.close();
		input.close();
		}//try
		
		//throws an exception if the file name
		//inputted is not found
		catch(FileNotFoundException ex)
		{
			System.out.println("Failed to find file: " + inputFile.getAbsolutePath());
		}//catch
		
		//throws an exception if the user
		//enters the wrong data type for a variable
		catch(InputMismatchException ex)
		{
			System.out.println("Type mismatch for the number I just tried to read.");
			System.out.println(ex.getMessage());
		}//catch
		
		//throws an exception if the program
		//fails to convert a string to an integer
		catch(NumberFormatException ex)
		{
			System.out.println("Failed to convert String text into an integer value.");
			System.out.println(ex.getMessage());
		}//catch
		
		//throws an exception if a null is used
		catch(NullPointerException ex)
		{
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		}//catch
		
		//throws an exception if something else
		//goes wrong
		catch(Exception ex)
		{
			System.out.println("Something went wrong.");
			ex.printStackTrace();
		}//catch

	}//main

}//ShoppingDemoLaffan
