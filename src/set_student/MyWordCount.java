package set_student;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class MyWordCount {
    public static final String fileName = "data/fit.txt";

    private List<String> words = new ArrayList<>();

    public MyWordCount() {
        try {
            // loading all the words in the file
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public List<WordCount> getWordCounts() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        return map
                .entrySet()
                .stream()
                .map(e -> new WordCount(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    // Returns the words that their appearance are 1, do not consider duplidated
    // words
    public Set<String> getUniqueWords() {
      return null;
    }

    // Returns the words in the text file, duplicated words appear once in the
    // result
    public Set<String> getDistinctWords() {
        // TODO
        return new HashSet<>(words);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public Set<WordCount> printWordCounts() {
        // TODO
        return null;
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according descending order of occurences
    // Example: Bug - 10, An - 3, Nam - 2.
    public Set<WordCount> exportWordCountsByOccurence() {
        // TODO
        return null;
    }

    // delete words begining with the given pattern (i.e., delete words begin with
    // 'A' letter
    public Set<String> filterWords(String pattern) {
        // TODO
        return null;
    }
}
