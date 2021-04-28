//
//Michael Laffan
//Prog5
//Due Date and Time: 4/5/21 before 9:00 am
//
//Purpose: This program allows the user to enter a choice
//value from a menu of choices and perform certain actions
//regarding steps. For example, entering D will output a set of stairs
//based on the values inputted and entering A will calculate the area 
//based on the values inputted as well.
//
//Input: The inputs are the step width, number of steps,
//and the fill style.
//
//Output: The outputs are the area, the actual steps,
//and the text description of the steps.
//
//Certification of Authenticity:
//I certify that this lab is entirely my own work.

import java.util.*;

/**
 * 
 * @author zackz
 *
 */
public class StepsDemoLaffan 
{
	//declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//declare and initialize variables
		StepsLaffan step = new StepsLaffan(2, 5, '*'); 
		char choice = ' ';
		int stepWidth;
		int numSteps;
		char fillStyle;
		
		//Greets the user and describes what the program does
		System.out.println("Welcome to the Steps Program.");
		System.out.println("Enter a choice value from the menu below");
		System.out.println("and I will perform a certain action that has");
		System.out.println("to do with steps. For values W, N, and F, I will");
		System.out.println("ask you to input values for the step width, the number");
		System.out.println("of steps, and the fill style. For value A, I");
		System.out.println("will calculate the area based on the values of");
		System.out.println("the step width and the number of steps. For value T,");
		System.out.println("I will output a text description for the steps. For value");
		System.out.println("D, I will output the actual steps based on the values of");
		System.out.println("the step width and the number of steps. I will keep");
		System.out.println("performing these actions until you input Q as a value.");
		System.out.println("When that happens, I will say goodbye and close out.");
		
		//Outputs the steps menu
		System.out.println("Steps Menu: ");
		System.out.println("W : Assign the Step Width");
		System.out.println("N : Assign the Number of Steps");
		System.out.println("F : Assign the Fill Style");
		System.out.println("A : Calculate the Area");
		System.out.println("T : Text Description of the Steps");
		System.out.println("D : Draw the Steps");
		System.out.println("Q : Quit");
		
		//Gets user input for choice value
		System.out.println("Enter a choice value from the menu above: ");
		choice = keyboard.next().charAt(0);
		
		//A loop that performs various step
		//methods and actions until choice 
		//value equals Q or q
		while (!((choice == 'Q') || (choice == 'q')))
		{
			switch (choice)
			{	
				case 'W':
				case 'w':
						do
						{
							System.out.println("Enter a step width greater than zero: ");
							stepWidth = keyboard.nextInt();
						}//do
						while (!(stepWidth > 0));
						step.setStepWidth(stepWidth);
						break;
				case 'N':
				case 'n':
						do
						{
							System.out.println("Enter your desired number of steps: ");
							numSteps = keyboard.nextInt();
						}//do
						while (!(numSteps > 0));
						step.setNumSteps(numSteps);
						break;
				case 'F':
				case 'f':
						System.out.println("Enter a single character for your desired fill style: ");
						fillStyle = keyboard.next().charAt(0);
						step.setFillStyle(fillStyle);
						break;
				case 'A':
				case 'a':
						System.out.println("Area: " + step.calcArea());
						break;
				case 'T':
				case 't':
						System.out.println(step.toString());
						System.out.println("Area: " + step.calcArea());
						break;
				case 'D':
				case 'd':
						step.drawSteps();
						break;
				default:
					   System.out.println("Invalid input.");
					   break;
			}//switch
			
			//Gets user input for choice value again
			//and repeats the loop until it equals Q or q
			System.out.println("Enter a choice value from the menu above: ");
			choice = keyboard.next().charAt(0);
		}//while
		
		//Departing salutation and program closes out
		System.out.println("\nThanks for your time. Have a nice day!");
		keyboard.close();
		
	}//main

}//StepsDemoLaffan
