package me.coding.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToJsonLines {

    public static void main(String[] args) {
        String inputFile = "C:\\code\\data\\leetcode\\src\\main\\java\\me\\coding\\util\\data.json";  // Path to the input JSON file
        String outputFile = "C:\\code\\data\\leetcode\\src\\main\\java\\me\\coding\\util\\output.json";  // Path to the output JSON Lines file

        try {
            // Step 1: Read the input JSON file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(content.toString());

            // Step 3: Write each JSON object as a separate line in the output file
            FileWriter writer = new FileWriter(outputFile);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                writer.write(jsonObject.toString() + "\n");  // Write each object as a new line
            }
            writer.close();

            System.out.println("Conversion to JSON Lines format completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

