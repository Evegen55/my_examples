package SystemProcesses;

import org.junit.Test;

import java.awt.*;
import java.net.URI;

/**
 * Created by Evegen on 27.08.2016.
 */
public class OpenVLCPlayer {
    /**
     * @link: http://www.instanceofjava.com
     * how to open a webpage in browser using java code
     */
    @Test
    public void test() {

        try {

            URI uri = new URI("http://www.instanceofjava.com");

            Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
