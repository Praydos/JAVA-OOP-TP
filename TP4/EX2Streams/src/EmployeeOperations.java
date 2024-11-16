import java.util.*;
import java.util.stream.Collectors;
public class EmployeeOperations {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Finance", 55000),
                new Employee("Charlie", "Engineering", 70000),
                new Employee("Diana", "Engineering", 75000),
                new Employee("Eve", "HR", 45000)
        ));

        // 1. Somme totale des salaires
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Somme totale des salaires : " + totalSalary);

        // 2. Trier les employés par ordre alphabétique du nom
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Employés triés par nom : " + sortedEmployees);

        // 3. Trouver l'employé avec le salaire le plus bas
        Optional<Employee> lowestPaidEmployee = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        lowestPaidEmployee.ifPresent(e -> System.out.println("Employé avec le salaire le plus bas : " + e));

        // 4. Filtrer les employés avec un salaire supérieur à une valeur donnée (par exemple, 50000)
        double threshold = 50000;
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .collect(Collectors.toList());
        System.out.println("Employés avec un salaire supérieur à " + threshold + " : " + filteredEmployees);

        // 5. Trouver l'employé avec le salaire le plus élevé
        Optional<Employee> highestPaidEmployee = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        highestPaidEmployee.ifPresent(e -> System.out.println("Employé avec le salaire le plus élevé : " + e));

        // 6. Concaténer les noms de tous les employés
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .reduce("", (name1, name2) -> name1 + (name1.isEmpty() ? "" : ", ") + name2);
        System.out.println("Noms concaténés de tous les employés : " + concatenatedNames);
    }
}