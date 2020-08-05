import java.util.Scanner;

public class LetterSorting {
    public static String sortLetters(String text){
        String text1= text.toLowerCase();
        String result = "";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i<letters.length(); i++){
            char c1 = letters.charAt(i);
            for (int j=0; j<text1.length(); j++){
                char c2 = text1.charAt(j);
                if (c1==c2){
                    result+=c1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter some text, or q to quit: ");
            String text = in.nextLine();
            if (text.toLowerCase().equals("q")) {
                System.out.printf("Exiting...\n");
                System.exit(0);
            }

            String result = sortLetters(text);
            System.out.printf("Result: %s.\n\n", result);
        }
    }
}

