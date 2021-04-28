//
//Michael Laffan
//HospitalLaffan
//Due Date and Time: 3/22/21 before 9:00 am
//
//Purpose: This program allows the user to input patient information
//for multiple people such as the patient ID and the household income
//and calculates the total bill for each one and outputs it. The program 
//also outputs things like the highest and lowest bill and the average bill.
//
//Input: Patient ID, household income, insurance plan, and
//number of days in hospital.
//
//Output: For each patient: patient ID, household income, insurance plan,
//number of days, admittance fee, per diem rate, service fee, discount, and total bill.
//Overall results: number of patients processed, highest bill and corresponding patient ID,
//lowest bill and corresponding patient ID, total cost of all bills and average cost of all bills.
//
//Certification of Authenticity:
//I certify that this lab is entirely my own work.

import java.util.*;

public class HospitalLaffan 
{
	//declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		//declare and initialize variables
		int patientID = 0;
		double houseIncome = 0.0;
		char insurancePlan = ' ';
		int days = 0;
		double admittanceFee = 400.0;
		double perDiemRate = 0.0;
		double serviceFee = 0.0;
		double discount = 0.0;
		double totalBill = 0.0;
		int patients = 0;
		double highestBill = 0.0;
		int highestPatientID = 0;
		double lowestBill = 0.0;
		int lowestPatientID = 0;
		double totalBillCost = 0.0;
		double averageBillCost = 0.0;
		
		//Greets the user and describes what the program does
		System.out.println("Welcome to the Hospital program.");
		System.out.println("Enter your patient ID, household income,");
		System.out.println("insurance plan, and the number of days");
		System.out.println("in the hospital and I will calculate and output");
		System.out.println("your patient ID, household income, insurance plan,");
		System.out.println("number of days in hospital, admittance fee,");
		System.out.println("per diem rate, service fee, discount, and the total bill.");
		System.out.println("I will continue to do this for multiple patients until");
		System.out.println("you enter 0 as the patient ID. When that happens, I will");
		System.out.println("output the number of patients processed, the highest bill");
		System.out.println("and its corresponding patient ID, the lowest bill and its");
		System.out.println("corresponding patient ID, the total cost of all bills, and");
		System.out.println("the average cost of all bills.");
		
		//Get user input for patient ID
		System.out.println("\nEnter your patient ID: ");
		patientID = keyboard.nextInt();
		
		//A loop that collects patient input and
		//calculates the total bill
		//until the patient ID equals 0.
		while (patientID != 0)
		{
			
			//Gets user input and validates it
			do
			{
				System.out.println("Enter your household income: ");
				houseIncome = keyboard.nextDouble();
			}//do
			while (!(houseIncome >= 0));
		
			do
			{
				System.out.println("Enter your insurance plan, G for Green Plus, D for Doc-Health,");
				System.out.println("H for Health Plan, or N for No Insurance: ");
				insurancePlan = keyboard.next().charAt(0);
			}//do
			while (!((insurancePlan == 'G' || insurancePlan == 'g') || (insurancePlan == 'D' || insurancePlan == 'd') 
				|| (insurancePlan == 'H' || insurancePlan == 'h') || (insurancePlan == 'N' || insurancePlan == 'n')));
		
			do
			{
				System.out.println("Enter the number of days between 1 and 365, inclusive: ");
				days = keyboard.nextInt();
			}//do
			while (!((days <= 365) && (days >= 1)));
		
			//calls methods outside the main method
			//to calculate per diem rate, service fee,
			//discount, and the total bill and to
			//output results for each patient
			perDiemRate = calcPerDiem(insurancePlan, houseIncome);
			serviceFee = calcServiceFee(perDiemRate, days);
			if (days > 21)
			{
				discount = calcDiscount(days);
			}//if
			else
			{
				discount = 0.0;
			}//else
			totalBill = calcTotalBill(serviceFee, discount);
			outputResults(patientID, houseIncome, insurancePlan, days, admittanceFee, perDiemRate, serviceFee, 
					discount, totalBill);
			
			//adds up the number of patients processed,
			//determines both the highest and the lowest
			//bill amount as well as their corresponding
			//patient IDs, the total of all the bills, and
			//the average bill
			patients++;
			if (highestBill < totalBill)
			{
				highestBill = totalBill;
				highestPatientID = patientID;
			}//if
			if (lowestBill == 0.0 || lowestBill > totalBill)
			{
				lowestBill = totalBill;
				lowestPatientID = patientID;
			}//if
			totalBillCost += totalBill;
			
			//Gets user input for patient ID again
			//and repeats the loop until it equals 0
			System.out.println("\nEnter your patient ID: ");
			patientID = keyboard.nextInt();
		
		}//while
		
