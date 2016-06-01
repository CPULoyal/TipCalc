package com.loyalium.cpuloyal.tipcalc;

import android.app.Application;

/**
 * Created by blamagroth on 31/05/16.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://about.me/rlealy";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
