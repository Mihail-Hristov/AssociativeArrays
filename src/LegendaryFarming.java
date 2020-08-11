import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();
        boolean isObtained;

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length - 1; i += 2) {
                String newMaterial = input[i + 1].toLowerCase();
                if (keyMaterials.containsKey(newMaterial)) {
                    keyMaterials.put(newMaterial, keyMaterials.get(newMaterial) + Integer.parseInt(input[i]));
                    isObtained = checkForObtained(keyMaterials, newMaterial);

                    if(isObtained) {
                        int newValue = keyMaterials.get(newMaterial) - 250;
                        keyMaterials.put(newMaterial, newValue);
                        keyMaterials
                                .entrySet()
                                .stream()
                                .sorted((i1, i2) -> {
                                    int result = i2.getValue().compareTo(i1.getValue());
                                    if (result == 0) {
                                        result = i1.getKey().compareTo(i2.getKey());
                                    }
                                    return result;
                                }).forEach(p -> System.out.println(String.format("%s: %d", p.getKey(), p.getValue())));

                        for (Map.Entry<String, Integer> entry : junkMaterials.entrySet()) {
                            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                        }
                        return;
                    }
                    } else {
                        if (junkMaterials.containsKey(newMaterial)) {
                            junkMaterials.put(newMaterial, junkMaterials.get(newMaterial) + Integer.parseInt(input[i]));
                        } else {
                            junkMaterials.putIfAbsent(newMaterial, Integer.parseInt(input[i]));
                        }
                    }
            }
        }


    }

    public static boolean checkForObtained(Map<String, Integer> keyMaterial, String item){
        if ((keyMaterial.get(item) >= 250)) {
            String winner = item;
            switch (winner) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
             }
            return true;
        }
        return false;
    }
}
