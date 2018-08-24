package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class view_fin extends AppCompatActivity {

    Button homepa, nextpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_financial);

        nextpa = findViewById(R.id.fin_c);
        homepa = findViewById(R.id.hom);

        nextpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_fin.this, financial_cal.class);
                startActivity(intent);
            }
        });

        homepa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_fin.this, home_page.class);
                startActivity(intent);
            }
        });
    }
}

