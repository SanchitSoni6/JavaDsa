import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        int result;

        if (operator == '+') {

            result = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + result);

        } else if (operator == '-') {

            result = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + result);

        } else if (operator == '*') {

            result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);

        } else if (operator == '/') {

            if (num2 == 0) {
                System.out.println("Division by zero is not allowed.");
            } else {
                result = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + result);
            }

        } else {

            System.out.println("Invalid operator!");

        }

        sc.close();
    }
}