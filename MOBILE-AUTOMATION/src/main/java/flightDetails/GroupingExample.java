package flightDetails;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class GroupingExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "A"),
                new Student("David", "B"),
                new Student("Eve", "C")
        );

        // Group students by grade
        Map<String, List<String>> groupedByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.mapping(s -> s.getName(), Collectors.toList())));

        groupedByGrade.forEach((f,n)-> {System.out.print(f+"     ");
            System.out.println(String.join(", ",n)); });
    }
}