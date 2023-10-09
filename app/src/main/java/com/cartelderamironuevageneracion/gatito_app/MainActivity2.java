package com.cartelderamironuevageneracion.gatito_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    Bundle bundle = new Bundle();
    TextView txtNombre;
    int puntaje = 0;

    int[] tab = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    int estado = 0;
    int fichaput = 0;
    int turno = 1;
    int[] posgan = new int[]{-1, -1, -1};
    int numbtn;
    Integer[] botones = {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtNombre = findViewById(R.id.txtvic);
        fichaput = 0;
        estado = 0;

        numbtn = 0;
        Button button1 = findViewById(R.id.b1);
        selectgato(button1);
    }



    public void selectgato(View v){
        if (estado==0){
            turno=1;
            Button b = (Button) findViewById(v.getId());
            numbtn= Arrays.asList(botones).indexOf(v.getId());
            if (tab[numbtn]==0){
                b.setBackgroundResource(R.drawable.palomita);
                b.setText("");
                estado=1;
                tab[numbtn]=1;
                fichaput++;
                estado=getEstado();
                terminpart();
                if (estado == 0) {
                    turno = -1;
                    ia();
                    fichaput++;
                    terminpart();
                }
            }
        }
    }



    public void ia(){
        Random rand = new Random();
        int pos = rand.nextInt(tab.length);
        while (tab[pos]!=0){
            pos = rand.nextInt(tab.length);
        }
        Button b = (Button) findViewById(botones[pos]);
        b.setBackgroundResource(R.drawable.equis);
        tab[pos]=-1;
    }

    public int getEstado(){
        int newestado=0;
        if (Math.abs(tab[0]+tab[1]+tab[2])==3){
           posgan= new int[]{0,1,2};
           newestado=1*turno;
        }
        else if (Math.abs(tab[3]+tab[4]+tab[5])==3){
            posgan= new int[]{3,4,5};
            newestado=1*turno;
        }
        else if (Math.abs(tab[6]+tab[7]+tab[8])==3){
            posgan= new int[]{6,7,8};
            newestado=1*turno;
        }
        else if (Math.abs(tab[0]+tab[3]+tab[6])==3){
            posgan= new int[]{0,3,6};
            newestado=1*turno;
        }
        else if (Math.abs(tab[3]+tab[4]+tab[5])==3){
            posgan= new int[]{0,1,2};
            newestado=1*turno;
        }
        else if (Math.abs(tab[1]+tab[4]+tab[7])==3){
            posgan= new int[]{1,4,7};
            newestado=1*turno;
        }
        else if (Math.abs(tab[2]+tab[5]+tab[8])==3){
            posgan= new int[]{2,5,8};
            newestado=1*turno;
        }
        else if (Math.abs(tab[0]+tab[4]+tab[8])==3){
            posgan= new int[]{0,4,8};
            newestado=1*turno;
        }
        else if (Math.abs(tab[2]+tab[4]+tab[6])==3){
            posgan= new int[]{2,4,6};
            newestado=1*turno;
        }
        else if (fichaput==9){
            newestado=2;
        }

            return newestado;


    }

    public void terminpart(){
        Intent in = new Intent(this, MainActivity3.class);
        String conc = null;
        if (estado == 1) {
            txtNombre.setText("Ganaste");
            conc = "Ganaste";
            puntaje++; // Incrementa el puntaje si ganó
            for (int i = 0; i < 3; i++) {
                Button b = (Button) findViewById(botones[posgan[i]]);
                b.setBackgroundResource(R.drawable.palomita);
            }
        } else if (estado == -1) {
            txtNombre.setText("Perdiste");
            conc = "Perdiste";
            // No hace nada con el puntaje si perdió
            for (int i = 0; i < 3; i++) {
                Button b = (Button) findViewById(botones[posgan[i]]);
                b.setBackgroundResource(R.drawable.equis);
            }
        } else if (estado == 2) {
            txtNombre.setText("Empate");
            conc = "Empate";
        }

        bundle.putString("resultado", conc);
        bundle.putInt("puntaje", puntaje);
        in.putExtras(bundle);
        startActivity(in);
    }

}