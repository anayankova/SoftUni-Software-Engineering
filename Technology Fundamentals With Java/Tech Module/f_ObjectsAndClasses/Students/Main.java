package f_ObjectsAndClasses.Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n= Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Student student = new Student(data[0], data[1], Double.parseDouble(data[2]));
            students.add(student);

        }

        students.stream().sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .forEach(e -> {
                    System.out.println(e.toString());
                } );

    }
}
