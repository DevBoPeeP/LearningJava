import java.util.Scanner;

        //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
        // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter numbers separated by spaces: ");
                String input = scanner.nextLine();
                String[] stringNumbers = input.split(" ");

                int[] numbers = new int[stringNumbers.length];
                for (int i = 0; i < stringNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(stringNumbers[i]);
                }

                int sum = 0;

                for (int number : numbers) {
                    sum += number;
                }
                int mean = sum / numbers.length;

                System.out.println("Mean: " + mean);

                scanner.close();
            }
        }