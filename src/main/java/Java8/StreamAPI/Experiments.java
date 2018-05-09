package Java8.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Experiments {

    public static void main(String[] args) {


        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(toList());
        System.out.println(myList);

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "b"));
        System.out.println(list);

        List<String> collect = list
                .stream()
                .flatMap(Collection::stream)
                .collect(toList());
        System.out.println(collect);


    }
}
