package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Database DB;
    TextView printAll ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        printAll = findViewById(R.id.printAll);
        DB = new Database(this);

        Cursor allData = DB.ShowData();
        while(allData.moveToNext()) {
            String name = allData.getString(0);
            int age = allData.getInt(1);
            String collage = allData.getString(2);
            printAll.append(name + "\n" + age + "\n" + collage + "\n\n");
        }

    }

}