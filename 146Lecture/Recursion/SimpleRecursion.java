import java.util.*;
public class SimpleRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countDown(5);
		System.out.println(factorial(7));
		System.out.println(gcd(99,3));
		System.out.println(fibbo(21));
	}
	public static void countDown(int num)
	{
		System.out.println(num);//Process
		if(num <= 0)//Recursive halting condition
			return;
		else
			countDown(num-1); //Recursive call
	}
	public static int factorial(int num)
	{
		if(num<=0)
			return 1;
		else
			return num * factorial(num-1);
	}
	public static int gcd(int a, int b)
	{
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	public static int fibbo(int num)
	{
		if(num==1 || num==2)
			return 1;
		else
			return fibbo(num-1)+fibbo(num-2);
	}
}
