import java.util.Scanner;

public class Years {

    public static int userInteger(String message) {
        Scanner in = new Scanner(System.in);
        int result;
        while (true) {
            System.out.printf(message);
            String s = in.next();
            if (s.toLowerCase().equals("q")) {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }
            try {
                result = Integer.parseInt(s);
            }
            catch (Exception e){
                System.out.printf("%s is not a valid integer.\n", s);
                continue;
            }
            if (result<=0){
                System.out.printf("%s is not >=1.\n", s);
                continue;
               
            }

      return result;

            // You need to complete the code for this function.
        }
    }
    public static boolean isLeapYear(int year){
        boolean result=false;
         if(year%400==0 && year%4==0){
            result=true;
        } else if (year%4==0 && year%100==0){
            result=false;
        }
        
        else if (year%4==0){
            result=true;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int year = userInteger("Please enter a year >= 1, or q to quit: ");
            boolean result = isLeapYear(year);
            if (result == true) {
                System.out.printf("Yes, %d is a leap year.\n\n", year);
            } else {
                System.out.printf("No, %d is not a leap year.\n\n", year);
            }
        }
    }
}