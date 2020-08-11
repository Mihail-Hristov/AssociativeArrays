import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : input) {
            String wordInLowerCase = word.toLowerCase();
            if (counts.containsKey(wordInLowerCase)){
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            }else {
                counts.put(wordInLowerCase, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1){
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            if (i == 0) {
                System.out.print(odds.get(0));
            } else {
                System.out.printf(", %s", odds.get(i));
            }
        }
    }
}
