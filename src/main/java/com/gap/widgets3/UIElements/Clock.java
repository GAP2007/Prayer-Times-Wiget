package com.gap.widgets3.UIElements;

import java.time.LocalDateTime;

import com.gap.widgets3.MainApp;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//TODO: Make it Look good

public class Clock extends BorderPane implements Runnable{
    int updateRatio = 1000; //in mSec
    Text txtClock = new Text("00:00");
    
    
    Clock(){
        Thread t = new Thread(this);
        t.start();
        txtClock.setFont(new Font(40));
        //ReformatUpdate();
        
        
        this.setCenter(txtClock);
    }
    //Reformat and Update The Clock's Text
    private void ReformatUpdate(){
        String strTimeH = "";
        String strTimeM = "";
        String PmORAm;
        int TimeH = LocalDateTime.now().getHour();
        int TimeM = LocalDateTime.now().getMinute();
        //Checks if it's pm
        if(TimeH > 12){
            TimeH -= 12;
            PmORAm = "PM";
        }
        else{
            PmORAm = "AM";
        }
        if (TimeH < 10){
            strTimeH = "0" + TimeH;
        }
        if (TimeM < 10){
            strTimeM = "0" + TimeM;
        }
        else{
            strTimeM = ""+TimeM;
        }
        this.txtClock.setText(strTimeH +":"+strTimeM+" "+PmORAm);
    }
    //Mannages Updates to Keep The Clock Up to date
    @Override
    public void run() {
        while (MainApp.isAlive) {
            try {
                ReformatUpdate();
                System.out.println("Clock Updated");
                Thread.sleep(updateRatio);
            } catch (InterruptedException e) {
                System.out.println("Problem in class Clock in The run Method: Thread.sleep(1000); Faild");
            }
        }        
    }

}
