import java.util.Scanner;

public class Casting {
	
  public static void main(String[] args) {
	  
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter a double number: ");
    double a = in.nextDouble();
    int a1 = (int) a;
    System.out.printf("a cast into an int becomes %d.\n", a1);
    
    in.close();
  }
}