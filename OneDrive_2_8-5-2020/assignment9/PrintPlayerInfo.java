import java.io.PrintWriter;
import java.util.*;
import java.io.File;

public class PrintPlayerInfo

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
//        for (int i = 0;i<result.length;i++){
//            System.out.println(result[i][0]);
//        }
        return result;
    }
    public static void printPlayerInfo(String[][] data, String player){
        for (int i=0; i<=data.length;i++){
            for (int j=0;j<data[0].length;j++){
                try{
                    if ((data[i][0].toLowerCase()).contains(player.toLowerCase())&&j==0){
                        System.out.printf("\n");
                    }
                }
                catch (Exception e){
                    continue;
                }

                try {
                    if ((data[i][0].toLowerCase()).contains(player.toLowerCase())) {
                        System.out.printf("%21s: %s\n", data[0][j], data[i][j]);
                    }
                }
                catch (Exception e){
                    continue;

                }
                if ((data[i][0].toLowerCase()).contains(player.toLowerCase())&&j==data[0].length-1){
                    System.out.printf("\n");
                }
//                System.out.printf("i: %s\n",i);
//                System.out.printf("j: %s\n",j);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.printf("\nEnter the name of a file to read: ");
            String filename = in.next();
            String[][] data = readSpreadsheet(filename);
            System.out.printf("\nEnter part of a player's name (or q to quit): ");
            String player = in.next();
            if (player.equals("q"))
            {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }
            printPlayerInfo(data, player);
        }

    }
}