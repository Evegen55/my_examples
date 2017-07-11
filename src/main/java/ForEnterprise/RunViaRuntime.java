package ForEnterprise;

import java.io.IOException;

/**
 * @author (created on 7/11/2017).
 */
public class RunViaRuntime {

    public static void main(String[] args) throws IOException {
        final String[] params = new String[2];
        Runtime.getRuntime().exec("calc");  //we can put parameters here
    }
}
