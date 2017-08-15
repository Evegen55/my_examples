package ForEnterprise.XML;

import org.junit.Test;

import java.util.List;

/**
 * @author (created on 8/15/2017).
 */
public class TestStax {

    @Test
    public void testRead() {
        StaXParser read = new StaXParser();
        List<Item> readConfig = read.readConfig("src/test/resources/xmleventreader.xml");
        for (Item item : readConfig) {
            System.out.println(item);
        }
        System.out.println("");
        //or with Java8
        new StaXParser().readConfig("src/test/resources/xmleventreader.xml")
                .forEach(System.out::println);

    }

    @Test
    public void testWrite() {
        StaxWriter configFile = new StaxWriter();
        configFile.setFile("src/test/resources/xmlevent_writed.xml");
        try {
            configFile.saveConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
