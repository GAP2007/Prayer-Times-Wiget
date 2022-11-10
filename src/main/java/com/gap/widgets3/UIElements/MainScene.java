package com.gap.widgets3.UIElements;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * MainScene
 */
public class MainScene extends Scene{
    
    static public MainPanel p = new MainPanel("red");
    
    public MainScene(){
        super(p);
        setFill(Color.TRANSPARENT);
    }
}
