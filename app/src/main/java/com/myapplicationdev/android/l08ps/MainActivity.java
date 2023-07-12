package com.myapplicationdev.android.l08ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSongTitle, tvSingers, tvYear, tvStars;
    EditText etSongTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSongTitle = findViewById(R.id.tvSongTitle);
        tvSingers = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        btnInsert = findViewById(R.id. btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        rgStars = findViewById(R.id.rgStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

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

                db.insertSong(song, singer, year, stars);
                db.close();

                etSongTitle.setText("");
                etSingers.setText("");
                etYear.setText("");
            }
        });

    }
}