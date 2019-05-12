package h_MapsLambdaStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (true) {
            String[] line = sc.nextLine().split("\\s+:\\s+");
            String course = line[0];

            if (course.equals("end")) {
                break;
            }

            String student = line[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(student);
            } else {
                courses.get(course).add(student);
            }
        }

        Map<String, List<String>> orderedCourses = new LinkedHashMap<>();

        courses.entrySet().stream().sorted((map1, map2) -> {
            int size = Integer.compare(map2.getValue().size(), map1.getValue().size());
            return size;
        }).forEach(e -> orderedCourses.put(e.getKey(), e.getValue()));

        for (Map.Entry<String, List<String>> kvp : orderedCourses.entrySet()) {
            System.out.printf("%s: %d%n",kvp.getKey(), kvp.getValue().size());
            kvp.getValue().stream().sorted().forEach(v -> System.out.printf("-- %s%n", v));
        }
    }
}