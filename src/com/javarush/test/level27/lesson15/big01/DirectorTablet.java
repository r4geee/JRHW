package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Test on 27.07.2015.
 */
public class DirectorTablet {
    public void printAdvertisementProfit() {
        Map<Date, Long> map = StatisticEventManager.getInstance().getAdvertisementProfit();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double total = 0;
        for (Map.Entry<Date, Long> entry : map.entrySet()) {
            double initialAmountInRubs = (double) entry.getValue() / 100;
            BigDecimal roundedResult = new BigDecimal(initialAmountInRubs).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println(dateFormat.format(entry.getKey()) + " - " + roundedResult);
            total += roundedResult.doubleValue();
        }
        System.out.println("Total - " + new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> map = StatisticEventManager.getInstance().getCookWorkLoading();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(dateFormat.format(entry.getKey()));
            for (Map.Entry<String, Integer> dayEntry : entry.getValue().entrySet()) {
                double cookingTimeMinutes = (double) dayEntry.getValue() / 60;
                int roundedResult = new BigDecimal(cookingTimeMinutes).setScale(0, RoundingMode.UP).intValue();
                System.out.println(dayEntry.getKey() + " - " + roundedResult + " min");
            }
            System.out.println();
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideos = StatisticAdvertisementManager.getInstance().getActiveVideoSet();
        for (Advertisement advertisement : activeVideos) {
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> archivedVideos = StatisticAdvertisementManager.getInstance().getArchivedVideoSet();
        for (Advertisement advertisement : archivedVideos) {
            System.out.println(advertisement.getName());
        }
    }
}
