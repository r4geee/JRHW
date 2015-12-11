package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Test on 4/24/2015.
 */
class AdvertisementStorage {
    private static AdvertisementStorage instance;

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));

        add(new Advertisement(someContent, "четрвертый видос", 5000, 2, 1 * 60));

        add(new Advertisement(someContent, "fifth Video", 400, 1, 12002 * 60));
        add(new Advertisement(someContent, "third Video", 41114, 3, 10 * 60));
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
