package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, final String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
        String result = writer.toString();

        String fake = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss version=\"2.0\">\n" +
                "\t<channel>\n" +
                "\t\t<title>Java Tutorials and Examples</title>\n" +
                "\t\t<item>\n" +
                "\t\t\t<title><![CDATA[Java Tutorials]]></title>\n" +
                "\t\t\t<link>http://www.javacodegeeks.com/</link>\n" +
                "\t\t</item>\n" +
                "\t</channel>\n" +
                "</rss>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(result.getBytes()));
        try {
            prettyPrint(doc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Element element = doc.getDocumentElement();
        Comment com = doc.createComment(comment);
        element.getParentNode().insertBefore(com, element);

        try {
            prettyPrint(doc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;


    }
    public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }

    /*public static String toXmlWithComment(Object obj, String tagName, final String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
        String result = writer.toString();

        //заменить yes на no и добавить комменты
        result = result.replaceAll("standalone=\"yes\"", "standalone=\"no\"");
        String formattedRegex = String.format("<%1$s>.*</%1$s>|<%1$s/>", tagName);
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile(formattedRegex);
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "<!--" + comment + "-->" + "\n\t" + matcher.group());
        }
        matcher.appendTail(stringBuffer);
        result = stringBuffer.toString();

        //заменить пустые теги
        String emptyTagRegex = "<[^/][^>]*></[^>]*>";
        pattern = Pattern.compile(emptyTagRegex);
        matcher = pattern.matcher(result);
        while (matcher.find()) {
            String tag = matcher.group().substring(matcher.group().lastIndexOf("/") + 1, matcher.group().length() - 1);
            result = result.replace(matcher.group(), "<" + tag + "/>");
        }
        //заменить &lt &amp &gt
        String tagContentRegex = "(?<=>).*(?=</[^>]*>)";
        pattern = Pattern.compile(tagContentRegex);
        matcher = pattern.matcher(result);
        while (matcher.find()) {
            if (matcher.group().contains("&lt;") || matcher.group().contains("&amp;") || matcher.group().contains("&gt;") || matcher.group().contains("&quot;") || matcher.group().contains("&apos;") || matcher.group().contains("]]")) {
                String replacement = matcher.group()
                        .replaceAll("&lt;", "<")
                        .replaceAll("&amp;", "&")
                        .replaceAll("&gt;", ">")
                        .replaceAll("]]", "]]]]><![CDATA[>")
                        .replaceAll("&quot;", "\"")
                        .replaceAll("&apos;", "\'");
                replacement = "<![CDATA[" + replacement + "]]>";
                result = result.replace(matcher.group(), replacement);
            }
        }
        return result;
    }*/


}
