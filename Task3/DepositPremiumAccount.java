package lab3;

public class DepositPremiumAccount extends BasicAccount {
    int depositCounter = 0;

    public DepositPremiumAccount(String name, double amount, String number) {
        super(name, number, amount);
    }

    void deposit(double amount) {
        this.accountBalance += amount;
        depositCounter++;
        applyInterest();
        System.out.println("Deposit Successful.");
    }

    void withdraw(double amount) {
        if (depositCounter >= 5 && accountBalance >= amount) {
            this.accountBalance -= amount;
            System.out.println("Withdraw Successful.");
        } else {
            System.out.println("Withdrawal not allowed before 5 deposits. Total deposits made: " + depositCounter);
        }
    }

    void applyInterest() {
        this.accountBalance += this.accountBalance * 0.07;
    }

    boolean canWithdraw(double amount) {
        return amount <= this.accountBalance && depositCounter >= 5;
    }
}
