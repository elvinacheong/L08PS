package com.myapplicationdev.android.l08ps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText etSongTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete, btnCancel;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        rgStars = findViewById(R.id.rgStars);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SecondActivity.this);
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

                String song = etSongTitle.getText().toString();
                String singer = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                db.updateSong(getTaskId(), song, singer, year, stars);
                db.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SecondActivity.this);
                db.deleteSong(getTaskId());
                db.close();
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
