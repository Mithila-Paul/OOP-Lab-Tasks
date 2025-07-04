package lab3;

public class SavingsAccount extends BasicAccount {

    public SavingsAccount(String name, double amount, String number) {
        super(name, number, amount);
    }

    void withdraw(double amount) {
        if (this.accountBalance - amount >= 1000) {
            this.accountBalance -= amount;
            System.out.println("Withdraw Successful.");
        } else {
            System.out.println("Minimum balance of 1000 required.");
        }
    }

    void deposit(double amount) {
        this.accountBalance += amount;
        applyInterest();
        System.out.println("Deposit Successful.");
    }

    void applyInterest() {
        this.accountBalance += this.accountBalance * 0.025;
    }

    boolean canWithdraw(double amount) {
        return amount <= this.accountBalance && (this.accountBalance - amount) >= 1000;
    }
}
