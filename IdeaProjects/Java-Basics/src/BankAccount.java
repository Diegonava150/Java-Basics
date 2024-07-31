import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccount {
    private String personName;
    private BigDecimal balance;

    public BankAccount(String personName) {
        this.personName = personName;
        this.balance = BigDecimal.ZERO;
    }

    public void addMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
            System.out.println("Deposited: $" + amount + ". Current balance: $" + balance);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void retrieveMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
            System.out.println("Withdrawn: $" + amount + ". Current balance: $" + balance);
        } else if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public static void manageAccount(BankAccount account, Scanner scanner) {
        System.out.println("\nChoose an option:");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                BigDecimal addAmount = scanner.nextBigDecimal();
                account.addMoney(addAmount);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                BigDecimal retrieveAmount = scanner.nextBigDecimal();
                account.retrieveMoney(retrieveAmount);
                break;
            case 3:
                System.out.println("Exiting");
                return;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
        manageAccount(account, scanner);
    }
}