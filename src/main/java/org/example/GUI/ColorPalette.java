package org.example.GUI;

import java.awt.*;

public class ColorPalette {
    public static Color backGround = Color.red;
    public static Color foreGround = Color.white;
    public static Color sidePannels = Color.darkGray;
    public static Color bodyPanel = Color.white;
    public static Color formPanel = Color.gray;

    public static Color darkBackGround = new Color(88, 4, 4);
    public static Color darkForeGround = Color.white;
    public static Color darkSidePannels = Color.black;
    public static Color darkBodyPanel = Color.darkGray;
    public static Color darkFormPanel = new Color(117, 117, 117, 255);
    public static Color getFormPanel() {
        return formPanel;
    }

    public static Color getBackGround() {
        return backGround;
    }

    public static Color getBodyPanel() {
        return bodyPanel;
    }

    public static Color getSidePannels() {
        return sidePannels;
    }

    public static Color getForeGround() {
        return foreGround;
    }

}
