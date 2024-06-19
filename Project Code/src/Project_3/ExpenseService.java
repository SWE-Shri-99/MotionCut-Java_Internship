import java.util.*;
import java.util.stream.Collectors;

public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Date date, String category, double amount) {
        expenses.add(new Expense(date, category, amount));
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesSortedByDate() {
        return expenses.stream()
                .sorted((e1, e2) -> e1.getDate().compareTo(e2.getDate()))
                .collect(Collectors.toList());
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double calculateTotalByCategory(String category) {
        return expenses.stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}