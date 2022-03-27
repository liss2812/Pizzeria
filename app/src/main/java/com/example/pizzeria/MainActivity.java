package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Pizza pizza;
   TextView total;
   double total_price;
   Button Siguiente;
   EditText name;
   RadioButton tamanno1 , tamanno2 , tamanno3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza = new Pizza();
        total = findViewById(R.id.total);
        Siguiente=(Button)findViewById(R.id.btnSiguiente);
        name=(EditText) findViewById(R.id.nombre);
        tamanno1=(RadioButton) findViewById(R.id.rbGrande);
        tamanno2=(RadioButton) findViewById(R.id.rbMediana);
        tamanno3=(RadioButton) findViewById(R.id.rbPequena);
        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto=name.getText().toString();
                Bundle parame=new Bundle();
                parame.putString("Nombre",texto);


                Intent pasar=new Intent(MainActivity.this,MainActivity2.class);
                pasar.putExtras(parame);
                pasar.putExtra("total",calculate_total());
                if (tamanno1.isChecked()){pasar.putExtra("tamanno",tamanno1.getText().toString());}
                if (tamanno2.isChecked()){pasar.putExtra("tamanno",tamanno2.getText().toString());}
                if (tamanno3.isChecked()){pasar.putExtra("tamanno",tamanno3.getText().toString());}
                startActivity(pasar);

            }
        });
    }

    public void radioClicked(View view) {
        boolean checked =((RadioButton) view).isChecked();
        switch (view.getId()){

            case R.id.rbGrande:
                if (checked)
                    pizza.setPizza_size_price(20.00);
                break;
            case R.id.rbMediana:
                if (checked)
                    pizza.setPizza_size_price(10.00);
                break;

            case R.id.rbPequena:
                if (checked)
                    pizza.setPizza_size_price(4.00);
                break;

        }
        total.setText("Total pagar:" +"$"+ pizza.getPizza_size_price());
    }

    public void onCheckboxClicked( View view) {


        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){


            case  R.id.cbPepe:
                if(checked)
                    pizza.setPeperoni_precio(3.00);
                else
                    pizza.setPeperoni_precio(0);
                break;

            case  R.id.cbCarne:
                if(checked)
                    pizza.setCarne_precio(3.00);
                else
                    pizza.setCarne_precio(0);
                break;

            case  R.id.cbHongos:
                if(checked)
                    pizza.setHongos_precio(2.50);
                else
                    pizza.setHongos_precio(0);
                break;


            case  R.id.cbJamon:
                if(checked)
                    pizza.setJamon_precio(1.50);
                else
                    pizza.setJamon_precio(0);
                break;

            case  R.id.cbPiña:
                if(checked)
                    pizza.setPiña_precio(2.00);
                else
                    pizza.setPiña_precio(0);
                break;

            case  R.id.cbPollo:
                if(checked)
                    pizza.setPollo_precio(2.00);
                else
                    pizza.setPollo_precio(0);
                break;

            case  R.id.cbQueso:
                if(checked)
                    pizza.setQueso_precio(2.00);
                else
                    pizza.setQueso_precio(0);
                break;
        }
        total.setText("Total pagar:" + "$"+ calculate_total());
    }
    private  double calculate_total()
    {
        total_price = pizza.getPizza_size_price()+pizza.getCarne_precio()+pizza.getHongos_precio()+pizza.getPeperoni_precio()+pizza.getJamon_precio()+pizza.getPollo_precio()+pizza.getQueso_precio()+pizza.getPiña_precio();
        return total_price;
    }
}
