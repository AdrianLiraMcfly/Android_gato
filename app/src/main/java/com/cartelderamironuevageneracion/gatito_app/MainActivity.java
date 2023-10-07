package com.cartelderamironuevageneracion.gatito_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button ini= findViewById(R.id.btnini);
    TextView txttime=findViewById(R.id.time);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, MainActivity2.class );

                startActivity( intent );
            }
        });

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                txttime.setText("Tiempo: " + millisUntilFinished / 1000);
            }
            public  void onFinish(){
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        }.start();
        }
    }