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
public class SportsFragment extends Fragment {

    @BindView(R.id.itemRecyclerSport)
    RecyclerView recyclerView;

    RecyclerAdapter adapter;

    public static ArrayList<String> list;


    public SportsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports, container, false);

        ButterKnife.bind(this,view);

        list = new ArrayList<>();
        list.add("Cricket Bat");
        list.add("CricketBall");
        list.add("Football");
        list.add("Volleyball");
        list.add("Basketball");
        list.add("Hockey");

        adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
