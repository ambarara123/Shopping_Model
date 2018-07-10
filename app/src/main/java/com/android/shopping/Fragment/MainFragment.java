package com.android.shopping.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CircularProgressDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.shopping.MyDialogueFragment;
import com.android.shopping.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends Fragment {

    @BindView(R.id.emailEdit)
    EditText emailEditText;
    @BindView(R.id.passEdit)
    EditText passWOrdEditText;
    @BindView(R.id.signInButton)
    Button signButton;
    DialogFragment dialogFragment;

    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //binding views with butterknife
        ButterKnife.bind(this, view);

        fragmentManager = getFragmentManager();

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                final DialogFragment dialogFragment = new MyDialogueFragment();
                dialogFragment.show(ft, "dialog");

                //delaying for 3 second
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentManager.beginTransaction()
                                .replace(R.id.detail_fragment, new MainScreenFragment(), "mainscreen")
                                .commit();

                        dialogFragment.dismiss();
                    }
                }, 3000);
            }
        });

        return view;
    }
}
