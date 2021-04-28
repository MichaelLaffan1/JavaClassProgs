//
//Michael Laffan
//ArraysLaffan
//Due Date and Time: 3/29/21 before 9:00 am
//
//Purpose: This program allows the user to enter a choice number
//from a menu of choices and perform certain actions. For example,
//entering the number 2 will have the user enter 10 grades and then
//the program will calculate and output the highest, lowest, and average grades
//from the list the user inputed.
//
//Input: For main method: choice number.
//For golfValues method: par values and stroke values
//For calcGrades method: grade values
//For nonNegativesList method: non-negative values
//
//Output: Lets Go Golfing: number of eagles, birdies, pars, bogeys, double bogeys, or any other results.
//Handle Grades: highest, lowest, and average grades
//How Many Maxes?: the entire array, the maximum value and how many times it appears
//
//Certification of Authenticity:
//I certify that this lab is entirely my own work.

import java.util.*;

public class ArraysLaffan 
{
	//declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);
		
	public static void main(String[] args) 
	{
		//declare and initialize variables
		char choice = ' ';
		int[] parNums = new int[9];
		int[] strokes = new int[9];
		double[] grades = new double[10];
		int[] nonNegatives = new int[8];
		
		//Greets the user and describes what the program does
		System.out.println("Welcome to the Arrays Menu Program.");
		System.out.println("Enter a choice number from the menu below");
		System.out.println("and I will perform a certain action. For");
		System.out.println("choice 1, I will ask you to input par and");
		System.out.println("stroke values and I will output the results");
		System.out.println("of those values. For choice 2, I will ask you");
		System.out.println("to input grade values and I will calculate and output");
		System.out.println("the highest, lowest and average grades. For choice 3,");
		System.out.println("I will ask you to input non-negative integers and I");
		System.out.println("will output all the values you inputted, the maximum");
		System.out.println("value, and the number of times the maximum appears.");
		System.out.println("However, if you input a negative integer, I will stop");
		System.out.println("asking for inputs and I will go straight to printing");
		System.out.println("out the results. I will keep performing these actions");
		System.out.println("until you enter 0 as a choice number. When that happens,");
		System.out.println("I will say goodbye and close out.");
		
		//Outputs the array choices menu
		System.out.println("\nArrays Menu:");
		System.out.println("1) Let’s Go Golfing!");
		System.out.println("2) Handle Grades");
		System.out.println("3) How Many Maxes?");
		System.out.println("0) Quit");
		
		//Gets user input for choice number and validates it
		do
		{
			System.out.println("\nEnter a number from 1 to 3. 1 for Lets Go Golfing,");
			System.out.println("2 for Handle Grades, 3 for How Many Maxes?, or 0 to quit the program:");
			choice = keyboard.next().charAt(0);
		}//do
		while (!((choice == '1') || (choice == '2') || (choice == '3') || (choice == '0')));
		
		//A loop that run various array
		//methods until choice number equals 0
		while (choice != '0')
		{
			if (choice == '1')
			{
				golfValues(parNums, strokes);
			}//if
			else if (choice == '2')
			{
				calcGrades(grades);
			}//else-if
			else
			{
				nonNegativesList(nonNegatives);
			}//else
			
			//Gets user input for choice number again,
			//validates it, and repeats the loop until 
			//it equals 0
			do
			{
				System.out.println("\nEnter a number from 1 to 3. 1 for Lets Go Golfing,");
				System.out.println("2 for Handle Grades, 3 for Find Maxes, or 0 to quit the program.");
				choice = keyboard.next().charAt(0);
			}//do
			while (!((choice == '1') || (choice == '2') || (choice == '3') || (choice == '0')));
			
		}//while

		//Departing salutation and program closes out
		System.out.println("\nThanks for your time. Have a nice day!");
		keyboard.close();
				
	}//main
	
	//the golfValues method accepts the parNums and strokes arrays as
	//parameters and allows the user to input values for pars and strokes.
	//It also calls the golfHelper method to output the results of the two arrays.
	public static void golfValues(int[] golfPars, int[] golfStrokes)
	{
		int i = 0;
		int z = 0;
		
		for (i = 0; i < golfPars.length; i++)
		{
			System.out.println("Enter par value " + (i+1) + ":");
			golfPars[i] = keyboard.nextInt();
		}//for i
		
		for (z = 0; z < golfStrokes.length; z++)
		{
			System.out.println("Enter stroke value " + (z+1) + ":");
			golfStrokes[z] = keyboard.nextInt();
		}//for z
		
		golfHelper(golfPars, golfStrokes);
	}//golfValues
	
