import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] characters = scanner.nextLine().split("");

        Map<String, Integer> character = new LinkedHashMap<>();

        for (String ch : characters) {
            if (character.containsKey(ch)){
                character.put(ch, character.get(ch) + 1);
            }else {
                if (ch.equals(" "))
                    continue;
                else {
                    character.put(ch, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> result : character.entrySet()) {
            System.out.printf("%s -> %d%n", result.getKey(), result.getValue());
        }
    }
}
