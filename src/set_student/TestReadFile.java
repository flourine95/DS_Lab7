package set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner input = new Scanner(new File("data/hamlet.txt"));
//        Scanner input = new Scanner(new File("data/fit.txt"));
//        while (input.hasNext()) {
//            String word = input.next();
//            System.out.println(word);
//        }
        MyWordCount myWordCount = new MyWordCount();
        System.out.println(myWordCount.getWordCounts());
        System.out.println(myWordCount.getUniqueWords());
        System.out.println(myWordCount.getDistinctWords());
        System.out.println(myWordCount.printWordCounts());
        System.out.println(myWordCount.exportWordCountsByOccurence());
        System.out.println(myWordCount.filterWords("h"));

    }
}