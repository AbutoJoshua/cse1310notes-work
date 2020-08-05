import java.util.*;
import java.io.File;

public class GetMonth
{
    public static void printMonths(String filename)
    {
        ArrayList<String> lines = readFile(filename);
        if (lines == null)
        {
            return;
        }
        for (int i = 1; i < lines.size(); i++)
        {
            String line = lines.get(i);
            String[] columns = line.split(",");

            String date = columns[0];
            int line_month = getMonth(columns[0]);
            System.out.printf("row %d, month = %d\n", i, line_month);
        }
    }
    public static int getMonth(String date){
        if (!date.contains("/")){
            return 0;
        }
        String monthString = "";
        char first = date.charAt(4);
        monthString+=first;
        if (date.charAt(5)=='/'){
            return Integer.parseInt(monthString);
        }
        else {
            monthString+=date.charAt(5);
        }
        return Integer.parseInt(monthString);
    }

    public static ArrayList<String> readFile(String filename) {
        File temp = new File(filename);
        Scanner input_file;
        try
        {
            input_file = new Scanner(temp); }
        catch (Exception e)
        {
            System.out.printf("Failed to open file %s\n", filename);
            return null; }
        ArrayList<String> result = new ArrayList<String>();
        while(input_file.hasNextLine()) {
            String line = input_file.nextLine();
            result.add(line);
        }
        input_file.close();
        return result;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.printf("Enter a filename (or q to quit): ");
            String filename = in.next();
            if (filename.equals("q"))
            {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }
            printMonths(filename);
            System.out.printf("\n");
        }
    }
}