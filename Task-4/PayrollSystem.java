package PayRollSystemTask04;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Employee[] employees = new Employee[4];
        employees[0] = new SalariedEmployee("Mithila", "Paul", "BSSE1633", 10000);
        employees[1] = new HourlyEmployee("Samiha", "Chowdhury", "LU-2025-89", 20, 47);
        employees[2] = new CommissionEmployee("Asshifa", "Sultana", "BSSE1632", 5000, 0.1);
        employees[3] = new BasePlusCommissionEmployee("No", "Name", "No-ID-000", 4000, 0.05, 300);

        // This is to increase the salary by 10% for BaseplusComission Employees
        for (Employee i : employees) {
            if (i instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) i).increaseBaseSalaryBy10Percent();
            }
        }

        while (true) {
            System.out.println("\n========== Payroll Menu ==========");
            System.out.println("1. View current employees and earnings");
            System.out.println("2. Calculate new employee earnings");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            if (choice == 1) {
                System.out.println("\n--- Current Employees ---");
                for (Employee e : employees) {
                    System.out.println(e.toString());
                    System.out.printf("Earnings: $%.2f\n\n", e.earnings());
                }

            } else if (choice == 2) {
                System.out.println("Choose employee type:");
                System.out.println("1. Salaried");
                System.out.println("2. Hourly");
                System.out.println("3. Commission");
                System.out.println("4. Base Plus Commission");
                System.out.print("Your choice: ");
                int type = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("First Name: ");
                String firstName = sc.nextLine();
                System.out.print("Last Name: ");
                String lastName = sc.nextLine();
                System.out.print("SSN: ");
                String ssn = sc.nextLine();

                Employee temp = null;

                switch (type) {
                    case 1:
                        System.out.print("Weekly Salary: ");
                        double salary = sc.nextDouble();
                        temp = new SalariedEmployee(firstName, lastName, ssn, salary);
                        break;
                    case 2:
                        System.out.print("Hourly Wage: ");
                        double wage = sc.nextDouble();
                        System.out.print("Hours Worked: ");
                        double hours = sc.nextDouble();
                        temp = new HourlyEmployee(firstName, lastName, ssn, wage, hours);
                        break;
                    case 3:
                        System.out.print("Gross Sales: ");
                        double sales = sc.nextDouble();
                        System.out.print("Commission Rate: ");
                        double rate = sc.nextDouble();
                        temp = new CommissionEmployee(firstName, lastName, ssn, sales, rate);
                        break;
                    case 4:
                        System.out.print("Gross Sales: ");
                        double sales2 = sc.nextDouble();
                        System.out.print("Commission Rate: ");
                        double rate2 = sc.nextDouble();
                        System.out.print("Base Salary: ");
                        double base = sc.nextDouble();
                        BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(firstName, lastName, ssn, sales2, rate2, base);
                        bpce.increaseBaseSalaryBy10Percent();
                        temp = bpce;
                        break;
                    default:
                        System.out.println("Invalid type.");
                }

                if (temp != null) {
                    System.out.println("\n--- New Employee Details ---");
                    System.out.println(temp.toString());
                    System.out.printf("Earnings: $%.2f\n", temp.earnings());
                }

            } else if (choice == 3) {
                System.out.println("Exiting. Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        sc.close();
    }
}
