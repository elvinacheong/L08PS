package com.myapplicationdev.android.l08ps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    Button btnShowAll;
    ListView lv;
    RadioGroup rgStars;

    ArrayList<Song> al;
    ArrayAdapter<Song> aa;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnShowAll = findViewById(R.id.btnShowAll);
        lv = findViewById(R.id.lv);
        rgStars = findViewById(R.id.rgStars);

        DBHelper db1 = new DBHelper(List.this);
        db1.close();

        DBHelper db2 = new DBHelper(List.this);
        db2.close();

        aa = new ArrayAdapter<>(List.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stars;
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton6) {
                    stars = 1;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton7) {
                    stars = 2;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton8) {
                    stars = 3;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton9) {
                    stars = 4;
                } else {
                    stars = 5;
                }
                DBHelper db = new DBHelper(List.this);
                al = db.getAllSongs();
                db.close();

                aa = new ArrayAdapter<>(List.this, android.R.layout.simple_list_item_1, al);
                lv.setAdapter(aa);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song pos = al.get(position);
                Intent intent = new Intent(List.this, SecondActivity.class);
                intent.putExtra("song", (CharSequence) pos);
                startActivity(intent);
            }
        });
    }
}
