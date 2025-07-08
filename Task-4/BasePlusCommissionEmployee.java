package PayRollSystemTask04;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                      double sales, double rate, double baseSalary) {
        super(firstName, lastName, ssn, sales, rate);
        this.baseSalary = baseSalary;
    }

    public void increaseBaseSalaryBy10Percent() {
        baseSalary= baseSalary* 1.10;
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    @Override
    public String toString() {
        return "Base Plus Commission Employee: " + super.toString();
    }
}
