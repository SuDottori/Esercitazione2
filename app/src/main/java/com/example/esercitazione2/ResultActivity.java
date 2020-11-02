package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nometext;
    TextView cognometext;
    TextView datatext;
    TextView indirizzotext;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        nometext= findViewById(R.id.titleNome);
        cognometext= findViewById(R.id.titleCognome);
        datatext= findViewById(R.id.titleDataNascita);
        indirizzotext= findViewById(R.id.titleIndirizzo);
        back=findViewById(R.id.Back);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }else{
            this.persona = new Persona();
        }

        nometext.setText(persona.getNome());
        cognometext.setText(persona.getCognome());
        datatext.setText(persona.getDataNascita());
        indirizzotext.setText(persona.getIndirizzo());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(showResult);
            }
        });

    }
}