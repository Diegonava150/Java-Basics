import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account owner name: ");
        String ownerName = scanner.nextLine();
        BankAccount account = new BankAccount(ownerName);

        BankAccount.manageAccount(account, scanner);
    }
}