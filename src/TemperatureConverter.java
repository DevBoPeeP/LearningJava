public class TemperatureConverter {

    public static void main(String[] args) {
        double fahrenheit = 56;
        double celsius = (fahrenheit - 32) * 5.0 /9.0;

        System.out.printf("%.2f°F = %.1f°C%n", fahrenheit, celsius);
    }
}
