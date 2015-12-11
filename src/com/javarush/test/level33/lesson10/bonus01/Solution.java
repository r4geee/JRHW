package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static String toXmlWithComment(Object obj, String tagName, final String comment) throws JAXBException {
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
    }


}
