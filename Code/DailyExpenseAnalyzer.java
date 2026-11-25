import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DailyExpenseAnalyzer {

    static class Expense {
        String id;
        String category;
        double amount;

        Expense(String id, String category, double amount) {
            this.id = id;
            this.category = category;
            this.amount = amount;
        }

        public String toString() {
            return id + " | " + category + " | " + fmt(amount);
        }
    }

    static final String FILE_NAME = "expenses.txt";
    static ArrayList<Expense> expenses = new ArrayList<>();
    static int lastIdNumber = 100;          // first generated ID = X101
    static Scanner sc = new Scanner(System.in);

    static String fmt(double v) {
        if (v == (long) v) return String.valueOf((long) v);
        return String.valueOf(v);
    }

    static void loadFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split("\\|");
                if (p.length != 3) continue;
                try {
                    double amt = Double.parseDouble(p[2].trim());
                    String id = p[0].trim();
                    expenses.add(new Expense(id, p[1].trim(), amt));
                    int num = Integer.parseInt(id.substring(1));
                    if (num > lastIdNumber) lastIdNumber = num;
                } catch (Exception e) {
                
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < expenses.size(); i++) {
                Expense e = expenses.get(i);
                pw.println(e.id + "|" + e.category + "|" + fmt(e.amount));
            }
        } catch (IOException e) {
            System.out.println("Could not save file: " + e.getMessage());
        }
    }

    static void addExpense() {
        System.out.print("Category: ");
        String category = sc.nextLine().trim().replace("|", " ");
        if (category.isEmpty()) {
            System.out.println("Category cannot be empty.");
            return;
        }
        System.out.print("Amount: ");
        String input = sc.nextLine().trim();
        double amount;
        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount. Amount must be greater than zero.");
            return;
        }
        lastIdNumber++;
        Expense e = new Expense("X" + lastIdNumber, category, amount);
        expenses.add(e);
        saveToFile();
        System.out.println("Expense added. ID: " + e);
    }

    static void displayAll() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". " + expenses.get(i));
        }
    }

    static void sortByAmount() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        for (int i = 1; i < expenses.size(); i++) {
            Expense key = expenses.get(i);
            int j = i - 1;
            while (j >= 0 && expenses.get(j).amount < key.amount) {
                expenses.set(j + 1, expenses.get(j));
                j--;
            }
            expenses.set(j + 1, key);
        }
        displayAll();
    }
    static void searchByCategory() {
        System.out.print("Enter category: ");
        String key = sc.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            if (e.category.equalsIgnoreCase(key)) {
                System.out.println("Found: " + e);
                found = true;
            }
        }
        if (!found) System.out.println("No expense found for category: " + key);
    }

    static void totalExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        double total = 0;
        Expense highest = expenses.get(0);
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            total += e.amount;
            if (e.amount > highest.amount) highest = e;
        }
        System.out.println("Total expense: " + fmt(total)
                + " | Highest expense: " + highest.category + " (" + fmt(highest.amount) + ")");
    }

    static void showMenu() {
        System.out.println("\n===== Daily Expense Analyzer =====");
        System.out.println("1 - Add Expense");
        System.out.println("2 - Display All");
        System.out.println("3 - Sort by Amount (high to low)");
        System.out.println("4 - Search by Category");
        System.out.println("5 - Total Expense");
        System.out.println("6 - Exit (save and quit)");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        loadFromFile();
        boolean running = true;
        while (running) {
            showMenu();
            if (!sc.hasNextLine()) break;
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addExpense(); break;
                case "2": displayAll(); break;
                case "3": sortByAmount(); break;
                case "4": searchByCategory(); break;
                case "5": totalExpense(); break;
                case "6": running = false; break;
                default: System.out.println("Invalid option. Choose 1-6.");
            }
        }
        saveToFile();
        System.out.println("Data saved to " + FILE_NAME + ". Goodbye!");
    }
}