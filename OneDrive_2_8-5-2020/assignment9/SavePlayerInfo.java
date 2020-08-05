import java.io.PrintWriter;
import java.util.*;
import java.io.File;

public class SavePlayerInfo
{
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
    public static void savePlayerInfo(String[][] data, String player, String output_name){
        String filename = output_name;
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(filename);
        }
        catch (Exception e)
        {
            System.out.printf("Error in opening file %s for writing.\n", filename);
            System.exit(0);
        }
        for (int i=0; i<data.length;i++){
            for (int j=0;j<data[0].length;j++){
                try {
                    if ((data[i][0].toLowerCase()).contains(player.toLowerCase())){
                        out.printf("%21s: %s\n",data[0][j],data[i][j]);
                    }
                }
                catch (Exception e){
                    continue;
                }
                if ((data[i][0].toLowerCase()).contains(player.toLowerCase())&&j==data[0].length-1){
                    out.printf("\n");
                }
            }
        }
        out.close();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.printf("\nEnter the name of a file to read: ");
            String input_name = in.next();
            System.out.printf("\nEnter the name of the output file: ");
            String output_name = in.next();
            String[][] data = readSpreadsheet(input_name);
            System.out.printf("\nEnter part of a player's name (or q to quit): ");
            String player = in.next();
            if (player.equals("q"))
            {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }
            savePlayerInfo(data, player, output_name);
        }
    }
}