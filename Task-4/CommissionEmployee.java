package PayRollSystemTask04;

public class CommissionEmployee extends Employee {
    protected double grossSales;
    protected double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String ssn, double sales, double rate) {
        super(firstName, lastName, ssn);
        this.grossSales = sales;
        this.commissionRate = rate;
    }

    @Override
    public double earnings() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return "Commission Employee: " + super.toString();
    }
}
