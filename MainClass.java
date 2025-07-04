package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<DepositPremiumAccount> premiumAccounts = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Account System Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Transfer Amount");
            System.out.println("5. Show Account Info");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Select Account Type:\n1. Current\n2. Savings\n3. Premium Deposit");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Account Holder Name: ");
                String holderName = scanner.nextLine();
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter Initial Balance: ");
                double openingBalance = scanner.nextDouble();

                switch (type) {
                    case 1:
                        currentAccounts.add(new CurrentAccount(holderName, openingBalance, accountNumber));
                        break;
                    case 2:
                        savingsAccounts.add(new SavingsAccount(holderName, openingBalance, accountNumber));
                        break;
                    case 3:
                        premiumAccounts.add(new DepositPremiumAccount(holderName, openingBalance, accountNumber));
                        break;
                    default:
                        System.out.println("Invalid Account Type");
                }

            } else if (choice == 2) {
                System.out.println("Account Type:\n1. Current\n2. Savings\n3. Premium Deposit");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter Amount to Deposit: ");
                double amount = scanner.nextDouble();

                boolean found = false;
                switch (type) {
                    case 1:
                        for (CurrentAccount acc : currentAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (SavingsAccount acc : savingsAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                    case 3:
                        for (DepositPremiumAccount acc : premiumAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                }
                if (!found) System.out.println("Account Not Found");

            } else if (choice == 3) {
                System.out.println("Account Type:\n1. Current\n2. Savings\n3. Premium Deposit");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter Amount to Withdraw: ");
                double amount = scanner.nextDouble();

                boolean found = false;
                switch (type) {
                    case 1:
                        for (CurrentAccount acc : currentAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (SavingsAccount acc : savingsAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                    case 3:
                        for (DepositPremiumAccount acc : premiumAccounts) {
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                acc.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        break;
                }
                if (!found) System.out.println("Account Not Found");

            } else if (choice == 4) {
                System.out.println("Source Account Type (1. Current, 2. Savings): ");
                int srcType = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Source Account Number: ");
                String srcAccountNumber = scanner.nextLine();

                BasicAccount source = null;
                if (srcType == 1) {
                    for (CurrentAccount acc : currentAccounts)
                        if (acc.getAccountNumber().equals(srcAccountNumber)) source = acc;
                } else if (srcType == 2) {
                    for (SavingsAccount acc : savingsAccounts)
                        if (acc.getAccountNumber().equals(srcAccountNumber)) source = acc;
                }

                if (source == null) {
                    System.out.println("Source account not found.");
                    continue;
                }

                System.out.print("Amount to Transfer: ");
                double transferAmt = scanner.nextDouble();

                if (!source.canWithdraw(transferAmt)) {
                    System.out.println("Insufficient balance.");
                    continue;
                }

                System.out.println("Destination Account Type (1. Current, 2. Savings): ");
                int dstType = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Destination Account Number: ");
                String dstAccountNumber = scanner.nextLine();

                BasicAccount destination = null;
                if (dstType == 1) {
                    for (CurrentAccount acc : currentAccounts)
                        if (acc.getAccountNumber().equals(dstAccountNumber)) destination = acc;
                } else if (dstType == 2) {
                    for (SavingsAccount acc : savingsAccounts)
                        if (acc.getAccountNumber().equals(dstAccountNumber)) destination = acc;
                }

                if (destination == null) {
                    System.out.println("Destination account not found.");
                    continue;
                }

                source.withdraw(transferAmt);
                destination.deposit(transferAmt);
                System.out.println("Transferred " + transferAmt + " to " + destination.getHolderName());

            } else if (choice == 5) {
                System.out.println("Account Type:\n1. Current\n2. Savings\n3. Premium Deposit");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.nextLine();

                boolean shown = false;
                switch (type) {
                    case 1:
                        for (CurrentAccount acc : currentAccounts)
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                System.out.println(acc);
                                shown = true;
                            }
                        break;
                    case 2:
                        for (SavingsAccount acc : savingsAccounts)
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                System.out.println(acc);
                                shown = true;
                            }
                        break;
                    case 3:
                        for (DepositPremiumAccount acc : premiumAccounts)
                            if (acc.getAccountNumber().equals(accountNumber)) {
                                System.out.println(acc);
                                shown = true;
                            }
                        break;
                }
                if (!shown) System.out.println("Account not found.");

            } else if (choice == 6) {
                System.out.println("Thank you. Exiting.");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
