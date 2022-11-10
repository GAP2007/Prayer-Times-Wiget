package com.gap.widgets3.UIElements;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gap.widgets3.MainApp;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PrayerTime extends BorderPane implements Runnable{
    static Document Doc;
    Font font = new Font(30);
    Text prayerName;
    Text prayerTime;
    public String Class;
    
    PrayerTime(String prayerName, String Class){
        this.Class = Class;
        Thread t = new Thread(this);
        t.start();
        this.prayerName = new Text(prayerName);
        this.prayerTime = new Text("00:00 RM");
        this.prayerName.setFont(font);
        this.prayerTime.setFont(font);
        this.setLeft(this.prayerName);
        this.setRight(this.prayerTime);
    }
    @Override
    public void run() {
        while(MainApp.isAlive){
            try {
                Doc = Jsoup.connect("https://www.islamicfinder.org/world/egypt/360630/cairo-prayer-times/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            prayerTime.setText(Doc.getElementsByClass(Class).get(0).getElementsByClass("prayertime").text());
            System.out.println("Prayer "+ Class +" Updated");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Problem in the task in prayerTime Class");
            }
        }
    }
}
