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
public class FashionFragment extends Fragment {
    @BindView(R.id.itemRecycler)
    RecyclerView recyclerView;

    RecyclerAdapter adapter;

    public static ArrayList<String> list;



    public FashionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fashion, container, false);
        ButterKnife.bind(this,view);
        getActivity().setTitle("Fashion");

        list = new ArrayList<>();
        list.add("Clothing");
        list.add("Watches");
        list.add("Eyewear");
        list.add("Footwear");
        list.add("Toy");
        list.add("Fragrances");
        list.add("Handbags");

        adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
