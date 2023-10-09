package com.cartelderamironuevageneracion.gatito_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView player = findViewById(R.id.player);
    TextView pc = findViewById(R.id.pc);
    Button btn = findViewById(R.id.btnbck);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String resultado = extras.getString("resultado");
            int puntaje = extras.getInt("puntaje");

            if (resultado.equals("Ganaste")) {
                player.setText("Ganaste");
                pc.setText("Perdiste");
            } else if (resultado.equals("Perdiste")) {
                player.setText("Perdiste");
                pc.setText("Ganaste");
            } else {
                player.setText("Empate");
                pc.setText("Empate");
            }
        }
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        btn.setOnClickListener(view -> {
            startActivity(intent);
        });

    }
    }