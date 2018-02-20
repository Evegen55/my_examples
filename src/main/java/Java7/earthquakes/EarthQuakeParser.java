package Java7.earthquakes;


import Java7.earthquakes.model.QuakeEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lartsev
 */
public final class EarthQuakeParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(EarthQuakeParser.class);

    /**
     * @param source
     * @return
     */
    public static List<QuakeEntry> readAndParseXMLFrom(final String source) {
        LOGGER.info("Start parsing the {} source", source);
        final ArrayList<QuakeEntry> list = new ArrayList<>();

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            if (source.startsWith("http")) {
                document = builder.parse(source);
            } else {
                document = builder.parse(new File(source));
            }

            final NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int k = 0; k < nodeList.getLength(); k++) {
                Node node = nodeList.item(k);

                if (node.getNodeName().equals("entry")) {
                    Element elem = (Element) node;
                    NodeList t1 = elem.getElementsByTagName("georss:point");
                    NodeList t2 = elem.getElementsByTagName("title");
                    NodeList t3 = elem.getElementsByTagName("georss:elev");
                    double lat = 0.0, lon = 0.0, depth = 0.0;
                    String title = "NO INFORMATION";
                    double mag = 0.0;

                    if (t1 != null) {
                        String s2 = t1.item(0).getChildNodes().item(0).getNodeValue();
                        //System.out.print("point2: "+s2);
                        String[] args = s2.split(" ");
                        lat = Double.parseDouble(args[0]);
                        lon = Double.parseDouble(args[1]);
                    }
                    if (t2 != null) {
                        String s2 = t2.item(0).getChildNodes().item(0).getNodeValue();

                        String mags = s2.substring(2, 5);
                        if (mags.contains("?")) {
                            mag = 0.0;
                            LOGGER.error("unknown magnitude in data");
                        } else {
                            mag = Double.parseDouble(mags);
                        }
                        int sp = s2.indexOf(" ", 5);
                        title = s2.substring(sp + 1);
                        if (title.startsWith("-")) {
                            int pos = title.indexOf(" ");
                            title = title.substring(pos + 1);
                        }
                    }
                    if (t2 != null) {
                        String s2 = t3.item(0).getChildNodes().item(0).getNodeValue();
                        depth = Double.parseDouble(s2);
                    }
                    QuakeEntry loc = new QuakeEntry(lat, lon, mag, title, depth);
                    list.add(loc);
                }

            }
            return list;
        } catch (ParserConfigurationException pce) {
            LOGGER.error("parser configuration exception", pce);
        } catch (SAXException se) {
            LOGGER.error("sax exception", se);
        } catch (IOException ioe) {
            LOGGER.error("ioexception", ioe);
        }
        return null;
    }

}
