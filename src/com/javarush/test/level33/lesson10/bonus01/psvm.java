package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Test on 11.08.2015.
 */
public class psvm {
    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};

        public String lolka = "<ho & ' \" hoho>";
        public String escheRaz = "<needCDATA>";
        public String fig = "";
        public String norm = "ok";
    }

    public static void main(String[] args) throws JAXBException {
        String result = Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>");
        System.out.println(result);
    }

    /*    public static void main(String[] args) throws JAXBException {

        First first = new First();
        first.second.add("some string");
        first.second.add("some string");
        first.second.add("1");
        first.second.add("<![CDATA[need CDATA <second>lalka</second>because of < and >]]>");

        System.out.println(toXmlWithComment(first, "second", "it's a comment"));
    }

    @XmlRootElement
    @XmlType(name = "first")
    public static class First {

        public List<String> second = new ArrayList<>();
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
    }*/
}
