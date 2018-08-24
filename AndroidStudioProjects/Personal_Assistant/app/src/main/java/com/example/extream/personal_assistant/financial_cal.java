package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class financial_cal extends AppCompatActivity implements View.OnClickListener {

    private Button homepag, reco;
    /* private EditText firstEditNo, secEditNo; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial);

        homepag = findViewById(R.id.homep);
        reco = findViewById(R.id.finpag);

        homepag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(financial_cal.this, home_page.class);
                startActivity(intent);
            }
        });

        reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(financial_cal.this, view_fin.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View view) {

    }
}

