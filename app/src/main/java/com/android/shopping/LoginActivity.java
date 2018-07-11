package com.android.shopping;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.shopping.Fragment.MainScreenFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.emailEdit1)
    EditText emailEditText;
    @BindView(R.id.passEdit)
    EditText passWOrdEditText;
    @BindView(R.id.signInButton)
    Button signButton;
    @BindView(R.id.checkboxPass)
    CheckBox checkbox;
    DialogFragment dialogFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //binding views with butterknife
        ButterKnife.bind(this);
        showHidePass();

        fragmentManager = getSupportFragmentManager();

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                checkValidation();

            }
        });

    }

    public void showHidePass() {
        checkbox
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton button,
                                                 boolean isChecked) {


                        if (isChecked) {

                            checkbox.setText("hide Password");


                            passWOrdEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                            passWOrdEditText.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());
                        } else {
                            checkbox.setText("Show password");

                            passWOrdEditText.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            passWOrdEditText.setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());

                        }

                    }
                });
    }


    // Check Validation before login
    private void checkValidation() {
        // Get email id and password
        String getEmailId = emailEditText.getText().toString().trim();
        String getPassword = passWOrdEditText.getText().toString().trim();


        //Email Validation pattern
        final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

        // Check patter for email id
        Pattern p = Pattern.compile(regEx);

        Matcher m = p.matcher(getEmailId);

        // Check for both field is empty or not
        if (getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0) {

            Toast.makeText(this, "enter both credentials", Toast.LENGTH_SHORT).show();

        }
        // Check if email id is valid or not
        else if (!m.find()) {
            Toast.makeText(this, "your Email id is invalid", Toast.LENGTH_SHORT).show();
        }

        else {

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

    }
}


