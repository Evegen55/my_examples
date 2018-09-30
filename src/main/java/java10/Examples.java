package java10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Examples {
    public static void main(String[] args) {

        //https://4comprehension.com/java-immutable-unmodifiable-stream-api-collectors/
        var collect = Stream.of(42)
                .collect(Collectors.toUnmodifiableList());

        List<String> strings = Stream.of("C", "A", "B")
                .sorted()
                .collect(toList());

    }
}
