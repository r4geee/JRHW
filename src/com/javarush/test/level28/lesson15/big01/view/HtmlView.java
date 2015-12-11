package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Alexei on 10.05.2015.
 */
public class HtmlView implements View {
    private final String filePath = "./src/" + this.getClass().getPackage().toString().replace("package ", "").replace(".", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            document.html();
            Element template = document.select("[class=vacancy template]").first();
            Element templateCopy = template.clone();
            templateCopy.removeAttr("style");
            templateCopy.removeAttr("class");
            templateCopy.addClass("vacancy");
            document.select("tr[class=vacancy]").remove();
            for (Vacancy vacancy : vacancies) {
                Element thisVacancyElement = templateCopy.clone();
                thisVacancyElement.select("[class=city]").first().text(vacancy.getCity());
                thisVacancyElement.select("[class=companyName]").first().text(vacancy.getCompanyName());
                thisVacancyElement.select("[class=salary]").first().text(vacancy.getSalary());
                thisVacancyElement.select("[class=title]").select("a[href]").first().text(vacancy.getTitle());
                thisVacancyElement.select("[class=title]").select("a[href]").first().attr("href", vacancy.getUrl());
                document.select("[class=vacancy template]").first().before(thisVacancyElement.outerHtml());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
        return document.html();
    }

    private void updateFile(String s) throws IOException {
        OutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(s.getBytes());
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
