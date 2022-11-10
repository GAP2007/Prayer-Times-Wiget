package com.gap.widgets3.UIElements;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MainPanel extends VBox{
    Clock clock;
    PrayerTime[] prayers;
    MainPanel(String Color){
        setStyle("-fx-padding: 10px;-fx-background-size: 1200 900;-fx-background-color: rgba(100, 100, 100, 0);-fx-background-radius: 18;-fx-border-radius: 0 0 18 18;");
        setFillWidth(true);

        clock = new Clock();

        prayers = new PrayerTime[5];
        prayers[0] = new PrayerTime("Fajr", "fajar-tile");
        prayers[1] = new PrayerTime("Duhur", "dhuhar-tile");
        prayers[2] = new PrayerTime("Asr", "asr-tile");
        prayers[3] = new PrayerTime("Maghrib", "maghrib-tile");
        prayers[4] = new PrayerTime("Isha","isha-tile");
        
        setMinWidth(300);
        getChildren().add(clock);
        for (PrayerTime p : prayers) {
            this.getChildren().add(p);
            setVgrow(p, Priority.ALWAYS);
        }
    }
}
