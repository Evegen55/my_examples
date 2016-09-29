package guava;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.google.common.io.CharStreams.readLines;

/**
 * Created by Evgenii_Lartcev on 9/29/2016.
 */
public class TestFeautures {

    @Test
    //https://github.com/google/guava/wiki/IOExplained
    public void test() throws IOException {
        List<String> list = readLines(new FileReader(new File("src/test/resources/warAndPeace.txt")));
        list.forEach(System.out::println);
        System.out.println("nums of lines in the file" + "\t" + list.size());
    }
}
