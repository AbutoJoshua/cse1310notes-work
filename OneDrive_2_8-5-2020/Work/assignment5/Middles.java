import java.util.Scanner;

public class Middles {

    public static double userDouble(String message) {
        Scanner in = new Scanner(System.in);
        double result;
        while (true) {
            System.out.printf(message);
            String s = in.next();
            if (s.toLowerCase().equals("q")) {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }
            try {
                result = Double.parseDouble(s);
            }
            catch (Exception e){
                System.out.printf("%s is not a valid integer.\n", s);
                continue;
            }
            return result;
              // You need to complete the code for this function.    }
        }
        }
    public static double pickMiddle(double first, double second, double third){
            double middle=0;
            if(first==second && third==first && third==first){
                //second=middle;
                middle=second;
            }
            else if(first==second && (third>first || first>third)){
                //second=middle
                middle+=second;
            }
            else if (second==third && (second>first || first>second)){
                //second=middle;
                middle+=second;
            }
            else if (second>first && third>second && third>first){
                //second = middle;
                middle+=second;
            }
            else if(second>first && third>first && third<second){
                //third = middle;
                middle+=third;
            }
            else if(second<first && third>second && third>first){
                //first = middle;
                middle+=first;
            } 
            else if(second>first && third<second && third<first){
                //first = middle;
                middle+=first;
            }
            else if(second<first && third>second && third<first){
                //third = middle;
                middle+=third;
            }
            else if(second<first && third<second && third<first){
                //second = middle;
                middle+=second;
            }
            return middle;
                
            
    }

    public static void main(String[] args) {
        while (true) {
            double first = userDouble("please enter the first number, or q to quit: ");
            double second = userDouble("please enter the second number, or q to quit: ");
            double third = userDouble("please enter the third number, or q to quit: ");
            double middle = pickMiddle(first, second, third);
            System.out.printf("the middle value is %.1f\n\n", middle);
        }
    }
}