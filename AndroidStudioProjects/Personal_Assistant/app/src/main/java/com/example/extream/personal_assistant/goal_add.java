package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class goal_add extends AppCompatActivity {

    Button addGoals, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_goals);


        addGoals = findViewById(R.id.include);


        home = findViewById(R.id.fin);

        addGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(goal_add.this, view_goals.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(goal_add.this, home_page.class);
                startActivity(intent);
            }
        });

    }
}
