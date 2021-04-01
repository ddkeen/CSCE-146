/*
 * David Keen
 * 2/21/20
 * CSCE 146H
 * Lab05
 */
//ReversePolisCalculator class from Lab05 that uses a LinkedListStack of type Integer
import java.util.Scanner;
public class ReversePolishCalculator {
	//private instance variable
	private GenLLStack<Integer> valueStack;
	//construcot
	public ReversePolishCalculator()
	{
		valueStack = new GenLLStack<Integer>();
	}
	//only one method needed to calculate the value of the given String containing numbers and operators
	public int calculate(String s)
	{
		//reset valuestack to an empty stack
		valueStack = new GenLLStack<Integer>();
		//create the scanner to scan the string
		Scanner key = new Scanner(s);
		//evaluate values while the string has more values in it
		while(key.hasNext())
		{
			//single number or operator
			String num = key.next();
			//check if it's an operator
			if (num.equalsIgnoreCase("+")
					|| num.equalsIgnoreCase("-")
					|| num.equalsIgnoreCase("*")
					|| num.equalsIgnoreCase("/"))
			{
				//if an operator, make sure size is greater than or equal to 2
				if(valueStack.size()<2)
				{
					System.out.println("This was not properly formatted. There were too many operators and not enough numbers");
					return 0;
				}
				//if it is, pop 2 numbers from the stack, change them into a single value using the operator, then put that result back into the stack
				else
				{
					int  op2 = valueStack.pop();
					int op1 = valueStack.pop();
					int result;
					if(num.equalsIgnoreCase("+"))
						 result = op1 + op2;
					else if(num.equalsIgnoreCase("-"))
						result = op1 - op2;
					else if(num.equalsIgnoreCase("*"))
						result = op1 * op2;
					//make sure not to divide by 0
					else
					{
						if(op2 == 0)
						{
							System.out.println("Cannot Divide by 0");
							return 0;
						}
						else
							result = op1 / op2;
					}
					valueStack.push(result);
				}
			}
			//if not an operator, the value is either an integer or invalid
			else
			{
				try
				{
					//try parsing the value to an int and push that value onto the stack
					int number = Integer.parseInt(num);
					valueStack.push(number);
				}
				//if the try block failed, it was an invalid value, not a number or operator
				catch(Exception e)
				{
					System.out.println("Not a valid operator");
					return 0;
				}
			}	
		}
		//if formatted correctly, there is one value left in the stack, that is the result of the calculation 
		if(valueStack.size()==1)
			return valueStack.pop();
		//otherwise the String was formatted incorrectly with too many numbers since we already check if there were too many operators before
		else
		{
			System.out.println("This was not properly formatted. There were too many numbers and not enough operators");
			return 0;
		}
		
	}

}
