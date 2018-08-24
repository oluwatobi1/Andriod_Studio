package com.example.extream.personal_assistant;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.extream.personal_assistant.sqlite.COL_2;

public class Login extends AppCompatActivity {
    TextView admin;
    ImageView temporal_logo;
    EditText username, password;
    RelativeLayout loginlayout, signUp, generalLoginRelativeLayout;
    AnimationDrawable animated_background;
    Button logibbt;



    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loginlayout.setVisibility(View.VISIBLE);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        signUp = findViewById(R.id.sign);
        admin = findViewById(R.id.admintextview);
        temporal_logo = findViewById(R.id.logintemp_logo);
        loginlayout = findViewById(R.id.login_relativelayout);
        generalLoginRelativeLayout = findViewById(R.id.pglogin_generalRelativeLayout);
        animated_background = (AnimationDrawable) generalLoginRelativeLayout.getBackground();
        logibbt = findViewById(R.id.login1);




        //*to get the users data and authenticate it*/
        username = findViewById(R.id.username1);
        password = findViewById(R.id.login_editTextPassword);


        Bitmap templogo = BitmapFactory.decodeResource(getResources(), R.drawable.splash);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), templogo);
        roundedBitmapDrawable.setCircular(true);
        temporal_logo.setImageDrawable(roundedBitmapDrawable);
        handler.postDelayed(runnable, 2000);



        animated_background.setEnterFadeDuration(1000);
        animated_background.setExitFadeDuration(1000);
        animated_background.start();


        logibbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String abc = username.getText().toString();
                String pas = password.getText().toString();

                if (abc.isEmpty()){
                    Toast.makeText(Login.this, "Enter Details", Toast.LENGTH_SHORT).show();
                }
                else if (COL_2.equalsIgnoreCase(abc)){
                    Intent login = new Intent(Login.this, home_page.class);
                    startActivity(login);
                }
                else
                    Toast.makeText(Login.this, "Please Register", Toast.LENGTH_SHORT).show();



            }
        });

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, adminlock.class);
                startActivity(intent);
            }
        });
    }


}

