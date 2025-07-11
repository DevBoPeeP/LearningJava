import java.util.Scanner;

public class MiniAndMaxValue {
    public static int findLargest(int[] arr) {
        if (arr.length == 0) return 0;

        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int findSmallest(int[] arr) {
        if (arr.length == 0) return 0;

        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers with spaces in between:");
        String input = scanner.nextLine();
        String[] stringNumbers = input.split(" ");

        int[] array = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            array[i] = Integer.parseInt(stringNumbers[i]);
        }

        int largest = findLargest(array);
        int smallest = findSmallest(array);

        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("Max number: " + largest);
        System.out.println("Min number: " + smallest);

        scanner.close();
}
    }
