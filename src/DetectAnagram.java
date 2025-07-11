import java.util.Arrays;
import java.util.Scanner;

public class DetectAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first word: ");
        String word1 = scanner.nextLine().toLowerCase();
        System.out.print("Enter the second word: ");
        String word2 = scanner.nextLine().toLowerCase();


        if (word1.length() != word2.length()) {
            System.out.println("The words are not anagrams.");
        }
        else {
            char[] charArray1 = word1.toCharArray();
            char[] charArray2 = word2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            if (Arrays.equals(charArray1, charArray2)) {
                System.out.println("The words are anagrams.");
            } else {
                System.out.println("The words are not anagrams.");
            }
        }

    }
}
