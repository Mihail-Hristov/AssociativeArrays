import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] input = scanner.nextLine().split(" ");

        //double[] numbers  = new double[input.length];

        //for (int i = 0; i < input.length; i++) {
           // numbers[i] = Double.parseDouble(input[i]);
        //}

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();

        for (double num : numbers) {
            if (counts.containsKey(num)){
                counts.put(num, counts.get(num) + 1);
            }else {
                counts.put(num, 1);
            }
        }

        DecimalFormat df = new DecimalFormat("#,#######");

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
