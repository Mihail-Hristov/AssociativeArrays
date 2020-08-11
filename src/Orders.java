import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> products = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"buy".equals(input)){
            String[] newProduct = input.split(" ");
            String theNameOfTheProduct = newProduct[0];
            Double priceOfTheProduct = Double.parseDouble(newProduct[1]);
            Double quantityOfThrProduct = Double.parseDouble(newProduct[2]);

            List<Double> current = new ArrayList<>();
            current.add(priceOfTheProduct);
            current.add(quantityOfThrProduct * 1.0);

            if (products.containsKey(theNameOfTheProduct)) {
                List<Double> temp = products.get(theNameOfTheProduct);
                Double newQuantity = temp.get(1) + quantityOfThrProduct;
                current.set(1, newQuantity);
                current.set(0, priceOfTheProduct);
            }
            products.put(theNameOfTheProduct, current);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry :products.entrySet()){
            List<Double> temp = entry.getValue();
            System.out.printf("%s -> %.2f%n",entry.getKey(), temp.get(0) * temp.get(1));
        }
    }
}

