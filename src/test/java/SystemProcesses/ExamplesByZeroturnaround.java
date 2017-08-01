package SystemProcesses;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author (created on 7/24/2017).
 * @see 'https://github.com/zeroturnaround/zt-exec'
 */
public class ExamplesByZeroturnaround {

    private static final Logger logger = LoggerFactory.getLogger(ExamplesByZeroturnaround.class);

    @Test
    public void test() throws InterruptedException, TimeoutException, IOException {
        final String java_version = new ProcessExecutor()
                .command("java", "-version")
                .readOutput(true)
                .execute()
                .outputString();
        logger.info(java_version);
    }

    @Test
    public void testStorage() throws InterruptedException, TimeoutException, IOException {
        final String notification = new ProcessExecutor()
                .command("gsutil.cmd", "notification", "create", "-f", "json", "gs://dev-epm-2")
                .readOutput(true)
                .execute()
                .outputString();
        logger.info(notification);
    }

    @Test
    public void testObf(){
        int a = 2;
        logger.info("{}", a -= a *= a);
    }
}