	//the golfHelper method accepts the arrays from the previous method
	//and uses the values inputed in them to output the results of the 
	//par value and the number of strokes needed
	public static void golfHelper(int[] gPars, int[] gStrokes)
	{
		int eagles = 0;
		int birdies = 0;
		int pars = 0;
		int bogeys = 0;
		int doubleBogeys = 0;
		int other = 0;
		int num = 0;
		int i = 0;
		
		for (i = 0; i < 9; i++)
		{
			num = gStrokes[i] - gPars[i];
			if (num == -2)
			{
				eagles++;
			}//if
			else if (num == -1)
			{
				birdies++;
			}//else-if
			else if (num == 0)
			{
				pars++;
			}//else-if
			else if (num == 1)
			{
				bogeys++;
			}//else-if
			else if (num == 2)
			{
				doubleBogeys++;
			}//else-if
			else
			{
				other++;
			}//else
		}//for i
		
		System.out.println("Number of Eagles: " + eagles);
		System.out.println("Number of Birdies: " + birdies);
		System.out.println("Number of Pars: " + pars);
		System.out.println("Number of Bogeys: " + bogeys);
		System.out.println("Number of Double Bogeys: " + doubleBogeys);
		System.out.println("Other: " + other);
	}//golfHelper

	//the calcGrades method accepts the grades array as
	//a parameter and allows the user to input grade values
	//and calls other methods to calculate and output the
	//highest, lowest and average grades
	public static void calcGrades(double[] gradeNums)
	{
		double highest = 0.0;
		double lowest = 0.0;
		double average = 0.0;
		int i = 0;
		
		for (i = 0; i < gradeNums.length; i++)
		{
			System.out.println("Enter grade value " + (i+1) + ":");
			gradeNums[i] = keyboard.nextDouble();
		}//for i
		
		highest = highestGrade(gradeNums);
		lowest = lowestGrade(gradeNums);
		average = averageGrade(gradeNums);
		
		System.out.println("Highest Grade: " + highest);
		System.out.println("Lowest Grade: " + lowest);
		System.out.println("Average Grade: " + average);
	}//calcGrades
	
	//the highestGrade method accepts the grades array as 
	//a parameter and uses it to determine the highest grade
	public static double highestGrade(double[] gradeNumbers)
	{
		double high = Double.MIN_VALUE;
		int j = 0;
		
		for (j = 0; j < gradeNumbers.length; j++)
		{
			if (gradeNumbers[j] > high)
			{
				high = gradeNumbers[j];
			}//if
		}//for j
		
		return high;
	}//highestGrade
	
	//the lowestGrade method accepts the grades array as 
	//a parameter and uses it to determine the lowest grade
	public static double lowestGrade(double[] gradeValues)
	{
		double low = Double.MAX_VALUE;
		int z = 0;
		
		for (z = 0; z < gradeValues.length; z++)
		{
			if (low > gradeValues[z])
			{
				low = gradeValues[z];
			}//if
		}//for z
		
		return low;
	}//lowestGrade
	
	//the averageGrade method accepts the grades array as 
	//a parameter and uses it to determine the average grade
	public static double averageGrade(double[] gradeVals)
	{
		double avg = 0.0;
		int e = 0;
		
		for (e = 0; e < gradeVals.length; e++)
		{
			avg += gradeVals[e];
		}//for e
		
		avg = avg / 10;
		return avg;
	}//averageGrade
	
	//the nonNegativesList method accepts the nonNegatives
	//array as a parameter and allows the user to input non-negative
	//values and calls another method to output the entire array,
	//the maximum value, and the number of times it appears. However,
	//if the user enters a negative value, the method will go
	//straight to outputting the results
	public static void nonNegativesList(int[] nonNegs)
	{
		int count = 0;
		int number = 0;
		nonNegs = new int[8];
		
		System.out.println("Enter a number " + (count + 1) + ", or negative to quit:");
		number = keyboard.nextInt();
		
		while ((number >= 0) && (count < nonNegs.length))
		{
			nonNegs[count] = number;
			count++;
			if (count != nonNegs.length)
			{
				System.out.println("Enter a number " + (count + 1) + ", or negative to quit:");
				number = keyboard.nextInt();
			}//if
		}//while
		
		nonNegativeMaxes(nonNegs);
	}//nonNegativesList
	
	//the nonNegativeMaxes method accepts the nonNegatives
	//array as a parameter and determines the maximum value
	//and the number of times it appears
	public static void nonNegativeMaxes(int[] noNegs)
	{
		int max = 0;
		int numOfMaxes = 0;
		int value = 0;
		int x = 0;
		int d = 0;
		
		for (x = 0; x < noNegs.length; x++)
		{
			System.out.print(noNegs[x] + " ");
			System.out.println();
			if (noNegs[x] > max)
			{
				max = noNegs[x];
				value = max;
			}//if
		}//for x
		
		for (d = 0; d < noNegs.length; d++)
		{
			if (noNegs[d] == value)
			{
				numOfMaxes++;
			}//if
		}//for d
		
		System.out.println("Maximum Value: " + max);
		System.out.println("Number of times maximum appears: " + numOfMaxes);
	}//nonNegativeMaxes
	
}//ArraysLaffan
