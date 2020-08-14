import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        Map<String, Integer> resources = new LinkedHashMap<>();
        String currentResource = null;

        while (true){
            String input = scanner.nextLine();
            count ++;
            if (input.equals("stop")){
                break;
            }

            if (count % 2 == 0){
                resources.put(currentResource, resources.get(currentResource) + Integer.parseInt(input));
            }else {
                resources.putIfAbsent(input, 0);
                currentResource = input;
            }
        }

        resources
            .forEach((k,v) -> System.out.printf("%s -> %d%n",k, v));

        //resources
        //      .entrySet()
        //        .forEach(e -> System.out.println(String.format("%s -> %d",e.getKey(), e.getValue())));

        //for (Map.Entry<String, Integer> result : resources.entrySet()) {
        //System.out.printf("%s -> %d%n",result.getKey(), result.getValue());
        //}
    }
}
