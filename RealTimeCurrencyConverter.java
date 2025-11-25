import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class RealTimeCurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Fetching Live Exchange Rates......");

            //API URL
            URL url =new URL("https://api.exchangerate-api.com/v4/latest/INR");

            //Creating HTTP connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");
            boolean run = true;

            System.out.println("Live Currency Converter");

            while(run){
                System.out.println("----- Conversion Menu -----");
                System.out.println("1. INR (Indian Rupee) -> USD (US Dollar)");
                System.out.println("2. INR (Indian Rupee) -> EUR (Euro)");
                System.out.println("3. INR (Indian Rupee) -> GBP (Great Britain Pound)");
                System.out.println("4. INR (Indian Rupee) -> JPY (Japanese Yen)");
                System.out.println("5. INR (Indian Rupee) -> AUD (Australian Dollar)");
                System.out.println("6. Exits");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();

                if(choice == 6){
                    System.out.println("Exiting.... Thanks for using the converter!");
                    break;
                }

                System.out.print("Enter amount in INR: ");
                double amount = sc.nextDouble();
                double convertedAmount = 0;

                switch(choice){
                    case 1 -> convertedAmount = amount * rates.getDouble("USD");
                    case 2 -> convertedAmount = amount * rates.getDouble("EUR");
                    case 3 -> convertedAmount = amount * rates.getDouble("GBP");
                    case 4 -> convertedAmount = amount * rates.getDouble("JPY");
                    case 5 -> convertedAmount = amount * rates.getDouble("AUD");
                    default -> {
                        System.out.println("Invalid choice. Try again.");
                        continue;
                    }
                }
                System.out.println("Converted Amount: " + String.format("%.2f", convertedAmount));
            }
        } catch (Exception e) {
            System.out.println("Error fetching live rates.");
            System.out.println("Message: " + e.getMessage());
        }
        sc.close();
    }
}