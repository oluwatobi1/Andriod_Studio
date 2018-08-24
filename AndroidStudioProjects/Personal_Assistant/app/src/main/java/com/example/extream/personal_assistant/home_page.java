package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class home_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        LinearLayout goals = findViewById(R.id.goal2);
        LinearLayout schedu = findViewById(R.id.Schedule);
        LinearLayout finaances = findViewById(R.id.finances);

        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(home_page.this, view_goals.class);

                startActivity(intent1);
            }
        });

        schedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(home_page.this, sche_view.class);

                startActivity(inten);
            }
        });

        finaances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(home_page.this, financial_cal.class);

                startActivity(inte);
            }
        });

    }
}
