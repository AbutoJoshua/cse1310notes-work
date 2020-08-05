import java.util.Scanner;

public class FrequentCharacter {

    public static char mostFrequentCharacter(String text) {
        int max_counter = 0;
        char max_char = 'a'; // the initial value of max_char makes no difference.

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int counter = countOccurrences(text, current);
            if (counter > max_counter) {
                max_counter = counter;
                max_char = text.charAt(i);
            }
            // You need to complete the code for this function.
        }
        return max_char;

    }

    public static int countOccurrences(String text, char current) {
        int counter = 0;
        for (int j = 0; j < text.length(); j++) {
            char c1 = text.charAt(j);
            if (current == c1) {
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter some text, or q to quit: ");
            String text = in.nextLine();
            if (text.toLowerCase().equals("q")) {
                break;
            }
            if (text.length() == 0) {
                break;
            }

            char c = mostFrequentCharacter(text);
            int number = countOccurrences(text, c);
            System.out.printf("Most frequent character: '%c'\n", c);
            System.out.printf("Number of occurrences of '%c': %d\n\n", c, number);
        }
        System.out.printf("Exiting...\n");
    }
}
