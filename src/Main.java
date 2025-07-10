import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] numbers = {10, 5, 5, 20};
        int sum = 0;


        for (double number : numbers) {
            sum += number;
        }
         int mean = sum / numbers.length;

         System.out.println(mean);



    }
}
