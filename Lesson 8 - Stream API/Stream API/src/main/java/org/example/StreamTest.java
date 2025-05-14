package src.main.java.org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Aman", 23, 23000, "USA"));
        employeeList.add(new Employee("Dev", 52, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Zade", 34, 56000, "India"));
        employeeList.add(new Employee("Steve", 43, 67000, "USA"));
        employeeList.add(new Employee("Sam", 53, 54000, "China"));

        // 1. filter out Employees whose age is greater than 30
        /*Predicate<Employee> employeePredicate = employee -> employee.getAge() > 30;
        Predicate<Employee> finalPredicate = employeePredicate.and(emp -> emp.getSalary() > 30_000);

        Predicate<Employee> compositePredicate = ((Predicate<Employee>) employee -> employee.getAge() > 30)
                .and(employee -> employee.getSalary() > 30_000);

        List<Employee> collect = employeeList.stream()
                .filter(finalPredicate)
                .collect(Collectors.toList());

        System.out.println(collect);*/

        final List<Integer> intList = List.of(
                1,
                12,
                12,
                23,
                32,
                56
        );

        // 2. return distinct numbers, skip first 2 items then limit to 3
        /*List<Integer> list = intList.stream()
                .distinct()
                .skip(2)
                .limit(3)
                .toList();
        System.out.println(list);*/


        // 3. print names of employees in upper case
        /*employeeList.stream()
                .filter(employee -> {
                    System.out.println("Filter");

                    return employee.getCountry().equals("USA");
                })
                .map(emp -> {
                    System.out.println("Map 1");

                    return emp.getName();
                })
                .map(name -> {
                    System.out.println("Map 2");

                    return name.toUpperCase();
                }).forEach(System.out::println);*/

        // 4. check if there is any person residing in USA
        /*boolean residingInUsa = employeeList.stream()
                .anyMatch(emp -> emp.getCountry().equals("USA"));
        System.out.println(residingInUsa);*/

        // 5. check if all persons live in USA
        /*boolean allInUsa = employeeList.stream()
                .allMatch(emp -> emp.getCountry().equals("USA"));
        System.out.println(allInUsa);*/

        // 6. check if all persons not live in Russia
        /*boolean nonLiveInRussia = employeeList.stream()
                .noneMatch(emp -> emp.getCountry().equals("RUSSIA"));
        System.out.println(nonLiveInRussia);*/

        // 7. get first person's name living in China
        /*String employeeName = employeeList.stream()
                .filter(employee -> employee.getCountry().equals("China"))
                .map(Employee::getName)
                .findFirst()
                .orElseThrow();
        System.out.println(employeeName);*/

        // 8. find sum of employees salaries
        /*Double res = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0d, Double::sum);
        System.out.println(res);

        Optional<Double> reduce = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        double sum = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(sum);*/

        // 9. find employee with max salary
        /*Employee employee = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
        System.out.println(employee);*/

        // 10. collect in map [key: name, value: name length]
        /*Map<String, Integer> collect = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp.getName().length(),
                        (name1, name2) -> name1,
                        LinkedHashMap::new
                ));
        System.out.println(collect);*/

        // 11. collect in map [key: name, value: employee]
        /*Map<String, Employee> collect = employeeList.stream()
                .collect(
                        Collectors.toMap(
                                Employee::getName,
                                Function.identity()
                        )
                );
        System.out.println(collect);*/

        // 12. collect employee names in linkedlist
        /*LinkedList<String> collect = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collect);*/


        // 13. get count of employees with salary greater than 50000
        /*long count = employeeList.stream()
                .filter(emp -> emp.getSalary() > 50_000)
                .count();
        System.out.println(count);*/

        // 14. get statistics(sum, max, min, ...) of employee salaries
        /*DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println(doubleSummaryStatistics);*/

        // 15. group employees by country
        /*Map<String, List<Employee>> employeesByCountry = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry
                        )
                );
        System.out.println(employeesByCountry);*/


        // 16. key is the name of the country and the value is the sum
        // of salaries of all of the employees of that country
        /*Map<String, Double> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry,
                                Collectors.summingDouble(Employee::getSalary)
                        )
                );
        System.out.println(collect);*/


        // 17. group employee by country save employees in set
        /*Map<String, List<String>> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(collect);*/


        // 18. employees are grouped by country and age
        /*Map<String, Map<Integer, List<Employee>>> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry,
                                Collectors.groupingBy(Employee::getAge)
                        )
                );
        System.out.println(collect);*/


        // 19. get a Map where the key is the name of the country
        // and the value is the Employee object that has max salary in that country
        /*Map<String, Optional<Employee>> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        )
                );
        System.out.println(collect);*/


        /*Map<Boolean, List<Employee>> collect = employeeList.stream()
                .collect(
                        Collectors.partitioningBy(emp -> emp.getSalary() > 30_000)
                );
        System.out.println(collect);*/


        // 21. Get a Map where the key is the name of the country
        // and the value is the Employee name that has max salary in that country
        /*Map<String, Optional<String>> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCountry,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                        optEmp -> optEmp.map(Employee::getName)
                                )
                        )
                );
        System.out.println(collect);*/

        // flatMap
        /*Stream.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 6),
                        List.of(7, 8, 9)
                )
                .flatMap(Collection::stream)
                .forEach(System.out::println);*/
    }
}
