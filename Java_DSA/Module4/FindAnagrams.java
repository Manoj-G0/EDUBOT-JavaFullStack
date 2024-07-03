import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class AnagramFinder {
    public static void main(String[] args) {
        String filename = "C:/Users/manoj/OneDrive/Desktop/TestFile.txt"; 
        Map<String, List<String>> anagramGroups = new HashMap<>();
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        for (List<String> group : anagramGroups.values()) {
            if (group.size() > 1) {
                System.out.println(group);
            }
        }
    }
}
