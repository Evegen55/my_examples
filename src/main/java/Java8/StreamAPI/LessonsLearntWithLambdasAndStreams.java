package Java8.StreamAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * @author (created on 8/18/2017).
 */
public class LessonsLearntWithLambdasAndStreams {

    public static void main(String[] args) throws IOException {

        final BufferedReader bufferedReader =
                new BufferedReader(new FileReader(new File("src\\test\\resources\\warAndPeace.txt")));
        bufferedReader.lines()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);

        //or
        Files.lines(Paths.get("src\\test\\resources\\warAndPeace.txt"))
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);
    }
}
