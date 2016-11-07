package ForEnterprise;

import org.junit.Test;

/**
 * Created by Evegen on 07.11.2016.
 */
public class WhoisExampleTest {
    @Test
    public void getWhoisDomainInformation() throws Exception {
        WhoisExample whoisExample = new WhoisExample();
        System.out.println(whoisExample.getWhoisDomainInformation("oracle.com"));
    }

}