package com.android.shopping.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainScreenFragment extends Fragment {
    @BindView(R.id.fashionCard)
    CardView fashionCardView;
    @BindView(R.id.electronicsCard)
    CardView electronicsCard;
    @BindView(R.id.homeCard)
    CardView homeCard;
    @BindView(R.id.sportsCard)
    CardView sportsCard;

    FragmentManager fragmentManager;

    public MainScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        ButterKnife.bind(this,view);

        fragmentManager = getFragmentManager();
        cardClickListeners();

        return view;
    }


    public void cardClickListeners(){
        fashionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.detail_fragment, new FashionFragment(), "fashion")
                        .addToBackStack("fashion")
                        .commit();
            }
        });

        electronicsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .add(R.id.detail_fragment, new ElectronicsFragment(),"electronics")
                        .addToBackStack("electronics")
                        .commit();
            }
        });

        homeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .add(R.id.detail_fragment, new HomeFragment(), "home")
                        .addToBackStack("home")
                        .commit();
            }
        });

        sportsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .add(R.id.detail_fragment,new SportsFragment(), "sports")
                        .addToBackStack("sports")
                        .commit();
            }
        });


    }

}
