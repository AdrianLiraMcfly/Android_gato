package com.cartelderamironuevageneracion.gatito_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView player = findViewById(R.id.player);
    TextView pc = findViewById(R.id.pc);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        String con = bundle.getString("nombre");

        player.setText(con);
    }
}