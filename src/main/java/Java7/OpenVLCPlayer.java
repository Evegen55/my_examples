package Java7;

import java.awt.*;
import java.net.URI;

/**
 * Created by Evegen on 27.08.2016.
 */
public class OpenVLCPlayer {
    /**
     * @website: www.instanceofjava.com
     * @category: how to open a webpage in browser using java code
     */

    public static void main(String[] args)  {


        try {

            URI uri= new URI("http://www.instanceofjava.com");

            Desktop.getDesktop().browse(uri);
            System.out.println("Web page opened in browser");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
