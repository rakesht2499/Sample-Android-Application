package com.example.admin.sampleapplication;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag1 extends ListFragment {


    public frag1() {
        // Required empty public constructor
    }


    IndexList activity;

    public interface IndexList{
        void getIndex(int index);
    }



    String [] arrayList;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayList = getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (IndexList) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.getIndex(position);
    }
}
