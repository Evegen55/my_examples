package ForEnterprise;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.builder.fluent.PropertiesBuilderParameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author (created on 11/29/2017).
 */
public class ApacheTests {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApacheTests.class);

    public static void readProperty() {
        Parameters params = new Parameters();
        LOGGER.info("====1");

        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class);

        LOGGER.info("====2");
        final PropertiesBuilderParameters propertiesBuilderParameters = params.properties()
                .setFileName("usergui.properties");
        LOGGER.info("====2.1");

        builder.configure(propertiesBuilderParameters);
        LOGGER.info("====2.2");

        try {
            Configuration config = builder.getConfiguration();
            String backColor = config.getString("style");
            System.out.println(backColor);

        } catch (ConfigurationException cex) {
            LOGGER.info("====3");
        }
    }
}
