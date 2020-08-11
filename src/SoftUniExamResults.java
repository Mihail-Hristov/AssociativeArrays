import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> examResult = new TreeMap<>();
        Map<String, Integer> count = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"exam finished".equals(input)) {

            String[] tokens = input.split("-");
            String check = tokens[1];

            if (check.equals("banned")) {
                String nameForRemove = tokens[0];
                examResult.remove(nameForRemove);
            } else {
                String name = tokens[0];
                int result = Integer.parseInt(tokens[2]);
                String language = tokens[1];

                examResult.putIfAbsent(name, 0);
                if (result > examResult.get(name)) {
                    examResult.put(name, result);
                }


                count.putIfAbsent(language, 0);
                count.put(language, count.get(language) + 1);

            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        examResult
                .entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s -> System.out.println(String.format("%s | %d",s.getKey(),s.getValue())));
        System.out.println("Submissions:");
        count
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(c -> System.out.println(String.format("%s - %d",c.getKey(),c.getValue())));
    }
}
