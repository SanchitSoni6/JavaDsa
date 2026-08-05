import java.util.ArrayList;

public class ExpenseManager {

    ArrayList<String> expenses = new ArrayList<>();

    public void addExpense(String category, double amount) {
        expenses.add(category + " - ₹" + amount);
    }

    public void showExpenses() {
        for (String expense : expenses) {
            System.out.println(expense);
        }
    }
}