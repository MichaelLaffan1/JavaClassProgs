//
//Michael Laffan
//ChangeMakerLaffan
//Due Date and Time: 3/1/21 before 9:00 a.m.
//
//Purpose: This program allows the user to input a certain amount
//of change and outputs a combination of bills and coins that equal
//that amount of change as well as the total number of bills and coins
//used to make that change.
//
//Input: The amount of cents used to calculate the change.
//
//Output: The combination of bills and coins that 
//equal the amount of change inputed as well as
//the total number of bills and coins used to make the change.
//
//Certification of Authenticity:
//I certify that this lab is entirely my own work.

import java.util.*;

public class ChangeMakerLaffan 
{
	//declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//declare and initialize variables
		int amount = 0;
		int originalAmount = 0;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		int bills = 0;
		int coins = 0;
		
		//Greet the user and describe what the program does
		System.out.println("Welcome to the Change Maker system!");
		System.out.println("Enter a whole number that represents a certain amount");
		System.out.println("of change and I will output");
		System.out.println("a combination of bills and coins that");
		System.out.println("equal that amount of change as well as");
		System.out.println("the total number of bills and coins used");
		System.out.println("to make that change.");
		
		//Get user input
		System.out.print("\nEnter amount to be changed: ");
		amount = keyboard.nextInt();
		
		//Calculates the amount of change
		//and the number of bills and coins 
		//used to make the change.
		originalAmount = amount;
		twenties = amount / 2000;
		amount = amount % 2000;
		tens = amount / 1000;
		amount = amount % 1000;
		fives = amount / 500;
		amount = amount % 500;
		ones = amount / 100;
		amount = amount % 100;
		quarters = amount / 25;
		amount = amount % 25;
		dimes = amount / 10;
		amount = amount % 10;
		nickels = amount / 5;
		amount = amount % 5;
		pennies = amount;
		bills = twenties + tens + fives + ones;
		coins = quarters + dimes + nickels + pennies;
		
		//Outputs the results and checks
		//if each variable is equal to one 
		//and if so, outputs the correct 
		//English for it.
		System.out.println(originalAmount + " cents can be given as:");
		if (twenties == 1)
		{
			System.out.println(twenties + " twenty");
		}//if
		else
		{
			System.out.println(twenties + " twenties");
		}//else
		
		if (tens == 1)
		{
			System.out.println(tens + " ten");
		}//if
		else
		{
			System.out.println(tens + " tens");
		}//else
		
		if (fives == 1)
		{
			System.out.println(fives + " five");
		}//if
		else
		{
			System.out.println(fives + " fives");
		}//else
		
		if (ones == 1)
		{
			System.out.println(ones + " one");
		}//if
		else
		{
			System.out.println(ones + " ones");
		}//else
		
		if (quarters == 1)
		{
			System.out.println(quarters + " quarter");
		}//if
		else
		{
			System.out.println(quarters + " quarters");
		}//else
		
		if (dimes == 1)
		{
			System.out.println(dimes + " dime");
		}//if
		else
		{
			System.out.println(dimes + " dimes");
		}//else
		
		if (nickels == 1)
		{
			System.out.println(nickels + " nickel");
		}//if
		else
		{
			System.out.println(nickels + " nickels");
		}//else
		
		if (pennies == 1)
		{
			System.out.println(pennies + " penny");
		}//if
		else
		{
			System.out.println(pennies + " pennies");
		}//else
		
		if (bills == 1)
		{
			System.out.println(bills + " bill");
		}//if
		else
		{
			System.out.println(bills + " bills");
		}//else
		
		if (coins == 1)
		{
			System.out.println(coins + " coin");
		}//if
		else
		{
			System.out.println(coins + " coins");
		}//else
		
		//Departing salutation and program closes out
		System.out.println("\nThanks! Have a nice day!");
		keyboard.close();

	}//main

}//ChangeMakerLaffan
