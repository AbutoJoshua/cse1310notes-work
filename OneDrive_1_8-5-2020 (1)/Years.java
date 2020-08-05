import java.util.Scanner;

public class Years
{
  // This function gets an integer from the user.
  // It ensures that the user enters a valid integer
  // that is >= 1.  
  public static int userInteger(String message)
  {
    Scanner in = new Scanner(System.in);
    int result;
    int answer;

    while (true)
    {
      System.out.printf(message);
      String s = in.next();
      if (s.toLowerCase().equals("q"))
      {
        System.out.printf("Exiting...\n");
        System.exit(0);
      }
      try
      {
        answer = Integer.parseInt(s);
      }
      catch(Exception e)
      {
          System.out.printf("%s is not a valid integer\n",s);
          continue;
      }
      if (answer<=0)
      {
          System.out.printf("%d is not >= 1.\n",answer);
          continue;
      }
      return answer;
    }
  }
  
  public static boolean isLeapYear(int year)
  {
      if (year%100==0)
        {
          if(year%400==0)
            {
              return true;
            }
          else return false;
        }
      else
         {
             if (year%4==0)
             {
                 return true;
             }
             else 
             {
                 return false;
             }
          }
  }
  

  public static void main(String[] args)
  {
    while (true)
    {
      int year = userInteger("Please enter a year >= 1, or q to quit: ");
      boolean result = isLeapYear(year);
      if (result == true)
      {
        System.out.printf("Yes, %d is a leap year.\n\n", year);
      } 
      else
      {
        System.out.printf("No, %d is not a leap year.\n\n", year);
      }
    }
  }
}