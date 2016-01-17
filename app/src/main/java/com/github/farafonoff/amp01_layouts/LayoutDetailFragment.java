package com.github.farafonoff.amp01_layouts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.farafonoff.amp01_layouts.layouts.GridViewAdapter;
import com.github.farafonoff.amp01_layouts.layouts.LayoutItemsList;
import com.github.farafonoff.amp01_layouts.layouts.MyListAdapter;

import java.util.Arrays;


/**
 * A fragment representing a single Layout detail screen.
 * This fragment is either contained in a {@link LayoutListActivity}
 * in two-pane mode (on tablets) or a {@link LayoutDetailActivity}
 * on handsets.
 */
public class LayoutDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private String mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LayoutDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = getArguments().getString(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layoutId = R.layout.fragment_layout_detail;

        switch(mItem) {
            case "linear":
                layoutId = R.layout.fragment_layout_linear;
                break;
            case "grid":
                layoutId = R.layout.fragment_layout_grid;
                break;
            case "frame":
                layoutId = R.layout.fragment_layout_frame;
                break;
            case "absolute":
                layoutId = R.layout.fragment_layout_absolute;
                break;
            case "table":
                layoutId = R.layout.fragment_layout_table;
                break;
            case "grid_view":
                layoutId = R.layout.fragment_layout_grid_view;
                break;
        }

        View rootView = inflater.inflate(layoutId, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            TextView layoutNameTv = ((TextView) rootView.findViewById(R.id.layout_detail));
            if (layoutNameTv!=null) {
                layoutNameTv.setText(mItem);
            }
        }

        if (layoutId==R.layout.fragment_layout_linear) {
            final ListView view = ((ListView) rootView.findViewById(R.id.listView));
            view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            Button addItemButton = ((Button) rootView.findViewById(R.id.insertButton));
            final EditText text = ((EditText) rootView.findViewById(R.id.newItemName));
            Button deleteAllButton = ((Button) rootView.findViewById(R.id.deleteButton));
            final MyListAdapter myAdapter = new MyListAdapter();
            myAdapter.add("test");
            myAdapter.add("test1");
            view.setAdapter(myAdapter);
            addItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newTextItem = text.getText().toString();
                    if (!newTextItem.isEmpty()) {
                        myAdapter.add(newTextItem);
                    }
                }
            });
            deleteAllButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SparseBooleanArray checks = view.getCheckedItemPositions();
                    myAdapter.removeAll(checks);
                }
            });
        }

        if (layoutId==R.layout.fragment_layout_grid_view) {
            GridView view = ((GridView) rootView.findViewById(R.id.layout_grid_view));
            view.setAdapter(new GridViewAdapter());
        }

        if (layoutId==R.layout.fragment_layout_frame) {
            ViewPager view = ((ViewPager) rootView.findViewById(R.id.viewPager));
            view.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
                @Override
                public int getCount() {
                    return LayoutItemsList.layoutNames.length;
                }

                @Override
                public Fragment getItem(int position) {
                    Bundle arguments = new Bundle();
                    arguments.putString(LayoutDetailFragment.ARG_ITEM_ID, LayoutItemsList.layoutNames[position]);
                    LayoutDetailFragment fragment = new LayoutDetailFragment();
                    fragment.setArguments(arguments);
                    return fragment;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return LayoutItemsList.layoutNames[position];
                }
            });
        }

        return rootView;
    }
}
