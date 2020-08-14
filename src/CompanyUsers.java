import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)){
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            companies.putIfAbsent(company, new ArrayList<>());
            if (!companies.get(company).contains(id)){
                companies.get(company).add(id);
            }

            input = scanner.nextLine();
        }

        companies
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    for (int i = 0; i < c.getValue().size(); i++) {
                        System.out.println(String.format("-- %s",c.getValue().get(i)));
                    }
                });
    }
}
