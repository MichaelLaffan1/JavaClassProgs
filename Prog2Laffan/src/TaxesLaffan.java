//
//Michael Laffan
//TaxesLaffan
//Due Date and Time: 3/8/21 before 9:00 am
//
//Purpose: This program allows the user to input taxpayer information
//for multiple people such as the taxpayer ID and the gross income 
//and calculates the amount tax owed for each taxpayer and outputs it.
//The program also outputs things like the highest tax amount, the average
//tax amount, and the number of taxpayers processed.
//
//Input: The taxpayer ID, filing status, gross income, 
//and the number of exemptions.
//
//Output: For each taxpayer: taxpayer ID, filing status,
//taxable income, tax rate, and tax amount owed.
//Overall results: number of taxpayers processed, the highest tax amount,
//taxpayer ID of the highest amount, total amount of taxes paid, and 
//the average tax amount.
//
//Certification of Authenticity:
//I certify that this lab is entirely my own work.

import java.util.*;

public class TaxesLaffan 
{
	//declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//declare and initialize variables
		int taxID = 0;
		char fileStat = ' ';
		double grossIn = 0.0;
		int exemptions = 0;
		String fileData = " ";
		double taxIn = 0.0;
		int stanDed = 2275;
		double taxRate = 0.0;
		double taxOwed = 0.0;
		int taxpayers = 0;
		double highestTax = 0.0;
		int highestTaxID = 0;
		double taxes = 0.0;
		double avgTax = 0.0;
		
		//Greets the user and describes what the program does
		System.out.println("Welcome to the taxpayer program.");
		System.out.println("Enter your taxpayer ID, filing status,");
		System.out.println("gross income, and the number of exemptions and");
		System.out.println("and I will calculate and output your taxpayer ID,");
		System.out.println("filing status, taxable income, tax rate, and the amount");
		System.out.println("of tax you owe. I will continue to do this for multiple");
		System.out.println("taxpayers until you enter 0 as the taxpayer ID.");
		System.out.println("When that happens, I will output the number of taxpayers processed,");
		System.out.println("the highest tax amount, the taxpayer ID of the highest amount,");
		System.out.println("the total amount of taxes paid, and the average tax amount.");
		
		//Get user input for taxpayer ID
		System.out.println("\nEnter your taxpayer ID: ");
		taxID = keyboard.nextInt();
		
		//A loop that collects tax input and
		//calculates the amount of tax owed
		//until the taxpayer ID equals 0.
		while (taxID != 0)
		{
			//Gets user input and validates it
			do
			{
				System.out.println("Enter your filing status, I for Individual, M for Married filing");
				System.out.println("jointly, or H for Head of household: ");
				fileStat = keyboard.next().charAt(0);
			}//do
			while (!((fileStat == 'I' || fileStat == 'i') || (fileStat == 'M' || fileStat == 'm') 
				  || (fileStat == 'H' || fileStat == 'h')));
		
			System.out.println("Enter your gross income: ");
			grossIn = keyboard.nextDouble();
		
			do
			{
				System.out.println("Enter the number of exemptions between 0 and 10, inclusive: ");
				exemptions = keyboard.nextInt();
			}//do
			while (!((exemptions <= 10) && (exemptions >= 0)));
		
			//Calculates taxable income, determines the tax rate
			//as well as determining the amount of tax owed
			taxIn = grossIn - stanDed - 1500 * exemptions;
			
			if (taxIn < 0)
			{
				taxRate = 0.0;
				taxOwed = 0.0;
			}//if
			else
			{
				switch (fileStat)
				{
				case 'I': 
				case 'i':
					fileData = "Individual";
					if (taxIn < 15000)
					{
						taxRate = 0.13;
					}//if
					else if (taxIn <= 78000)
					{
						taxRate = 0.21;
					}//else-if
					else
					{
						taxRate = 0.3;
					}//else
					break;
				case 'M':
				case 'm':
					fileData = "Married filing Jointly";
					if (taxIn < 20000)
					{
						taxRate = 0.17;
					}//if
					else if (taxIn <= 90000)
					{
						taxRate = 0.24;
					}//else-if
					else
					{
						taxRate = 0.35;
					}//else
					break;
				case 'H':
				case 'h':
					fileData = "Head of Household";
					if (taxIn < 24000)
					{
						taxRate = 0.16;
					}//if
					else if (taxIn <= 85000)
					{
						taxRate = 0.27;
					}//else-if
					else
					{
						taxRate = 0.38;
					}//else
					break;
				}//switch
				taxOwed = taxIn * taxRate;
			}//else
			
			//Outputs the results for each taxpayer
			//until taxpayer ID equals 0. 
			System.out.println("Taxpayer ID: " + taxID);
			System.out.println("Filing Status: " + fileData);
			System.out.printf("Taxable Income is $%1.2f", taxIn);
			System.out.println("\nTax Rate: " + taxRate * 100 + "%");
			System.out.printf("Tax Amount Owed is $%1.2f ", taxOwed);
		
			//adds up the number of taxpayers processed,
			//determines highest tax amount and taxpayer ID
			//of the highest tax amount, the total amount of
			//taxes owed, and the average tax
			taxpayers++;
			if (highestTax < taxOwed)
			{
				highestTax = taxOwed;
				highestTaxID = taxID;
			}//if
			if (taxIn > 0)
			{
				avgTax += taxOwed;
				taxes += taxOwed;
			}//if
		
			//Gets user input for taxpayer ID again
			//and repeats the loop until it equals 0
			System.out.println("\nEnter your taxpayer ID: ");
			taxID = keyboard.nextInt();
		}//while
	
		//calculates the average tax
		if (taxes != 0)
		{
			avgTax = avgTax / taxpayers;
		}//if
	
		//outputs the overall results of all taxpayers 
		System.out.println("Number of taxpayers processed: " + taxpayers);
		System.out.printf("The highest tax amount is $%1.2f", highestTax);
		System.out.println("\nTaxpayer ID of the highest tax amount: " + highestTaxID);
		System.out.printf("Total amount of taxes paid is $%1.2f", taxes);
		System.out.printf("\nThe average tax amount is $%1.2f", avgTax);
	
		//Departing salutation and program closes out
		System.out.println("\nThanks for your time. Have a nice day!");
		keyboard.close();
	}//main

}//TaxesLaffan
