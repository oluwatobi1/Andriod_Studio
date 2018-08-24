package com.example.extream.personal_assistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {
    public static final String REGISTER_DB = "Register.db";
    public static final String REGISTER_TABLE = "Register_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "password";
    public static final String COL_5 = "confirm_password";


    public sqlite(Context context) {
        super(context, REGISTER_DB, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + REGISTER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Email TEXT, Password TEXT, Confirm_Password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REGISTER_TABLE );
        onCreate(db);


    }
    public boolean insertData(String name, String email, String password, String confirm_password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registerdata = new ContentValues();
        registerdata.put(COL_2, name);
        registerdata.put(COL_3, email);
        registerdata.put(COL_4, password);
        registerdata.put(COL_5, confirm_password);
        long result = db.insert(REGISTER_TABLE, null, registerdata);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getallData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("select * from "+ REGISTER_TABLE,null);
        return res;
    };
    public boolean updateData(String id, String name, String email, String password, String confirm_password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registerdata = new ContentValues();
        registerdata.put(COL_1, id);
        registerdata.put(COL_2, name);
        registerdata.put(COL_3, email);
        registerdata.put(COL_4, password);
        registerdata.put(COL_5, confirm_password);
        db.update(REGISTER_TABLE, registerdata, "ID = ?", new String[]{id});
        return true;
    };
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(REGISTER_TABLE, "ID = ?", new String[]{id});
    };
    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("select * from "+ COL_2,null);
        return res;
    };
}
