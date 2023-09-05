package com.example.mytambah;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView edtAngka1;
    private TextView edtAngka2;
    private EditText edtJawab;
    private TextView txtHasil;
    private Button btnCek;
    private Button btnBantuan;
    private Button btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAngka1 = findViewById(R.id.Edtangka1);
        edtAngka2= findViewById(R.id.Edtangka2);
        edtJawab= findViewById(R.id.Edtjawab);
        txtHasil = findViewById(R.id.show_result);
        btnCek = findViewById(R.id.button_result);
        btnNext = findViewById(R.id.button_next);
        btnBantuan=findViewById(R.id.button_bantuan);

        btnCek.setOnClickListener(this);
        btnBantuan.setOnClickListener(this);
        btnNext.setOnClickListener(view -> {
            Random acak = new Random();
            int var1 = acak.nextInt(11 - 1) + 1;
            int var2 = acak.nextInt(11 - 1) + 1;

            edtAngka1.setText(Integer.toString(var1));
            edtAngka2.setText(Integer.toString(var2));
        });


    }
@SuppressLint("setText")
    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.button_bantuan){
            Toast toast=Toast.makeText(getApplicationContext(),"Maaf Bantuan Belum tersedia saat ini",Toast.LENGTH_SHORT);
            toast.show();
        }
        if(view.getId()==R.id.button_result){


            String Angka1 =edtAngka1.getText().toString();
            int acakAngka1 = Integer.parseInt(Angka1);

            String Angka2 =edtAngka2.getText().toString();
            int acakAngka2 = Integer.parseInt(Angka2);

            String InputJawab =edtJawab.getText().toString().trim();
            int jawab =Integer.parseInt(InputJawab);

           double hasil =acakAngka1+acakAngka2;
           txtHasil.setText(String.valueOf(hasil));

           if(TextUtils.isEmpty(InputJawab)){
               edtJawab.setError("Kolom harus diisi");
           }
           if (hasil==jawab) {
               txtHasil.setText("");
               Toast toast = Toast.makeText(getApplicationContext(), "Jawaban Anda Benar", Toast.LENGTH_SHORT);
               toast.show();
           }else{Toast toast = Toast.makeText(getApplicationContext(), "Jawaban Anda Salah", Toast.LENGTH_SHORT);
               toast.show();
           }


    }
}

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
    }