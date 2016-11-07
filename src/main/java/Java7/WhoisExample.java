package Java7;

import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.net.SocketException;

/**
 * Created by Evegen on 07.11.2016.
 */
public class WhoisExample{
    /**Method to get domain WhoIs information using Apache Commons Net API
     * @param domainName
     * @return
     */
    public String getWhoisDomainInformation(String domainName) {
        StringBuilder info = new StringBuilder("");
        WhoisClient whois = new WhoisClient();
        try {
            whois.connect(WhoisClient.DEFAULT_HOST);
            String data = whois.query("=" + domainName);
            info.append(data);
            whois.disconnect();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info.toString();
    }
}
