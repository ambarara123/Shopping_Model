package com.android.shopping;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.shopping.Fragment.MainScreenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.emailEdit1)
    EditText emailEditText;
    @BindView(R.id.passEdit)
    EditText passWOrdEditText;
    @BindView(R.id.signInButton)
    Button signButton;
    DialogFragment dialogFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //binding views with butterknife
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
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
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                        dialogFragment.dismiss();
                    }
                }, 3000);
            }
        });

    }
}
