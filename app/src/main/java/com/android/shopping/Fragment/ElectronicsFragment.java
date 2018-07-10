package com.android.shopping.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.shopping.R;
import com.android.shopping.adapter.RecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElectronicsFragment extends Fragment {

    @BindView(R.id.itemRecyclerElectronics)
    RecyclerView recyclerView;

    RecyclerAdapter adapter;

    public static ArrayList<String> list;


    public ElectronicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_electronics, container, false);

        ButterKnife.bind(this,view);

        list = new ArrayList<>();
        list.add("Laptop");
        list.add("Mobile");
        list.add("Television");
        list.add("Camera");
        list.add("Tablets");
        list.add("Smartwatch");
        list.add("Printer");
        list.add("Desktop PC");

        adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
