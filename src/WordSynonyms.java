import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < groups; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (words.containsKey(word)){
                List<String> stringList = words.get(word);
                stringList.add(synonym);
                words.put(word, stringList);
            }else {
                List<String> synonymList = new ArrayList<>();
                synonymList.add(synonym);
                words.put(word, synonymList);
            }
        }

        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s - %s%n",entry.getKey(),
                    entry.getValue()
                            .toString()
                            .replaceAll("[\\]\\[]",""));
        }
    }
}
