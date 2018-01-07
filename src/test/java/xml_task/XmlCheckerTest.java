package xml_task;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static xml_task.XmlChecker.findByExpression;

/**
 * @author (created on 9/25/2017).
 */
public class XmlCheckerTest {

    final String pathToXml = "D:\\1_Workspaces\\github\\my_examples\\src\\test\\resources\\xsd_dtd\\shiporder.xml";
    final String pathToXSD = "file:///D:\\1_Workspaces\\github\\my_examples\\src\\test\\resources\\xsd_dtd\\shiporder.xsd";
    final String xPathToElement = "/shiporder/shipto/name";

    final String xPathToArrayOfElements = "/shiporder/item";
    final int numOfItems = 2;

    @Test
    public void main() throws Exception {
        final String[] args = {pathToXml, pathToXSD, xPathToElement};
        XmlChecker.main(args);
    }

    @Test
    public void test() {
        try {
            final int byExpression = findByExpression(pathToXml, xPathToArrayOfElements);
            assertTrue(byExpression == numOfItems);
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }

}