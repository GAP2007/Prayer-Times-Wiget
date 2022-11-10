package com.gap.widgets3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class MainApp extends Application{
    public static boolean isAlive;
    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        isAlive = true;
        new Engine();
        Engine.Start();
        s.initStyle(StageStyle.UNDECORATED);
        s.initStyle(StageStyle.TRANSPARENT);
        s.setScene(Engine.s);
        s.show();
        s.setOnCloseRequest(closeEvent ->{
            isAlive = false;
        });
    }
    public static void main(String[] args) {
        launch(args);
    }

}
