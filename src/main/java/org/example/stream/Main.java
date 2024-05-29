package org.example.stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 23000L));
        employees.add(new Employee(2, "Doug", 190000L));
        employees.add(new Employee(3, "Jack", 200000L));
        employees.add(new Employee(4, "Daisy", 240000L));
        employees.add(new Employee(5, "William", 220000L));

        // Print all employees
// Requirement: Print all employees.
        System.out.println("All Employees:");
        employees.stream().forEach(System.out::println);

        System.out.println("...........................");

// Print employees sorted by salary in descending order
// Requirement: Print employees sorted by salary in descending order.
        System.out.println("Employees sorted by salary in descending order:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
                .forEach(System.out::println);

        System.out.println("...........................");

// Filter and print employees whose names start with 'J'
// Requirement: Print employees whose names start with 'J'.
        System.out.println("Employees with names starting with 'J':");
        employees.stream()
                .filter(employee -> employee.getEmpName().toUpperCase().startsWith("J"))
                .forEach(System.out::println);

        System.out.println("...........................");

// Increase each employee's salary by 10,000 and print the new salaries
// Requirement: Increase each employee's salary by 10,000 and print the new salaries.
        System.out.println("Employees' salaries increased by 10,000:");
        employees.stream()
                .map(employee -> IncreaseSalary(employee.getEmpSalary()))
                .forEach(System.out::println);

        System.out.println("...........................");

// Return and print the employee object having the maximum salary
// Requirement: Return and print the employee object having the maximum salary.
        System.out.println("Employee with the maximum salary:");
        Employee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getEmpSalary)).get();
        System.out.println(maxSalaryEmployee);

        System.out.println("...........................");

// Find and print the average salary of all employees
// Requirement: Find and print the average salary of all employees.
        System.out.println("Average salary of all employees:");
        OptionalDouble averageSalary = employees.stream()
                .mapToLong(Employee::getEmpSalary)
                .average();
        System.out.println(averageSalary.orElse(0));

        System.out.println("...........................");

// Filter, sort by name in descending order, map, and collect to list
// Requirement: Filter employees with a salary > 200,000, sort by name in descending order, map to a string, and collect to a list.
        System.out.println("Filtered, sorted, and mapped employee data:");
        List<String> employeeData = employees.stream()
                .filter(employee -> employee.getEmpSalary() > 200000)
                .sorted(Comparator.comparing(Employee::getEmpName).reversed())
                .map(e -> e.getEmpName() + " " + e.getEmpSalary())
                .collect(Collectors.toList());
        employeeData.forEach(System.out::println);

        System.out.println("...........................");

// Complex stream operation: filter, sort, map, group by first letter of name
// Requirement: Filter employees with a salary > 150,000, sort by salary and then name, map to a string, and group by the first letter of the name.
        System.out.println("Grouped employees by the first letter of their name:");
        Map<Character, List<String>> groupedEmployees = employees.stream()
                .filter(employee -> employee.getEmpSalary() > 150000)
                .sorted(Comparator.comparing(Employee::getEmpSalary)
                        .thenComparing(Employee::getEmpName).reversed())
                .map(e -> "ID: " + e.getEmpId() + ", Name: " + e.getEmpName() + ", Salary: " + e.getEmpSalary())
                .collect(Collectors.groupingBy(s -> s.charAt(s.indexOf("Name:") + 6)));
        groupedEmployees.forEach((initial, empList) -> {
            System.out.println("Employees with names starting with '" + initial + "':");
            empList.forEach(System.out::println);
        });

        System.out.println("...........................");

// Group employees by salary range and name, sort by salary, and map to string
// Requirement: Group employees by salary range and name, sort by salary in descending order, and map to a string.
        System.out.println("Grouped, sorted, and mapped employees by salary range:");
        Map<String, Map<String, List<String>>> groupedEmployeesByRange = employees.stream()
                .filter(employee -> employee.getEmpSalary() > 3000)
                .collect(Collectors.groupingBy(
                        Main::getSalaryRange,
                        Collectors.groupingBy(
                                Employee::getEmpName,
                                Collectors.mapping(
                                        e -> "Name: " + e.getEmpName() + ", Salary: " + e.getEmpSalary(),
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list -> list.stream()
                                                        .sorted(Comparator.comparing((String s) -> {
                                                            String[] parts = s.split(", Salary: ");
                                                            return Integer.parseInt(parts[1]);
                                                        }).reversed())
                                                        .collect(Collectors.toList())
                                        )
                                )
                        )
                ));
        groupedEmployeesByRange.forEach((salaryRange, deptMap) -> {
            System.out.println("Salary Range: " + salaryRange);
            deptMap.forEach((name, empList) -> {
                System.out.println(" Employee-Name: " + name);
                empList.forEach(System.out::println);
            });
        });

    }

    public static Long IncreaseSalary(Long salary) {
        return salary + 10000;
    }

    private static String getSalaryRange(Employee employee) {
        Long salary = employee.getEmpSalary();
        if (salary < 50000) {
            return "<50k";
        } else if (salary < 100000) {
            return "50k-100k";
        } else if (salary < 150000) {
            return "100k-150k";
        } else {
            return "150k+";
        }
    }
}


