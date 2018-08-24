package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class adminlock extends AppCompatActivity {
    Button adminbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlock);
        adminbutton = findViewById(R.id.adminsigninbuttom);
        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(adminlock.this, AdminPage.class);
                startActivity(intent);
            }
        });
    }
}
