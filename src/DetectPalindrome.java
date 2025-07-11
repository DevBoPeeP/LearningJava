import java.util.Scanner;

public class DetectPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();

        char[] charArray = input.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed.append(charArray[i]);
        }
         if (input.contentEquals(reversed.toString())){
            System.out.println("The word is a palindrome.");
         } else {
            System.out.println("The word is not a palindrome.");
         }


    }

}
