import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM1 {
    private static int balance = 1000; // Initial balance
    private static int transactionCount = 0; // Track the number of transactions
    private static List<String> transactionHistory = new ArrayList<>(); // Store transaction details

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("UserID : avinash and Pin : 1703");
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user pin: ");
        String userPin = scanner.nextLine();

        if (authenticateUser(userId, userPin)) {
            System.out.println("Login successful!");

            // ATM functionality menu
            while (true) {
                printMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showTransactionsHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        int withdrawalAmount = scanner.nextInt();
                        withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = scanner.nextInt();
                        deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter transfer amount: ");
                        int transferAmount = scanner.nextInt();
                        System.out.print("Enter recipient's account number: ");
                        int recipientAccountNumber = scanner.nextInt();
                        transfer(transferAmount, recipientAccountNumber);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid user id or pin. Login failed.");
        }
    }

    // Authenticate user
    private static boolean authenticateUser(String userId, String userPin) {
        // Implement your authentication logic here
        // Return true if authentication is successful, false otherwise
        // You can use a predefined user id and pin for simplicity or create a user
        // database
        return userId.equals("avinash") && userPin.equals("1703");
    }

    // Print ATM functionality menu
    private static void printMenu() {
        System.out.println("\nATM Functionality Menu");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    // Show transactions history
    private static void showTransactionsHistory() {
        System.out.println("Showing transaction history...");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Withdraw money
    private static void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            balance -= amount;
            transactionCount++;
            String transaction = "Withdrawal of " + amount + " successful.";
            transactionHistory.add(transaction);
            System.out.println(transaction);
        }
    }

    // Deposit money
    private static void deposit(int amount) {
        balance += amount;
        transactionCount++;
        String transaction = "Deposit of " + amount + " successful.";
        transactionHistory.add(transaction);
        System.out.println(transaction);
    }

    // Transfer money to another account
    private static void transfer(int amount, int recipientAccountNumber) {
        balance -= amount;
        transactionCount++;
        String transaction = "Transfer of " + amount + " to account " + recipientAccountNumber + " successful.";
        transactionHistory.add(transaction);
        System.out.println(transaction);
    }
}
