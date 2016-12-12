package tripmark.utils;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import tripmark.Place;
import tripmark.Stories;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Forked from Xynoci.
 */
public class XmlUtils {

    public String buildPlaceXML(String email, Place subscription) {
        String xmlDoc = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Document doc = db.newDocument();
            Element rootElement = doc.createElement("subscription");
            this.addAttribute(doc, rootElement, "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            if (email != null) {
                this.addAttribute(doc, rootElement, "visitedBy", email);
            }
            doc.appendChild(rootElement);

            Element placeNode = doc.createElement("place");
            addChildElement(doc, placeNode, "placeID", subscription.getPlaceId().toString());
            addChildElement(doc, placeNode, "placeName", subscription.getPlaceName());
            addChildElement(doc, placeNode, "placeDetail", subscription.getPlaceDetail());
            addChildElement(doc, placeNode, "introMessage", subscription.getIntroMessage());
            addChildElement(doc, placeNode, "pageView", Integer.toString(subscription.getPageView()));
            addChildElement(doc, placeNode, "visiterCount", Integer.toString(subscription.getVisiterCount()));
            addChildElement(doc, placeNode, "commendSight", subscription.getCommendSight());
            addChildElement(doc, placeNode, "commendHotel", subscription.getCommendHotel());
            addChildElement(doc, placeNode, "temperature", subscription.getTemperature());
            addChildElement(doc, placeNode, "recentComment", subscription.getRecentComment());
            ArrayList<Stories> stories = subscription.getStories();
            // addChildElement(doc, placeNode, "stories", stories);
            stories.forEach(story -> {
                Element storyElement = doc.createElement("story");
                // storyElement.appendElement(doc, placeNode, "recentStoryID", stories.get(0).getStoryID());
                // storyElement.appendElement(doc, placeNode, "recentStoryTitle", stories.get(0).getTitle());
                // storyElement.appendElement(doc, placeNode, "recentStoryEditor", stories.get(0).getEditor());
                // String time = sdf.format(story.getDate());
                // storyElement.appendElement(doc, placeNode, "recentStoryDate", time.substring(0,22)+":"+time.substring(22));
                addChildElement(doc, storyElement, "recentStoryID", story.getStoryID().toString());
                addChildElement(doc, storyElement, "recentStoryTitle", story.getTitle());
                addChildElement(doc, storyElement, "recentStoryEditor", story.getEditor());
                String time = sdf.format(story.getDate());
                addChildElement(doc, storyElement, "recentStoryDate", time.substring(0,22)+":"+time.substring(22));
                placeNode.appendChild(storyElement);
            });
            rootElement.appendChild(placeNode);

            System.out.println("buildXML: rootElement" + rootElement);

            try {
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                StringWriter writer = new StringWriter();
                transformer.transform(new DOMSource(doc), new StreamResult(writer));
                xmlDoc = writer.getBuffer().toString().replaceAll("\n|\r", "");
                xmlDoc = writer.getBuffer().toString();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        try {
            this.validate(xmlDoc, "src/main/Java/tripmark/utils/subscription.xsd");
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return xmlDoc;
    }

    private void addAttribute(Document doc, Element targetElement, String attrName, String attrValue) {
        Attr attr = doc.createAttribute(attrName);
        attr.setValue(attrValue);
        targetElement.setAttributeNode(attr);
    }

    private void addChildElement(Document doc, Element targetElement, String tagName, String tagValue) {
        Element tag = doc.createElement(tagName);
        tag.appendChild(doc.createTextNode(tagValue));
        targetElement.appendChild(tag);
    }

    private boolean validate(String xmlDoc, String schemaPath) throws SAXException {

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(schemaPath));
        Source xmlFile = new StreamSource(new StringReader(xmlDoc));
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();

        try {
            validator.validate(xmlFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
