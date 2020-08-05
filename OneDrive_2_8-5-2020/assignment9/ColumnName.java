import java.util.*;
import java.io.File;

public class ColumnName
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
            }
            else
            {
                System.out.printf("In file %s, column %d is \"%s\"\n\n",
                        filename, column, name);
            }
        }

    }
}