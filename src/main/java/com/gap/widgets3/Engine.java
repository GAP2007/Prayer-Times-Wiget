package com.gap.widgets3;

import java.io.IOException;

import com.gap.widgets3.UIElements.MainScene;

public class Engine{
    static MainScene s;
    public static void Start() throws IOException{
        s = new MainScene();
    }
}
