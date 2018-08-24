package com.example.extream.personal_assistant;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    Button showdata, updatedata, removedata;
    EditText textedit, editname, email, password, confirmpassword;
    sqlite mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        showdata = findViewById(R.id.showdata);
        updatedata = findViewById(R.id.editdata);

        textedit = findViewById(R.id.edittext);
        editname = findViewById(R.id.editname);
        email = findViewById(R.id.editemail);
        password = findViewById(R.id.editpassword);
        confirmpassword = findViewById(R.id.editconfirmpassword);

        removedata = findViewById(R.id.deletedata);
        mydb = new sqlite(this);
        viewall();
        updatedata();
        deldata();
    }
    public void viewall(){

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getallData();
                if (res.getCount()==0){
                    message("Error","Nothing Found");
                    return;
                }
                StringBuffer messageone = new StringBuffer();
                while (res.moveToNext()){
                    messageone.append("ID :"+ res.getString(0)+"\n");
                    messageone.append("Name : "+ res.getString(1)+"\n");
                    messageone.append("Email : "+ res.getString(2)+ "\n");
                    messageone.append("Password : " + res.getString(3)+ "\n");
                    messageone.append("Confirmed Password : "+ res.getString(4)+ "\n\n");
                }
                message("Data", messageone.toString() );
            }
        });
    };
    public void message(String title, String message){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setCancelable(true);
        build.setTitle(title);
        build.setMessage(message);
        build.show();
    };
    public void updatedata(){
        updatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdate = mydb.updateData(textedit.getText().toString(),editname.getText().toString(), email.getText().toString(),password.getText().toString(),confirmpassword.getText().toString());
                if (isupdate = true)
                    Toast.makeText(AdminPage.this, "Data is updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AdminPage.this, "Data Not Updated", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void deldata(){
        removedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedrows = mydb.deleteData(textedit.getText().toString());
                if (deletedrows > 0)
                    Toast.makeText(AdminPage.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AdminPage.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });

    };

}
