import java.util.Scanner;


public class CalculateAverage {
    public static double Average(int[] arr){
        if (arr.length == 0) return 0;

        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numbers with spaces in between: ");
        String input = scanner.nextLine();
        String[] stringNumbers = input.split(" ");

        int[] array = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            array[i] = Integer.parseInt(stringNumbers[i]);
        }

        double average = Average(array);

        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Average: " + average);

        scanner.close();
    }
}
