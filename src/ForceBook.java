import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceBook = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"Lumpawaroo".equals(input)){
            String[] com = input.split(" ");

            String command = "";
            for (String s : com) {
                if (s.equals("|")) {
                    command = "|";
                    break;
                }
                if (s.equals("->")){
                    command = "->";
                    break;
                }
            }

            switch (command){
                case "|":
                    String[] tokens = input.split(" \\| ");
                    String leftSide = tokens[0];
                    String rightSide = tokens[1];
                    forceBook.putIfAbsent(leftSide , new ArrayList<>());
                    if (!forceBook.get(leftSide).contains(rightSide)) {
                        forceBook.get(leftSide).add(rightSide);
                    }
                    break;
                case "->":
                    String[] tokens2 = input.split(" -> ");
                    String user = tokens2[0];
                    String side = tokens2[1];
                    forceBook
                            .forEach((key, value) -> value.remove(user));

                    forceBook.get(side).add(user);
                    System.out.println(String.format("%s joins the %s side!",user, side));
                    break;
            }

            input = scanner.nextLine();
        }

        forceBook
                .forEach((k,v) -> Collections.sort(v));

        forceBook
                .entrySet()
                .stream()
                .sorted((f1, f2) -> Integer.compare(f2.getValue().size(), f1.getValue().size()))
                .forEach(f -> {
                    if(f.getValue().size() > 0){
                    System.out.println(String.format("Side: %s, Members: %d",f.getKey(), f.getValue().size()));
                    for (int i = 0; i < f.getValue().size(); i++) {
                        System.out.println(String.format("! %s", f.getValue().get(i)));
                    }
                    }
                });
    }
}
