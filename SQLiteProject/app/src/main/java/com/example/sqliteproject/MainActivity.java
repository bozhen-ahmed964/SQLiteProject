package com.example.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database DB;
    EditText name_input , age_input , collage_input;
    Button insert_btn , update_btn , delete_btn;
    TextView count;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_input = (EditText) findViewById(R.id.name_input);
        age_input = (EditText) findViewById(R.id.age_input);
        collage_input = (EditText) findViewById(R.id.collage_input);

        insert_btn = findViewById(R.id.insert_btn);
        update_btn = findViewById(R.id.update_btn);
        delete_btn = findViewById(R.id.delete_btn);

        count = findViewById(R.id.count);
        DB = new Database(this);


    }

    public void insert(View view) {
    String name = name_input.getText().toString();
    int age = Integer.parseInt(age_input.getText().toString());
    String collage = collage_input.getText().toString();

    boolean result = DB.insertData(name, age, collage);
    if (result) {
        Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
    } else{
        Toast.makeText(this, "Failed to Insert", Toast.LENGTH_SHORT).show();
    }

    int countData = DB.countData();
    count.setText("Number Of Data In Database : " + countData);

    }


    public void update(View view) {
        String name = name_input.getText().toString();
        int age = Integer.parseInt(age_input.getText().toString());
        String collage = collage_input.getText().toString();
        boolean result = DB.updateData(name, age, collage);
        if (result) {
            Toast.makeText(this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show();
        }
    }


    public void deleteAll(View view) {
    Toast.makeText(this, "All Data Been Deleted ", Toast.LENGTH_SHORT).show();
    DB.deleteAll();
    }


    public void nextPage(View view) {
      Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
      startActivity(intent);
    }


}