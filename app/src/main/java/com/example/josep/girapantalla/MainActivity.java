package com.example.josep.girapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    EditText Nom;
    TextView Nombre;
    TextView Generes;
    RadioButton genere1;
    RadioButton genere2;
    Button dades;
    TextView frase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre=(TextView) findViewById(R.id.Nom);
        frase=(TextView) findViewById(R.id.frase);
        genere2 = (RadioButton) findViewById(R.id.Genero3);
        genere1 = (RadioButton) findViewById(R.id.Genero2);
        dades = (Button) findViewById(R.id.button);
        Generes=(TextView) findViewById(R.id.genere);
        RadioGroup rg = (RadioGroup) findViewById(R.id.Genero);
        rg.clearCheck();
        rg.check(R.id.Genero3);

        Nom = (EditText) findViewById(R.id.Nombre);

        dades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Nom.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Hay datos sin completar", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(v.getContext(), SubActivity2.class);
                    Bundle b = new Bundle();
                    b.putString("NOMBRE", Nom.getText().toString());
                    if (genere2.isChecked()) {
                        b.putString("Genero", genere2.getText().toString());
                    } else {
                        b.putString("Genero", genere1.getText().toString());
                    }

                    intent.putExtras(b);
                    startActivityForResult(intent, 0);
                }
            }

        });
    }


        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 0) {
                 if (resultCode == RESULT_OK) {

                     Nombre.setVisibility(View.INVISIBLE);
                     Nom.setVisibility(View.INVISIBLE);
                     dades.setVisibility(View.INVISIBLE);
                     genere2.setVisibility(View.INVISIBLE);
                     genere1.setVisibility(View.INVISIBLE);
                     Generes.setVisibility(View.INVISIBLE);
                     frase.setVisibility(View.VISIBLE);
                     Bundle bundle = data.getExtras();


                    if((bundle.getInt("EDAT")>18)&&(bundle.getInt("EDAT")<=25)){
                    frase.setText("Eres major de edat");
                     }
                     if((bundle.getInt("EDAT")>25)&&(bundle.getInt("EDAT")<35)) {
                         frase.setText("Estas en la flor de la vida");
                     }
                     if (bundle.getInt("EDAT") >= 35) {
                             frase.setText("Ai ai ai...");
                     }

                 }
             }
        }


    }





