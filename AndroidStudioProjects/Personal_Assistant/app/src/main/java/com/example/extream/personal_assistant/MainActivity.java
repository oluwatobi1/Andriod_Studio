package com.example.extream.personal_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button registerbutton, showbutton;
    EditText editname,editmail, editpassword, editconfirmpassword;
    sqlite mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new sqlite(this);
        editname = (EditText) findViewById(R.id.nameInput);
        editmail = (EditText) findViewById(R.id.emailInput);
        editpassword = (EditText) findViewById(R.id.passwordInput);
        editconfirmpassword = (EditText) findViewById(R.id.confirmPasswordInput);
        registerbutton = findViewById(R.id.register);
        //showbutton = findViewById(R.id.showUsers);
        //viewall();
        register();


    }

    public void register() {
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isadd = mydb.insertData(editname.getText().toString(),
                            editmail.getText().toString(),
                            editpassword.getText().toString(),
                            editconfirmpassword.getText().toString());

                if (isadd == true)

                    Toast.makeText(MainActivity.this, " Data Is Inserted", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(MainActivity.this, " Data Not Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, home_page.class);
                startActivity(intent);






            }
        });
    }



    };

    /**public void viewall(){
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getallData();
                if (res.getCount()== 0) {
                    showMessage("Error", "Nothing found");

                    return;
                }
                    StringBuffer showmessage = new StringBuffer();
                while (res.moveToNext()){

                    showmessage.append("ID :"+ res.getString(0)+"\n");
                    showmessage.append("Name : "+ res.getString(1)+"\n");
                    showmessage.append("Email : "+ res.getString(2)+ "\n");
                    showmessage.append("Password : " + res.getString(3)+ "\n");
                    showmessage.append("Confirmed Password : "+ res.getString(4)+ "\n\n");
                }
                showMessage("Data", showmessage.toString() );


            }
        });

    };

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    };



}



*/
