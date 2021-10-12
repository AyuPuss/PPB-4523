package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angk1,angk2;
    TextView hasilnya;
    Button tmblTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    angk1=(EditText) findViewById(R.id.angka1);
    angk2=(EditText) findViewById(R.id.angka2);
    hasilnya=(TextView) findViewId(R.id.hasilHitung);
    tmblTambah=(Button) findViewId(R.id.tblHitung);

    tmblTambah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int a1=Integer.parseInt(angk1.getText().toString());
            int a2=Integer.parseInt(angk2.getText().toString());
            Integer hasil=a1+a2;

            hasilnya.setText(hasil.toString());

        }
    })
}