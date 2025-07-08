package PayRollSystemTask04;
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = SSN;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return String.format("%s %s\nSSN: %s", firstName, lastName, socialSecurityNumber);
    }
}

