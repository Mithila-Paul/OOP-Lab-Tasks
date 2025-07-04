package lab3;

public class CurrentAccount extends BasicAccount {

    public CurrentAccount(String name, double amount, String number) {
        super(name, number, amount);
    }

    public CurrentAccount(String name, String number) {
        super(number, name);
    }

    void withdraw(double amount) {
        if (amount <= this.accountBalance) {
            this.accountBalance -= amount;
            System.out.println("Withdraw Successful.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void deposit(double amount) {
        this.accountBalance += amount;
        System.out.println("Deposit Successful.");
    }

    void applyInterest() {}

    boolean canWithdraw(double amount) {
        return amount <= this.accountBalance;
    }
}
