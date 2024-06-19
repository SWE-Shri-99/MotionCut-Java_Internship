import java.io.*;
import java.util.*;

public class FileHandler {
    public void saveExpensesToFile(List<Expense> expenses, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(expenses);
        }
    }

    public List<Expense> loadExpensesFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Expense>) ois.readObject();
        }
    }
}