import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number for multiplication table: ");
        int a = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            int table = a * i;
            System.out.println(a + " X " + i + " = " + table);
        }

        scanner.close();
    }
}