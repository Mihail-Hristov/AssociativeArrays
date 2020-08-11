import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrade = new LinkedHashMap<>();
        Map<String, Double> finalResult = new LinkedHasMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentsGrade.putIfAbsent(name, new ArrayList<>());
            studentsGrade.get(name).add(grade);

        }


        studentsGrade
                .entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0) >= 4.50)
                .sorted((s1, s2) -> {
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    return Double.compare(second, first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",s.getKey(),
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0))));

        //for (Map.Entry<String, List<Double>> entry :studentsGrade.entrySet()){
            //Double averageGrade = 0.00;
            //for (int i = 0; i < entry.getValue().size(); i++) {
            //   averageGrade += entry.getValue().get(i);
            //}
            //averageGrade = averageGrade / entry.getValue().size();
            //if (averageGrade >= 4.50){
            //   finalResult.put(entry.getKey(), averageGrade);
            //}

        //}

        //finalResult
        //       .entrySet()
        //        .stream()
        //        .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()))
        //        .forEach(s -> System.out.println(String.format("%s -> %.2f",s.getKey(), s.getValue())));

    }
}
