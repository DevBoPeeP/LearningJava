import java.util.Scanner;

public class BasicCalculation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the first number");
        int x=sc.nextInt();
        System.out.println("Please enter the second number");

        int y=sc.nextInt();


        int add = x + y;
        int sub = x - y;
        int mul = x * y;
        double div = (double) x / y;
        int mod = x % y;



        System.out.println("Addition " +add);
        System.out.println("Subtraction " +sub);
        System.out.println("Multiplication "+mul);
        System.out.println("Division "+div);
        System.out.println("Modulo "+mod);
    }
}
