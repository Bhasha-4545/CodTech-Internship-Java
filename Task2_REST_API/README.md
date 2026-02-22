# Task 2 – Java REST API Client

## Objective
To develop a Java application that consumes a public REST API and displays the retrieved data in a structured format.

## Description
This project demonstrates how Java can interact with external REST APIs using HttpURLConnection.
The application fetches real-time weather data from the Open-Meteo public API, parses the JSON
response using the org.json library, and displays important weather details such as temperature
and wind speed.

## Technologies Used
- Java
- HttpURLConnection
- JSON (org.json library)

## API Used
- Open-Meteo Weather API
- URL: https://api.open-meteo.com

## How to Run
1. Open terminal in the project directory.
2. Compile the program:
   javac -cp ".;json-20251224.jar" WeatherAPI.java
3. Run the program:
   java -cp ".;json-20251224.jar" WeatherAPI

## Output
The program displays the current temperature and wind speed for Hyderabad city
based on real-time data fetched from the REST API.

## Conclusion
This task helped in understanding REST API consumption, HTTP requests, JSON parsing,
and real-world Java application development.
