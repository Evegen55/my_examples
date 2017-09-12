package Java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author (created on 9/12/2017).
 */
public class MethodReference {

    public static void main(String[] args) {
        //create and populate map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(100, 101);
        map.put(201, 200);
        map.put(300, 200);
        map.put(10, 2);

        final List<Integer> collect1 = map.entrySet().stream()
                .map(entry -> Math.max(entry.getKey(), entry.getValue()))
                .collect(toList());

        collect1.forEach(System.out::println);

        System.out.println("\t\tor");

        final List<Integer> collect2 = map.entrySet().stream()
                .map(MethodReference::doMathMaxWithObjects)
                .collect(toList());

        collect2.forEach(System.out::println);



    }

    private static int doMathMaxWithObjects(Map.Entry<Integer, Integer> entry) {
        return Math.max(entry.getKey(), entry.getValue());
    }

}
