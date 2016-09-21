package Java8;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        String path = String.join("\\", ".", "src", "test", "resources", "example.txt");
        File file = new File(path);
        Stream<String> lines = Files.lines(file.toPath());
        Optional<String> sourceEntry = lines
                .filter(s -> s.contains("comments"))
                .findFirst();
        System.out.println(sourceEntry.get());
    }

    @Test
    /**
     * print list files in a directory
     */
    public void testListFilesInDirectory() {
        String path = String.join("\\", ".", "src", "main", "java", "Java7", "earthquakes");
        File file = new File(path);
        try (Stream<Path> entries = Files.list(file.toPath())) {
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
        String path = String.join("\\", ".", "src", "main");
        File file = new File(path);
        try (Stream<Path> entries = Files.walk(file.toPath())) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
