package com.github.farafonoff.amp01_layouts.layouts;

import android.support.v4.app.Fragment;

import com.github.farafonoff.amp01_layouts.LayoutDetailFragment;

/**
 * Created by Artem_Farafonov on 10/27/2015.
 */
public class LayoutItemsList {
    public static String[] layoutNames = new String[]{"linear", "grid", "frame", "absolute", "table", "grid_view", "viewpager"};
    public static String getLocaleForLayout(String layout) {
        if (layout.equals(layoutNames[0])) {
            return "ru";
        }
        if (layout.equals(layoutNames[1])) {
            return "en";
        }
        return "";
    }
}
