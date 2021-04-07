package com.example.tiki_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SendingData{

    TextView tvThanhTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhTien = findViewById(R.id.tvThanhTien);
        getSupportFragmentManager().beginTransaction().add(R.id.frmContainerBelow,Fragment_Below.newInstance("0")).commit();
    }

    @Override
    public void sendData(String data) {
        DecimalFormat df = new DecimalFormat("###,###,### đ");
        double tam = 141800;
        double tt = 0;
        tt=tam*Integer.parseInt(data);
        String out= "";
        out=df.format(tt);

        tvThanhTien.setText(out);
        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainerBelow,Fragment_Below.newInstance(out)).commit();
    }
}