package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PindahDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE ="extra_age";
    public static final String EXTRA_NAME ="extra_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_data);
        TextView tvDataRecieved = findViewById(R.id.tv_recieve_data);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 17);
        String text ="Nama : " +name + "Umur:" +age;

        tvDataRecieved.setText(text);
    }
}