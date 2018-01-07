package work_with_youtube;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author (created on 9/8/2017).
 */
public class WebDownloaderTest {

    private WebDownloader webDownloader;

    @Before
    public void setUp() throws Exception {
        webDownloader = new WebDownloader();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void urlPerformerForGet() throws Exception {
        final String urlForGet = "https://youtu.be/Kf421HEiNnk?list=PLX8CzqL3ArzWBRW9AzwDwEU18jKnXKSzb";
        webDownloader.urlPerformerForGet(urlForGet);
    }

}