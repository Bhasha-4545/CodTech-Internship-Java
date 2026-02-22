import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.json.JSONObject;

public class WeatherAPI {

    public static void main(String[] args) {

        try {
            // API URL (Hyderabad weather)
            String apiUrl =
                "https://api.open-meteo.com/v1/forecast"
                + "?latitude=17.3850"
                + "&longitude=78.4867"
                + "&current_weather=true";

            // Create URL object
            URL url = URI.create(apiUrl).toURL();

            // Open connection
            HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            // Read API response
            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
                );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Convert response to JSON
            JSONObject jsonObject =
                new JSONObject(response.toString());

            JSONObject currentWeather =
                jsonObject.getJSONObject("current_weather");

            double temperature =
                currentWeather.getDouble("temperature");

            double windSpeed =
                currentWeather.getDouble("windspeed");

            // Display output
            System.out.println("🌤️ Weather Report");
            System.out.println("-----------------");
            System.out.println("Temperature : " + temperature + " °C");
            System.out.println("Wind Speed  : " + windSpeed + " km/h");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
