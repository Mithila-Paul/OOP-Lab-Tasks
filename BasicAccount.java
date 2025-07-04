package lab3;

abstract class BasicAccount {
    private String holderName;
    protected double accountBalance = 0.0;
    private String accountNumber;

    public BasicAccount() {}

    public BasicAccount(String number, String name) {
        this.holderName = name;
        this.accountNumber = number;
    }

    public BasicAccount(String name, String number, double openingBalance) {
        this.holderName = name;
        this.accountNumber = number;
        this.accountBalance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    abstract boolean canWithdraw(double amount);

    abstract void applyInterest();

    public String toString() {
        return "Account [Number: " + this.accountNumber + ", Holder: " + this.holderName + ", Balance: " + this.accountBalance + "]";
    }
}
