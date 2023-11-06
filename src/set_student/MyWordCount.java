package set_student;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class MyWordCount {
    public static final String fileName = "data/fit.txt";

    private final List<String> words = new ArrayList<>();

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
    public int getCount(String pattern) {
        /*
        int count = 0;
        for (String word : words) {
            if (word.equals(pattern)) {
                count++;
            }
        }
        return count;
        */
        return (int) words.stream().filter(word -> word.equals(pattern)).count();
    }

    public List<WordCount> getWordCounts() {
        /*
        List<WordCount> wordCounts = new ArrayList<>();
        for (String word : words) {
            WordCount wordCount = new WordCount(word, getCount(word));
            if (!wordCounts.contains(wordCount)) {
                wordCounts.add(wordCount);
            }
        }
        return wordCounts;
        */
        return words
                .stream()
                .map(word -> new WordCount(word, getCount(word)))
                .distinct()
                .collect(Collectors.toList());
    }

    // Returns the words that their appearance are 1, do not consider duplidated
    // words
    public Set<String> getUniqueWords() {
        /*
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            if (uniqueWords.contains(word)) {
                uniqueWords.remove(word);
            } else {
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
        */
        /*
        Set<String> uniqueWords = new HashSet<>();
        for (WordCount wordCount : getWordCounts()) {
            if (wordCount.getCount() == 1) {
                uniqueWords.add(wordCount.getWord());
            }
        }
        return uniqueWords;
        */
        return getWordCounts()
                .stream()
                .filter(wordCount -> wordCount.getCount() == 1)
                .map(WordCount::getWord)
                .collect(Collectors.toSet());
    }

    // Returns the words in the text file, duplicated words appear once in the
    // result
    public Set<String> getDistinctWords() {
        return new HashSet<>(words);
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public Set<WordCount> printWordCounts() {
        Set<WordCount> sorted = new TreeSet<>(Comparator.comparing(WordCount::getWord));
        sorted.addAll(getWordCounts());
        return sorted;
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according descending order of occurences
    // Example: Bug - 10, An - 3, Nam - 2.
    public Set<WordCount> exportWordCountsByOccurence() {
        Set<WordCount> sorted = new TreeSet<>((o1, o2) -> {
            int byCount = o2.getCount() - o1.getCount();
            int byWord = o1.getWord().compareTo(o2.getWord());
            return byCount == 0 ? byWord : byCount;
        });
        sorted.addAll(getWordCounts());
        return sorted;
    }

    // delete words begining with the given pattern (i.e., delete words begin with
    // 'A' letter
    public Set<String> filterWords(String pattern) {
        Set<String> filterWords = getDistinctWords();
        filterWords.removeIf(s -> s.startsWith(pattern));
        return filterWords;
    }
}
