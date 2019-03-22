package com.codesinn.icehockey.helpers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
    private static Preferences prefs = Gdx.app.getPreferences("basic data");

    public static void setLoggedStatus(String status) {
        prefs.putString("loggedStatus", status);
        prefs.flush();
    }

    public static String getLoggedStatus() {
        return prefs.getString("loggedStatus","3");
    }

    public static void setMobileNumber(String mobile) {
        prefs.putString("mobileNumber", mobile);
        prefs.flush();
    }

    public static String getMobileNumebr() {
        return prefs.getString("mobileNumber","3");
    }

    public static void setName(String name) {
       prefs.putString("name", name);
        prefs.flush();
    }

    public static String getName() {
       return prefs.getString("name","00");
    }

}
