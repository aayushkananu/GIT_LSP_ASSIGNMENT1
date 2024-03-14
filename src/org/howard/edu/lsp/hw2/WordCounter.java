package org.howard.edu.lsp.hw2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // Obtain an input stream for the "words.txt" file
        InputStream inputStream = WordCounter.class.getResourceAsStream("words.txt");

        // Create a map to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            // Read each line from the input stream
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                // Split the line into individual words based on spaces
                String[] words = currentLine.split("\\s+");
                for (String currentWord : words) {
                    // Convert the word into lowercase for case-insensitive counting
                    currentWord = currentWord.toLowerCase();

                    // Check if the word is valid (not a number and greater than length 3)
                    if (!currentWord.matches("\\d+") && currentWord.length() > 3) {
                        // Update the word count in the map
                        wordCountMap.put(currentWord, wordCountMap.getOrDefault(currentWord, 0) + 1);
                    }
                }
            }
        } catch (Exception exception) {
            // Print the stack trace if an exception occurs during file processing
            exception.printStackTrace();
        }

        // Print the word frequencies
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
