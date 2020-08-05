import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class ComputeGrades
{

    public static String[][] readSpreadsheet(String filename)
    {
        ArrayList<String> lines = readFile(filename);
        if (lines == null)
        {
            return null;
        }

        int rows = lines.size();
        String[][] result = new String[rows][];

        for (int i = 0; i < rows; i++)
        {
            String line = lines.get(i);
            String[] values = line.split(",");
            result[i] = values;
        }

        return result;
    }

    public static ArrayList<String> readFile(String filename)
    {
        File temp = new File(filename);
        Scanner input_file;

        try
        {
            input_file = new Scanner(temp);
        } catch (Exception e)
        {
            System.out.printf("Failed to open file %s\n",
                    filename);
            return null;
        }

        ArrayList<String> result = new ArrayList<String>();
        while (input_file.hasNextLine())
        {
            String line = input_file.nextLine();
            if (line.length()==0){
                continue;
            }
            result.add(line);
        }

        input_file.close();
        return result;
    }
    public static String averageHw(String hw1, String hw2, String hw3,String hw4,String hw5,String hw6,String hw7){
        double result;
        double h1;
        double h2;
        double h3;
        double h4;
        double h5;
        double h6;
        double h7;
        try {
            h1=Double.parseDouble(hw1);
            h2=Double.parseDouble(hw2);
            h3=Double.parseDouble(hw3);
            h4=Double.parseDouble(hw4);
            h5=Double.parseDouble(hw5);
            h6=Double.parseDouble(hw6);
            h7=Double.parseDouble(hw7);
        }
        catch (Exception e){
            return "0";
        }
        result = (h1+h2+h3+h4+h5+h6+h7)/7;
        String average = Double.toString(result);
        return average;
    }
    public static String averageExam(String exam1, String exam2, String exam3){
        double result;
        double exam11;
        double exam22;
        double exam33;
        try {
            exam11=Double.parseDouble(exam1);
            exam22=Double.parseDouble(exam2);
            exam33=Double.parseDouble(exam3);
        }
        catch (Exception e){
            return "0";
        }
        result=(exam11+exam22+exam33)/3;
        String average = Double.toString(result);
        return average;
    }
    public static String minScore(String examScore, String hwScore) {
        double result;
        double examScore1;
        double hwScore1;
        try {
            examScore1 = Double.parseDouble(examScore);
            hwScore1 = Double.parseDouble(hwScore);
        } catch (Exception e) {
            return "0";
        }
        if (hwScore1 < examScore1) {
            return Double.toString(hwScore1);
        }
        return Double.toString(examScore1);
    }

    public static void processGrades(String input_name, String csv, String pretty_name) {
        String digits = "abcdefghijklmnopqrstuvwxyz";
        String[][] csv_name = readSpreadsheet(input_name);
        if (csv_name == null) {
            System.out.printf("Sanity check: null data\nSanity check failed.");
            return;
        }
        if (csv_name.length < 2 && csv_name != null) {
            System.out.printf("Sanity check: %d rows\nSanity check failed.", csv_name.length);
            return;
        }
        for (int i = 1; i < csv_name.length; i++) {
            for (int j = 2; j < csv_name[i].length; j++) {
           for (int k = 0; k < digits.length(); k++) {
               String number = String.valueOf(digits.charAt(k));
                    if (csv_name[i][j].indexOf(number)!=-1) {
                        System.out.printf("Non-number found: %s. row = %d, col = %d\nSanity check failed.", csv_name[i][j], i, j);
                        return;
                    }
                }
            }
        }
       for (int i = 0;i<csv_name.length-1;i++){
           int length = csv_name[i].length;
           if (csv_name[i+1].length!=length){
               System.out.printf("Sanity check: %d columns at row %d\nSanity check failed.",length,i);
               return;
           }
       }
        String[][] data = new String[csv_name.length][csv_name[0].length];
        for (int i = 1; i < csv_name.length; i++) {
            String name = csv_name[i][0];
            name+=" ";
            name+=csv_name[i][1];
            //System.out.println(name);
            data[i][0] = name;
        }
        for (int i = 1; i < csv_name.length; i++) {
            String exam1 = csv_name[i][2];
            String exam2 = csv_name[i][3];
            String exam3 = csv_name[i][4];
            String average = averageExam(exam1, exam2, exam3);
            data[i][1] = average;
        }
        for (int i = 1; i < csv_name.length; i++) {
            String hw1 = csv_name[i][5];
            String hw2 = csv_name[i][6];
            String hw3 = csv_name[i][7];
            String hw4 = csv_name[i][8];
            String hw5 = csv_name[i][9];
            String hw6 = csv_name[i][10];
            String hw7 = csv_name[i][11];
            String average = averageHw(hw1, hw2, hw3, hw4, hw5, hw6, hw7);
            data[i][2] = average;
        }
        for (int i = 1; i < csv_name.length; i++) {
            String examScore = data[i][1];
            String hwScore = data[i][2];
            data[i][3] = minScore(examScore, hwScore);
        }
        for (int i = 1; i < csv_name.length; i++) {
            String minScoreString = data[i][3];
            double minScoreDouble;
            try {
                minScoreDouble = Double.parseDouble(minScoreString);
            } catch (Exception e) {
                continue;
            }
            if (minScoreDouble >= 90) {
                data[i][4] = "A";
            } else if (minScoreDouble >= 80 && minScoreDouble < 90) {
                data[i][4] = "B";
            } else if (minScoreDouble >= 70 && minScoreDouble <= 80) {
                data[i][4] = "C";
            } else if (minScoreDouble >= 60 && minScoreDouble <= 70) {
                data[i][4] = "D";
            } else {
                data[i][4] = "F";
            }
        }
        printPretty(data,pretty_name);
        printData(data,csv);
    }

    public static void printPretty(String [][] data, String pretty_name){
        PrintWriter out=null;
        try
        {
            out = new PrintWriter(pretty_name);
        }
        catch (Exception e)
        {
            System.out.printf("Error in opening file %s for writing.\n", pretty_name);
            System.exit(0);
        }
        out.printf("%20s: %s, %s, %s, %s\r\n",
                "name", "exam score", "hw score", "min score", "grade");
        for (int i=1;i<data.length;i++){
            Double examScore = Double.parseDouble(data[i][1]);
            Double hwScore = Double.parseDouble(data[i][2]);
            Double minScore = Double.parseDouble(data[i][3]);
            out.printf("%20s: %10.2f, %8.2f, %9.2f, %s\r\n",
                    data[i][0], examScore, hwScore, minScore, data[i][4]);
        }
        out.close();
    }
    public static void printData(String [][] data, String csv){
        PrintWriter out=null;
        try
        {
            out = new PrintWriter(csv);
        }
        catch (Exception e)
        {
            System.out.printf("Error in opening file %s for writing.\n", csv);
            System.exit(0);
        }
        out.printf("%s, %s, %s, %s, %s\r\n",
                "name", "exam score", "hw score", "min score", "grade");
        for (int i=1;i<data.length;i++){
            out.printf("%s,%.8s,%.8s,%.8s,%s\r\n",
                    data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
        }
        out.close();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.printf("Please enter the name of the input file: ");
        String input_name = in.next();
        System.out.printf("Please enter the name of the output CSV file: ");
        String csv_name = in.next();
        System.out.printf("Please enter the name of the output pretty-print file: ");
        String pretty_name = in.next();

        processGrades(input_name, csv_name, pretty_name);
        System.out.printf("\nExiting...\n");
    }
}