package PayRollSystemTask04;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String SSN, double salary) {
        super(firstName, lastName, SSN);
        this.weeklySalary = salary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "Salaried Employee: " + super.toString();
    }
}
