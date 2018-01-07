package xml_task;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author (created on 9/25/2017).
 */
public class XmlChecker {

    //path to a XML file[0], DTD or XSD file[1] and Xpath to XML element[2]
    public static void main(String[] args) {

        String pathToXml = "";
        String pathToXSD_orDTD = "";
        String xPathToElement = "";

        if (args.length >= 2) { //first two items are necessary
            pathToXml = args[0];
            pathToXSD_orDTD = args[1];
            xPathToElement = args[2];
        }

        if (pathToXml != null && pathToXSD_orDTD != null) {
            final Source xmlFile = new StreamSource(new File(pathToXml)); //xml
            try {

                //first task
                validateXml(pathToXSD_orDTD, xmlFile);

                //second task
                if (xPathToElement != null) {
                    System.out.println("the number of certain element in the XML file" + findByExpression(pathToXml, xPathToElement));
                }

            } catch (SAXException e) {
                System.out.println(xmlFile.getSystemId() + " is not valid" + "\n" + e);
            } catch (IOException | ParserConfigurationException | XPathExpressionException e) {
                e.printStackTrace();
            }
        }
    }

    //for tests purpose
    protected static void validateXml(final String pathToXSD_orDTD, final Source xmlFile) throws SAXException, IOException {
        final URL urlXsd = new URL(pathToXSD_orDTD); //xsd
        final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        final Schema schema = schemaFactory.newSchema(urlXsd);
        final Validator validator = schema.newValidator();
        validator.validate(xmlFile);
        System.out.println(xmlFile.getSystemId() + " is valid");
    }

    //for tests purpose
    protected static int findByExpression(final String pathToXml, final String xPathToElement)
            throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(pathToXml);
        final XPathFactory xPathfactory = XPathFactory.newInstance();
        final XPath xpath = xPathfactory.newXPath();
        final XPathExpression expr = xpath.compile(xPathToElement);

        final NodeList list = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return list.getLength();
    }
}
