package Java8;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Evgenii_Lartcev on 9/22/2016.
 * from http://www.topjavatutorial.com/java/java-programs/sort-map-java-8/
 */
public class MapSortByValueExample {

    @Test
    public void testMapSorted() {
        Map<String, String> countryCapitalMap = new HashMap<String, String>();
        countryCapitalMap.put("guyana", "georgetown");
        countryCapitalMap.put("nepal", "kathmandu");
        countryCapitalMap.put("australia", "canberra");
        countryCapitalMap.put("india", "new delhi");
        countryCapitalMap.put("japan", "tokyo");

        System.out.println("Original Map : \n" + countryCapitalMap);

        //this is my experiment
        System.out.println("\n sorted stream : ");
        countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
                //)
                //.entrySet().stream()
                .forEach(System.out::println) //print it
        ;
        System.out.println("\n Original Map after sorting stream : \n" + countryCapitalMap);

        //this is from http://www.topjavatutorial.com/java/java-programs/sort-map-java-8/
        Map<String, String> sortedMap = new LinkedHashMap<>();
        countryCapitalMap.entrySet().stream()
               .sorted(Map.Entry.comparingByValue())
               .forEachOrdered(c -> sortedMap.put(c.getKey(), c.getValue()));

        System.out.println("\n new map sorted by value : \n" + sortedMap);
    }
}
