import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        System.out.printf("%.2f°F = %.1f°C%n", fahrenheit, celsius);

        scanner.close();
    }
}