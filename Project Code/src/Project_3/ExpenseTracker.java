import java.io.*;
import java.util.*;
import java.text.*;

public class ExpenseTracker {
    private static UserService userService = new UserService();
    private static ExpenseService expenseService = new ExpenseService();
    private static FileHandler fileHandler = new FileHandler();
    private static final String FILENAME = "expenses.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadExpenses();

        System.out.println("Welcome to the Expense Tracker!");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    if (login(scanner)) {
                        manageExpenses(scanner);
                    }
                    break;
                case 3:
                    saveExpenses();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.register(username, password)) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose another one.");
        }
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private static void manageExpenses(Scanner scanner) {
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total by Category");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewTotalByCategory(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        try {
            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

            System.out.print("Enter category: ");
            String category = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            expenseService.addExpense(date, category, amount);
            System.out.println("Expense added successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }

    private static void viewExpenses() {
        List<Expense> expenses = expenseService.getExpensesSortedByDate();
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println("Date: " + expense.getDate() + ", Category: " + expense.getCategory() + ", Amount: " + expense.getAmount());
            }
        }
    }

    private static void viewTotalByCategory(Scanner scanner) {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        double total = expenseService.calculateTotalByCategory(category);
        System.out.println("Total amount spent on " + category + ": " + total);
    }

    private static void saveExpenses() {
        try {
            fileHandler.saveExpensesToFile(expenseService.getExpenses(), FILENAME);
            System.out.println("Expenses saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving expenses.");
        }
    }

    private static void loadExpenses() {
        try {
            List<Expense> expenses = fileHandler.loadExpensesFromFile(FILENAME);
            for (Expense expense : expenses) {
                expenseService.addExpense(expense.getDate(), expense.getCategory(), expense.getAmount());
            }
            System.out.println("Expenses loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous expense data found. Starting fresh.");
        }
    }
}