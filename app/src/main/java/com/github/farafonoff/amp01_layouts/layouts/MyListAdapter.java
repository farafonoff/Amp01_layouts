package com.github.farafonoff.amp01_layouts.layouts;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Artem_Farafonov on 11/10/2015.
 */
public class MyListAdapter extends BaseAdapter {
    SparseArray<String> dataset = new SparseArray<>();
    int nextKey = 0;

    @Override
    public int getCount() {
        return 0;
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
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null) {
            view = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, parent);
        }
        TextView tv = (TextView)view;
        tv.setText(dataset.get(position, ""));
        return tv;
    }

    public void add(String value) {
        dataset.append(nextKey, value);
        ++nextKey;
    }
}
