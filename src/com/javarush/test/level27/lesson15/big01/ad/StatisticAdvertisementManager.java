package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Test on 04.08.2015.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private Comparator<Advertisement> videoComparator = new VideoComparator();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0) {
                result.add(advertisement);
            }
        }
        Collections.sort(result, videoComparator);
        return result;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() == 0) {
                result.add(advertisement);
            }
        }
        Collections.sort(result, videoComparator);
        return result;
    }

    private StatisticAdvertisementManager() {
    }

    private class VideoComparator implements Comparator<Advertisement> {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
}
