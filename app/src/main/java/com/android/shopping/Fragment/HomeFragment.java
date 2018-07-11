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
public class HomeFragment extends Fragment {


    @BindView(R.id.itemRecyclerhome)
    RecyclerView recyclerView;

    RecyclerAdapter adapter;

    public static ArrayList<String> list;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this,view);

        getActivity().setTitle("Home and Furnitues");

        list = new ArrayList<>();
        list.add("Beds");
        list.add("Matress");
        list.add("Wardrobes");
        list.add("Dressing Table");
        list.add("Study Table");
        list.add("Kitchen Tools");
        list.add("Coffee Mugs");

        adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
