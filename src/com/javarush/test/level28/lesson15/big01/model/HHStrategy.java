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
 * Created by Test on 4/29/2015.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int pageNum = 0;
        Document doc = null;
        while (true) {
            try {
                doc = getDocument(searchString, pageNum);
            }
            catch (IOException e) {

            }
            Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
            if (elements.size() > 0) {
                for (Element element : elements) {
                    String title = element.select("[data-qa=vacancy-serp__vacancy-title]").text();
                    String salary = "";
                    Elements salaryElements = element.select("[class=b-vacancy-list-salary]");
                    if (salaryElements.size() > 0) {
                        salary = salaryElements.select("[class=b-vacancy-list-salary]").text();
                    }
                    String city = element.select("[class=searchresult__address]").text();
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").text();
                    String siteName = doc.baseUri();
                    String vacUrl = element.select("[data-qa=vacancy-serp__vacancy-title]").attr("href");
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
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36")
                .referrer("http://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .get();
        return document;
    }
}
