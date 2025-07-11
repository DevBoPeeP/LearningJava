import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int days = scanner.nextInt();
        int seconds = days * 86400;

        System.out.println(days + " days = " + seconds + " seconds");

        scanner.close();
    }
}