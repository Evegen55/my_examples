package Java7.Hemmersbach_task;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.Collection;
import java.util.LinkedList;

public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        Collection<Integer> coll = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        //doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();

        for (Node childNode = root.getFirstChild();
             childNode != null;
             childNode = childNode.getNextSibling()) {
            if (childNode instanceof Element) {
                String str = ((Element) childNode).getTextContent();
                if (str.equals(message)) System.out.println(childNode.getAttributes().getNamedItem("entry").getNodeValue());
            }
        }
        return coll;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println(id);
    }
}
