package com.example.sqliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database( Context context) {
        super(context, "studentDb.db", null, 1);
        this.context = context;
    }
    Context context;

    @Override
    public void onCreate(SQLiteDatabase DB) {
     DB.execSQL("create table studentInfo(name Text PRIMARY KEY , age INTEGER , collage TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
     DB.execSQL("drop table if exists studentInfo");
    }


    public boolean insertData(String name, int age , String collage){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("age" , age);
        values.put("collage" , collage);
        long result = DB.insert("studentInfo" , null, values);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }


    public boolean updateData(String name, int age , String collage){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age" , age);
        values.put("collage" , collage);
        Cursor cursor = DB.rawQuery("select * from studentInfo where name=?" , new String[]{name});
        if(cursor.getCount() > 0){
        long result = DB.update("studentInfo" , values , "name=?", new String []{name});
        if (result == -1){
            return false;
        }else{
            return true;
        }
        }else {
            return false;
        }
    }


    public void deleteAll(){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from studentInfo");
    }


    public Cursor ShowData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor data = DB.rawQuery("select * from studentInfo", null);
        return data;
    }

    public int countData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor data = DB.rawQuery("select * from studentInfo", null);
        return data.getCount();
    }









}
