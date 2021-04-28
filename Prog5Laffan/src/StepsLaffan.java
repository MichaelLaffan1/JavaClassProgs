
/**
 * 
 * @author zackz
 *
 */
public class StepsLaffan 
{
	//declare the variables
	/**
	 * 
	 */
	private int myStepWidth;
	/**
	 * 
	 */
	private int myNumSteps;
	/**
	 * 
	 */
	private char myFillStyle;
	
	/**
	 * 
	 */
	//this StepsLaffan method initializes
	//the variables
	public StepsLaffan()
	{
		myStepWidth = 0;
		myNumSteps = 0;
		myFillStyle = ' ';
	}//StepsLaffan
	
	/**
	 * 
	 * @param newStepWidth
	 * @param newNumSteps
	 * @param newFillStyle
	 */
	//this StepsLaffan method assigns 
	//the variables to new ones
	public StepsLaffan(int newStepWidth, int newNumSteps, char newFillStyle)
	{
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillStyle = newFillStyle;
	}//StepsLaffan
	
	/**
	 * 
	 * @param newStepWidth
	 */
	//the next three methods set the variables
	//to new values when called
	public void setStepWidth(int newStepWidth)
		{	myStepWidth = newStepWidth;	} //setStepWidth
	
	/**
	 * 
	 * @param newNumSteps
	 */
	public void setNumSteps(int newNumSteps)
		{	myNumSteps = newNumSteps;	} //setNumSteps
	
	/**
	 * 
	 * @param newFillStyle
	 */
	public void setFillStyle(char newFillStyle)
		{	myFillStyle = newFillStyle;	 } //setFillStyle
	
	//the next three methods return the variables
	//when called
	/**
	 * 
	 * @return
	 */
	public int getStepWidth()
		{	return myStepWidth; } //getStepWidth
	
	/**
	 * 
	 * @return
	 */
	public int getNumSteps()
		{	return myNumSteps;	} //getNumSteps
	
	/**
	 * 
	 * @return
	 */
	public char getFillStyle()
		{	return myFillStyle;	} //getFillStyle
	
	//the calcArea method uses the values for
	//myStepWidth and myNumSteps and calculates
	//and returns the area
	/**
	 * 
	 * @return
	 */
	public int calcArea()
	{	
		int area = 0;
		int i = 0;
		
		for (i = 1; i <= myNumSteps; i++)
		{
			area += (myStepWidth * i);
		}//for i
		
		return area;  
	} //calcArea
	
	//the drawSteps method uses the values for
	//myStepWidth, myNumSteps, and myFillStyle 
	//and prints out a set of steps
	/**
	 * 
	 */
	public void drawSteps()
	{
		int initialStepWidth = myStepWidth;
		int i = 0;
		int z = 0;
					
		for (i = 0; i < myNumSteps; i++)
		{
			for (z = 0; z < initialStepWidth; z++)
			{
				System.out.print(myFillStyle);
			}//for z
			System.out.println();
			initialStepWidth += myStepWidth;
		}//for i 
	}//drawSteps
	
	//the toString method returns a string that contains
	//the values of myStepWidth, myNumSteps, and myFillStyle
	/**
	 * 
	 */
	public String toString()
	{
		String ans = "Step Width: " + myStepWidth + "\n";
		ans += "Number of Steps: " + myNumSteps + "\n";
		ans += "Fill Style: " + myFillStyle;
		return ans;
	}//toString
	
}//StepsLaffan
