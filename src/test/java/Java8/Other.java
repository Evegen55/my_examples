package Java8;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Evgenii_Lartcev on 9/21/2016.
 */
public class Other {

    @Test
    public void stringJoiner() {
        String joined = String.join("/", "usr", "local", "bin");
        System.out.println("joined" + "\t" + joined);

        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println("zone ids" + "\t" + ids);
    }

    @Test
    public void filesStreams() throws IOException {
        String path = String.join("/", ".", "src", "test", "resources", "example.txt");
        File file = new File(path);
        Stream<String> lines = Files.lines(file.toPath());
        Optional<String> sourceEntry = lines
                .filter(s -> s.contains("comments"))
                .findFirst();
        System.out.println(sourceEntry.get());
    }

    @Test
    public void filesStreamsImproved() throws IOException {
        Files.lines(Paths.get("src", "test", "resources", "example.txt")) //this is a stream
                .filter(s -> s.contains("comments"))
                .findFirst() //this is an Optional<String>
                .ifPresent(System.out::println);
    }

    @Test
    public void filesStreamsCountWords() throws IOException {
        String path = String.join("/", ".", "src", "test", "resources", "example.txt");
        File file = new File(path);
        //if we want to find words per lines
        Files.lines(file.toPath())
                .map(line ->
                        Stream.of(line.split("[\\P{L}]+")).filter(w -> w.length() > 5).count()
                    )
                .forEach(System.out::println);
        //or if we want to find all words in all lines:
        System.out.println("all words in file with length >5:");
        final long count = Files.lines(file.toPath())
                .flatMap(line ->
                        Stream.of(line.split("[\\P{L}]+")).filter(w -> w.length() > 5)
                        )
                .count();
        System.out.println("\t" + count);
    }

    @Test
    /**
     * print list files in a directory
     */
    public void testListFilesInDirectory() {
        //String path = String.join("/", ".", "src", "main", "java", "Java7", "earthquakes");
        //File file = new File(path);
        //try (Stream<Path> entries = Files.list(file.toPath())) {
        try (Stream<Path> entries = Files.list(Paths.get("src", "main", "java", "Java7", "earthquakes"))) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * print list files in a directory and in all subdirectories
     */
    public void testListFilesInDirectoryAndSub() {
        String path = String.join("/", ".", "src", "main");
        File file = new File(path);
        try (Stream<Path> entries = Files.walk(file.toPath())) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