		if (patients != 0)
		{
			averageBillCost = totalBillCost / patients;
		}//if
		
		//outputs the overall results for all patients
		System.out.println("Number of patients processed: " + patients);
		System.out.printf("Highest Bill Amount is $%1.2f", highestBill);
		System.out.println("\nPatient ID of highest bill amount: " + highestPatientID);
		System.out.printf("Lowest Bill Amount is $%1.2f", lowestBill);
		System.out.println("\nPatient ID of lowest bill amount: " + lowestPatientID);
		System.out.printf("Total Bill Cost is $%1.2f", totalBillCost);
		System.out.printf("\nAverage Bill Cost is $%1.2f", averageBillCost);
		
		//Departing salutation and program closes out
		System.out.println("\nThanks for your time. Have a nice day!");
		keyboard.close();
		
	}//main
	
	//calcPerDiem accepts the insurance plan and the household 
	//income as parameters and determines the per diem rate based
	//on those values
	public static double calcPerDiem(char iPlan, double hIncome)
	{
		double perDiem = 0.0;
		switch (iPlan)
		{
			case 'G':
			case 'g':
				if (hIncome < 20000)
				{
					perDiem = 65;
				}//if
				else if (hIncome <= 77500)
				{
					perDiem = 80;
				}//else-if
				else
				{
					perDiem = 150;
				}//else
				break;
			case 'D':
			case 'd':
				if (hIncome < 40000)
				{
					perDiem = 60;
				}//if
				else if (hIncome <= 75000)
				{
					perDiem = 90;
				}//else-if
				else
				{
					perDiem = 140;
				}//else
				break;
			case 'H':
			case 'h':
				if (hIncome < 17500)
				{
					perDiem = 55;
				}//if
				else if (hIncome <= 53000)
				{
					perDiem = 70;
				}//else-if
				else
				{
					perDiem = 130;
				}//else
				break;
			default:
				perDiem = 400;
		}//switch
		return perDiem;
	}//calcPerDiem

	//calcServiceFee accepts the per diem rate and the number of days
	//as parameters and calculates the service fee
	public static double calcServiceFee(double perDRate, int numOfDays)
	{
		double servFee = 0.0;
		servFee = perDRate * numOfDays;
		return servFee;
	}//calcServiceFee
	
	//calcDiscount accepts the number of days as a
	//parameter and calculates the discount for
	//patients that stay in the hospital for more
	//than 21 days
	public static double calcDiscount(int numDays)
	{
		double dCount = 0.0;
		dCount = (numDays / 7) * 250;
		return dCount;
	}//calcDiscount
	
	//calcTotalBill accepts the service fee and the discount as parameters
	//and calculates the total bill
	public static double calcTotalBill(double serviceFee, double diCount)
	{
		double totBill = 0.0;
		int admitFee = 400;
		totBill = serviceFee + admitFee - diCount;
		return totBill;
	}//calcTotalBill
	
	//outputResults outputs the results for each patient, such as their patient
	//ID and their total bill.
	public static void outputResults(int patID, double homeIncome, char inPlan, int numberOfDays, double adFee, 
	double perDiemR, double sFee, double disCount, double tBill)
	{
		System.out.println("Patient ID: " + patID);
		System.out.printf("Household income is $%1.2f", homeIncome);
		if ((inPlan == 'G') || (inPlan == 'g'))
		{
			System.out.println("\nInsurance plan: Green Plus");
		}//if
		else if ((inPlan == 'D') || (inPlan == 'd'))
		{
			System.out.println("\nInsurance plan: Doc-Health");
		}//else-if
		else if ((inPlan == 'H') || (inPlan == 'h'))
		{
			System.out.println("\nInsurance plan: Health Plan");
		}//else-if
		else
		{
			System.out.println("\nInsurance plan: No Insurance");
		}//else
		System.out.println("Number of days: " + numberOfDays);
		System.out.printf("Admittance Fee is $%1.2f", adFee);
		System.out.printf("\nPer Diem Rate is $%1.2f", perDiemR);
		System.out.printf("\nService Fee is $%1.2f", sFee);
		System.out.printf("\nDiscount is $%1.2f", disCount);
		System.out.printf("\nTotal Bill is $%1.2f", tBill);
	}//outputResults
	
}//HospitalLaffan
