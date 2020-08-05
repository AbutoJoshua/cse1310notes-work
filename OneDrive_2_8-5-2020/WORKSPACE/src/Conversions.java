import java.util.Scanner;

public class Conversions {
	
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("Please enter a double number: ");
		double a = stdIn.nextDouble();
		
		int a1 = (int) a;
		
		int a2 = (int) Math.round(a);
		
		int a3 = (int) Math.floor(a);
		
		int a4 = (int) Math.ceil(a);
		
		System.out.printf("a cast into an int becomes %d.\n", a1);
		System.out.printf("a rounded becomes %d.\n", a2);
		System.out.printf("The floor of a is %d.\n", a3);
		System.out.printf("The ceiling of a is %d.\n", a4);
		
		stdIn.close();
	}

}
