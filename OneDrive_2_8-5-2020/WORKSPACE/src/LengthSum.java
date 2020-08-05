import java.util.Scanner;

public class LengthSum {
	
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s1 = stdIn.next();
		System.out.print("Please enter a second string: ");
		String s2 = stdIn.next();
		System.out.printf("The first string has length %d.\n", s1.length());
		System.out.printf("The second string has length %d.\n", s2.length());
		int sum = s1.length() + s2.length();
		System.out.printf("The sum of the two lengths is %d.\n", sum);
		
		stdIn.close();
	}

}
