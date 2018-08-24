package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class view_goals extends AppCompatActivity {

    Button viewGoals, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_goals);

        viewGoals = findViewById(R.id.button_reg);

        home = findViewById(R.id.sche);

        //schedule = findViewById(R.id.);

        viewGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_goals.this, goal_add.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_goals.this, home_page.class);

                startActivity(intent);
            }
        });



    }
}
