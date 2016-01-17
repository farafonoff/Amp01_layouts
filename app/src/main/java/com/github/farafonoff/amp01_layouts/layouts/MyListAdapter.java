package com.github.farafonoff.amp01_layouts.layouts;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
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
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.valueAt(position);
    }

    @Override
    public long getItemId(int position) {
        return dataset.keyAt(position);
    }

    public void removeAll(SparseBooleanArray checks) {
        for(int i=checks.size()-1;i>=0;--i) {
            if (checks.valueAt(i)) {
                int removePosition = checks.keyAt(i);
                dataset.remove(dataset.keyAt(removePosition));
            }
        }
        checks.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder {
        CheckedTextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder vh;
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, null);
            vh = new ViewHolder();
            vh.textView = (CheckedTextView)view;
            view.setTag(vh);
        } else {
            vh = (ViewHolder)view.getTag();
        }
        vh.textView.setText(getItem(position).toString());
        return view;
    }

    public void add(String value) {
        dataset.append(nextKey, value);
        ++nextKey;
        notifyDataSetChanged();
    }
}
