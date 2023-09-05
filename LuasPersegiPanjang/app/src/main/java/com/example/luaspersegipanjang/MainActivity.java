package com.example.luaspersegipanjang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtPanjang;
    private EditText edtLebar;
    private TextView tvHasil;
    private Button btnHitung;
    private  static final String STATE_HASIL = "state_hasil";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        tvHasil = findViewById(R.id.tv_hasil);
        btnHitung = findViewById(R.id.btn_hasil);

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_hasil){
            String inputlenght = edtPanjang.getText().toString().trim();
            String inputWidht = edtLebar.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputlenght)) {
                isEmptyFields = true;
                edtPanjang.setError("Fields ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidht)) {
                isEmptyFields = true;
                edtLebar.setError("Fields ini tidak boleh kosong");
            }
            double panjang = toDouble(inputlenght);
            double lebar = toDouble(inputWidht);

            if (panjang==0){
                isInvalidDouble = true;
                edtPanjang.setError("Fields ini harus berupa nomor yang vsalid");
            }
            if (lebar==0){
                isInvalidDouble = true;
                edtLebar.setError("Fields ini harus berupa nomor yang vsalid");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume =panjang * lebar;
                tvHasil.setText(String.valueOf(volume));
            }

        }
    }
    private  Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}