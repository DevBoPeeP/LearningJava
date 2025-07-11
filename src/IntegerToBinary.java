import java.util.Scanner;

public class IntegerToBinary {
    public static String toBinary(int number) {
        if (number == 0) return "0";

       String binary = "";
        if (number < 0) {
            return "Negative numbers cannot be converted to binary.";
        }
        while (number > 0) {
            int remainder = number % 2;
            binary = remainder + binary;
            number /= 2;
        }

        return binary;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        String binary = toBinary(number);

        System.out.println("Binary representation: " + binary);

        scanner.close();
    }
}
