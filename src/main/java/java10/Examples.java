package java10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
    public static void main(String[] args) {

        //https://4comprehension.com/java-immutable-unmodifiable-stream-api-collectors/
        var collect = Stream.of(42)
                .collect(Collectors.toUnmodifiableList());

    }
}
