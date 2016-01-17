package com.github.farafonoff.amp01_layouts.layouts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Artem_Farafonov on 11/8/2015.
 */
@Deprecated
public class GridViewAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView==null) {
            textView = new TextView(parent.getContext());
            textView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        else {
            textView = (TextView) convertView;
        }
        textView.setText(String.valueOf(position));
        return textView;
    }
}
