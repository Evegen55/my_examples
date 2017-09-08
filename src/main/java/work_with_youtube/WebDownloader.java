package work_with_youtube;

import com.google.common.io.Files;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author (created on 9/1/2017).
 */
public class WebDownloader {

    private static final Logger logger = LoggerFactory.getLogger(WebDownloader.class);

    public void urlPerformerForGet(final String urlForGet) {
        logger.info("Preparing the request ");
        final Request request = Request.Get(URI.create(urlForGet));
        logger.info("Request repared");
        try {
            logger.info("Executing request");
            final Response response = request.execute();
            response.handleResponse(result -> {
                int responseCode = result.getStatusLine().getStatusCode();
                logger.info("Response code is \t" + responseCode);
                final InputStream inputStream = result.getEntity().getContent();
                //way 1
//                StringWriter writer = new StringWriter();
//                IOUtils.copy(inputStream, writer, "UTF-8");
//                String theString = writer.toString();
                //way 2
                printByUsingByteArray(inputStream);

                return EntityUtils.toString(result.getEntity());
            });
            logger.info("request executed");
        } catch (IOException e) {
            logger.error("There is connection error with next stack trace: {}", e.getCause());
        }
    }

    private static void printByUsingByteArray(InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final File file = new File("/fortests.txt");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
            Files.write(buffer, file);
        }
        final String theString = byteArrayOutputStream.toString("UTF-8");

        logger.info(theString);
    }
}
