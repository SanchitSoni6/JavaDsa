import java.util.*;

public class Browserhistory {

    public static void main(String[] args) {

        Stack<String> His = new Stack<>();
        Scanner sc = new Scanner(System.in);

        String ans = "yes";

        while (ans.equals("yes")) {

            System.out.println(
                    "add history = y\n" +
                    "remove history = yy\n" +
                    "view last visited site = yyy");

            String choice = sc.nextLine();

            if (choice.equals("y")) {

                System.out.println("Enter your website name");

                String website = sc.nextLine();

                His.push(website);

            }

            else if (choice.equals("yy")) {

                if (!His.isEmpty()) {

                    System.out.println("Removing last visited site");

                    His.pop();

                } else {

                    System.out.println("History is empty");
                }
            }

            else if (choice.equals("yyy")) {

                if (!His.isEmpty()) {

                    System.out.println("Last visited site is: " + His.peek());

                } else {

                    System.out.println("History is empty");
                }
            }

            else {

                System.out.println("Invalid input");
            }

            System.out.println("Do you want to continue? (yes/no)");

            ans = sc.nextLine();
        }

        System.out.println("Your complete history is: " + His);

        sc.close();
    }
}