import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkRegister = new LinkedHashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            String keyName = tokens[1];

            switch (command){
                case "register":
                    String licencePlateNumber = tokens[2];
                    if (!parkRegister.containsKey(keyName)){
                        parkRegister.put(keyName, licencePlateNumber);
                        System.out.println(String.format("%s registered %s successfully",keyName, licencePlateNumber));
                    }else {
                        System.out.println(String.format("ERROR: already registered with plate number %s",licencePlateNumber));
                    }
                    break;
                case "unregister":
                    if (!parkRegister.containsKey(keyName)){
                        System.out.println(String.format("ERROR: user %s not found",keyName));
                    }else {
                        parkRegister.remove(keyName);
                        System.out.println(String.format("%s unregistered successfully",keyName));
                    }
                    break;
            }
        }

        parkRegister.forEach((k, v) -> System.out.println(String.format("%s => %s",k,v)));

    }
}
