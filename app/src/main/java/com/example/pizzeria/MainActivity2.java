package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
Button Regresar;
TextView Recibe;
TextView txttottal;
TextView tamanno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Regresar = (Button) findViewById(R.id.btnRegresar);
        Recibe = (TextView) findViewById(R.id.txtRecibe);
        txttottal=(TextView) findViewById(R.id.txttottall);
        tamanno=(TextView)  findViewById(R.id.txttamano);
        //metodo para recibir
        Bundle recibir = this.getIntent().getExtras();
        String datosrecibidos = recibir.getString("Nombre");
        Double d1 = recibir.getDouble("total");
        String d2= recibir.getString("tamanno");
        Recibe.setText(datosrecibidos);

        txttottal.setText("Total: $" + d1);
        tamanno.setText("Tamaño: $" + d2);

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasar1=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(pasar1);

            }
        });





        }

    }
