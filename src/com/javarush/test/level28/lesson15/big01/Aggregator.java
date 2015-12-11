package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by Test on 4/29/2015.
 */
public class Aggregator {
    public static void main(String[] args) {
/*        HtmlView view = new HtmlView();
        Provider[] providers = new Provider[1];
        providers[0] = new Provider(new MoikrugStrategy());
        Model model = new Model(view, providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();*/
        HtmlView view = new HtmlView();
        Provider[] providers = new Provider[2];
        providers[0] = new Provider(new HHStrategy());
        providers[1] = new Provider(new MoikrugStrategy());
        Model model = new Model(view, providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
