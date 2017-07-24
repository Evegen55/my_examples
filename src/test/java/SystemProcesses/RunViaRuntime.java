package SystemProcesses;

import org.junit.Test;

import java.io.IOException;

/**
 * @author (created on 7/11/2017).
 */
public class RunViaRuntime {

    @Test
    public void test() throws IOException {
        Runtime.getRuntime().exec("calc");  //we can put parameters here
    }
}
