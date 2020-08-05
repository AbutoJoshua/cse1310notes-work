import java.util.*;
import java.io.File;

public class MonthlyAverage
{

    public static int userInteger(String message)
    {
        Scanner in = new Scanner(System.in);
        int result;
        while (true)
        {
            System.out.printf(message);
            String s = in.next();
            if (s.equals("q"))
            {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }

            try
            {
                result = Integer.parseInt(s);
            }
            catch (Exception e)
            {
                System.out.printf("%s is not a valid number, try again.\n\n", s);
                continue;
            }

            return result;
        }
    }
    public static ArrayList<String> read_file(String filename) {
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

    public static String[][] readSpreadsheet(String filename) {
        ArrayList<String> lines = read_file(filename);
        if (lines == null)
        {
            return null;
        }
        String[][] result = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            result[i] = line.split(",");
        }

        return result;
    }
    public static String columnName(String filename, int column){
        String[][] data = readSpreadsheet(filename);
        if (data==null){
            return null;
        }
        if(column<0 || column>=data[0].length){
            return null;
        }
        String result = data[0][column];
//        int bleh = data[0].length;
//        System.out.print(bleh);
        return result;
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
    public static Double monthlyAverage (String filename, int column, int month) {
        String[][] data = readSpreadsheet(filename);
        ArrayList<Integer> columnMonth= new ArrayList<Integer>();
        for (int i = 0; i < data.length; i++) {
                int currentMonth = getMonth(data[i][0]);
                if (currentMonth == month) {
                    columnMonth.add(i);
                }
        }
        double num;
        double sum = 0;
        for (int i=0; i<data.length;i++){
            try{
                num=Double.parseDouble(data[columnMonth.get(i)][column]);
            }
            catch (Exception e){
                continue;
            }
            sum+=num;
        }
        if (columnMonth.size()==0){
            return 1.0;
        }
        return sum/columnMonth.size();
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
            int column = userInteger("Enter a column: ");
            String name = columnName(filename, column);
            if (name == null)
            {
                System.out.printf("Failed to extract a valid column name for column %d of %s\n\n",
                        column, filename);
                continue;
            }
            int month = userInteger("Enter a month: ");

            double average = monthlyAverage(filename, column, month);
            if (average == -1.00)
            {
                System.out.printf("In file %s, there is no data for %s for month %d.\n\n",
                        filename, name, month);
            }
            else
            {
                System.out.printf("In file %s, the average %s for month %d is %.2f.\n\n",
                        filename, name, month, average);
            }
        }
    }
}