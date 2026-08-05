import java.util.Scanner;

public class Expense {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseManager manager = new ExpenseManager();

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    manager.addExpense(category, amount);

                    System.out.println("Expense added successfully!");

                    break;

                case 2:

                    manager.showExpenses();

                    break;

                case 3:

                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}