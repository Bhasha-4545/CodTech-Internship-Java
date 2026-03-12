import java.io.*;

public class FileHandler {

    public static void writeToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hello CodTech Internship");
            bw.close();

            System.out.println("File created and data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        }
    }

    public static void readFromFile(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\nReading content from file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    public static void appendToFile(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write("Learning Java File Handling");
            bw.close();

            System.out.println("\nNew data appended successfully.");

        } catch (IOException e) {
            System.out.println("Error while modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";

        writeToFile(filePath);
        readFromFile(filePath);
        appendToFile(filePath);
        readFromFile(filePath);
    }
}
