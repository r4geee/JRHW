package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;


/**
 * Created by Test on 4/24/2015.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        boolean noVideosShown = true;
        List<Advertisement> listToShow;
        if (storage.list().size() > 0) {
            List<List<Advertisement>> listOfLists = new ArrayList<>();
            getAllCombinationsList(new ArrayList<Advertisement>(), 0, listOfLists);
            for (Iterator<List<Advertisement>> iterator = listOfLists.iterator(); iterator.hasNext(); ) {
                List<Advertisement> list = iterator.next();
                int listDuration = 0;
                for (Iterator<Advertisement> listIterator = list.iterator(); listIterator.hasNext(); ) {
                    Advertisement advertisement = listIterator.next();
                    if (advertisement.getHits() < 1) {
                        listIterator.remove();
                    } else {
                        listDuration += advertisement.getDuration();
                    }
                }
                if (listDuration > timeSeconds || listDuration == 0) {
                    iterator.remove();
                }
            }
            if (listOfLists.size() == 0) {
                StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
                throw new NoVideoAvailableException();
            }

            Collections.sort(listOfLists, new Comparator<List<Advertisement>>() {
                @Override
                public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                    long cost1 = 0;
                    int totalTime1 = 0;
                    for (Advertisement advertisement : o1) {
                        cost1 += advertisement.getAmountPerOneDisplaying();
                        totalTime1 += advertisement.getDuration();
                    }
                    long cost2 = 0;
                    int totalTime2 = 0;
                    for (Advertisement advertisement : o2) {
                        cost2 += advertisement.getAmountPerOneDisplaying();
                        totalTime2 += advertisement.getDuration();
                    }
                    if (cost1 != cost2) {
                        return Long.compare(cost2, cost1);
                    }
                    if (totalTime1 != totalTime2) {
                        return totalTime2 - totalTime1;
                    } else {
                        return o1.size() - o2.size();
                    }
                }
            });
            listToShow = listOfLists.get(0);
        } else {
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }
        Collections.sort(listToShow, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying() != 0) {
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                } else {
                    return Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
            }
        });

        long amount = 0;
        int totalDuration = 0;
        for (Advertisement advertisement : listToShow) {
            amount += advertisement.getAmountPerOneDisplaying();
            totalDuration += advertisement.getDuration();
        }
        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(listToShow, amount, totalDuration));

        for (Advertisement advertisement : listToShow) {
            noVideosShown = false;
            System.out.println(String.format("%s is displaying... %d, %d", advertisement.getName(), advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying() * 1000 / (long) advertisement.getDuration()));
            timeSeconds -= advertisement.getDuration();
            advertisement.revalidate();
        }
        if (noVideosShown) {
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }
    }

    private void getAllCombinationsList(List<Advertisement> list, int index, List<List<Advertisement>> listOfLists) {
        List<Advertisement> listWith = new ArrayList<>(list);
        List<Advertisement> listWithOut = new ArrayList<>(list);
        listWith.add(storage.list().get(index));
        if (index == storage.list().size() - 1) {
            listOfLists.add(listWith);
            listOfLists.add(listWithOut);
        } else {
            getAllCombinationsList(listWith, index + 1, listOfLists);
            getAllCombinationsList(listWithOut, index + 1, listOfLists);
        }
    }

}
