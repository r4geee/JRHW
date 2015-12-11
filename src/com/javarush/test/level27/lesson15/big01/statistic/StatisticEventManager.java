package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alexei on 26.07.2015.
 */
public class StatisticEventManager {
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticEventManager getInstance() {
        return ourInstance;
    }

    private StatisticEventManager() {
    }

    public void register(EventDataRow data) {
        if (data != null)
            statisticStorage.put(data);
    }

    public Map<Date, Long> getAdvertisementProfit() {
        Map<Date, Long> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.getMap().get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        for (EventDataRow eventDataRow : list) {
            try {
                Date date = simpleDateFormat.parse(simpleDateFormat.format(eventDataRow.getDate()));
                if (result.containsKey(date)) {
                    result.put(date, result.get(date) + ((VideoSelectedEventDataRow) eventDataRow).getAmount());
                } else {
                    result.put(date, ((VideoSelectedEventDataRow) eventDataRow).getAmount());
                }
            }
            catch (ParseException e) {

            }
        }
        return result;
    }

    public Map<Date, Map<String, Integer>> getCookWorkLoading() {
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.getMap().get(EventType.COOKED_ORDER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        for (EventDataRow eventDataRow : list) {
            try {
                Date date = simpleDateFormat.parse(simpleDateFormat.format(eventDataRow.getDate()));
                String cookName = ((CookedOrderEventDataRow) eventDataRow).getCookName();
                int cookingTimeSeconds = ((CookedOrderEventDataRow) eventDataRow).getCookingTimeSeconds();
                if (result.containsKey(date)) {
                    Map<String, Integer> dayMap = result.get(date);
                    if (dayMap.containsKey(cookName)) {
                        dayMap.put(cookName, dayMap.get(cookName) + cookingTimeSeconds);
                    } else {
                        dayMap.put(cookName, cookingTimeSeconds);
                    }
                } else {
                    Map<String, Integer> newMap = new TreeMap<>();
                    newMap.put(cookName, cookingTimeSeconds);
                    result.put(date, newMap);
                }
            }
            catch (ParseException e) {

            }
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> map;

        private StatisticStorage() {
            map = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                map.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private Map<EventType, List<EventDataRow>> getMap() {
            return map;
        }

        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }
    }
}
