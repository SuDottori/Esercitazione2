package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    TextView invisibile;
    EditText nome, cognome, data, indirizzo, input;
    Button inserisci;
    Persona persona;
    SeekBar seekbar;
    int modelValue= 50;
    int minValue= 0;
    int maxValue= 100;
    public static final String PERSONA_PATH ="com.example.esercitazione2.Persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.attrNome);
        cognome = findViewById(R.id.attrCognome);
        data = findViewById(R.id.attrDataNascita);
        indirizzo = findViewById(R.id.attrIndirizzo);
        inserisci = findViewById(R.id.saveButton);
        input = findViewById(R.id.input);
        invisibile= findViewById(R.id.invisible);
        persona = new Persona();
        seekbar =findViewById(R.id.seekbar);

        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                updatePersona();
                showResult.putExtra( PERSONA_PATH , persona);
                startActivity(showResult);

            }

        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateValue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());

            }
        });
    }

    public void updatePersona(){

        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setDataNascita(this.data.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());

    }

    protected void updateValue(int newValue) {
        newValue = newValue > maxValue ? maxValue : newValue;
        newValue = newValue < minValue ? minValue : newValue;
        this.modelValue = newValue;
        input.setText("" + this.modelValue);
    }

    public boolean Controllo(Persona persona){
        if (persona.getNome()== "" || persona.getCognome()=="" || persona.getDataNascita()=="" || persona.getIndirizzo()==""){
            return true;
        }else return false;
    }
}