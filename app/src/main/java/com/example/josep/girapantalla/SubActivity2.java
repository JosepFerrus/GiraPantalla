package com.example.josep.girapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;

public class SubActivity2 extends AppCompatActivity {

    TextView txt;
    Button con;
    EditText textEdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub2);

        txt=(TextView) findViewById(R.id.texto);
        con=(Button) findViewById(R.id.boto);
        textEdat=(EditText)findViewById(R.id.Edat);
        Bundle bundle = getIntent().getExtras();
        txt.setText("Hola " + bundle.getString("NOMBRE") + " tu genero es "+  bundle.getString("Genero"));


        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vuelta = new Intent();

                Bundle b =new Bundle();

                b.putInt("EDAT", Integer.parseInt(textEdat.getText().toString()));

                vuelta.putExtras(b);
                setResult(RESULT_OK,vuelta);
                finish();

            }
        });

    }
}
