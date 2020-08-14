import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"end".equals(input)){
            String[] tokens = input.split(" :");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);
            Collections.sort(courses.get(courseName));

            input = scanner.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
                .forEach(c -> {
                    System.out.printf("%s: %d%n",c.getKey(), c.getValue().size());
                    for (int i = 0; i < c.getValue().size(); i++) {
                        System.out.println(String.format("--%s",c.getValue().get(i)));
                    }
                });

    }
}
