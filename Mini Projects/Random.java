import java.util.Scanner;

public class Random {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int random = (int) (Math.random() * 100) + 1;
        int number;

        do {

            System.out.print("Guess a number between 1 and 100: ");
            number = sc.nextInt();

            if (number == random) {
                System.out.println("You guessed the number correctly!");
            } else if (number > random) {
                System.out.println("You guessed the number too high!");
            } else {
                System.out.println("You guessed the number too low!");
            }

        } while (number != random);

        System.out.println("The correct number was: " + random);

        sc.close();
    }
}