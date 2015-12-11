package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexei on 08.12.2015.
 */
public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int pageNum = 1;
        Document doc = null;
        while (true) {
            try {
                doc = getDocument(searchString, pageNum);
            }
            catch (IOException e) {

            }
            Elements elements = doc.getElementsByClass("job");
            if (elements.size() > 0) {
                for (Element element : elements) {
                    String title = element.getElementsByClass("title").text();
                    String salary = element.getElementsByClass("count").text();
                    String city = element.getElementsByClass("location").text();
                    String companyName = element.getElementsByClass("company_name").select("[href]").text();
                    String siteName = doc.baseUri();
                    String vacUrl = element.getElementsByClass("title").select("[href]").attr("abs:href");
                    Vacancy newVacancy = new Vacancy();
                    newVacancy.setTitle(title);
                    newVacancy.setSalary(salary);
                    newVacancy.setCity(city);
                    newVacancy.setCompanyName(companyName);
                    newVacancy.setSiteName(siteName);
                    newVacancy.setUrl(vacUrl);
                    result.add(newVacancy);
                }
                pageNum++;
            } else {
                break;
            }
        }
        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36")
                .referrer("https://moikrug.ru/")
                .get();
        return document;
    }
}
