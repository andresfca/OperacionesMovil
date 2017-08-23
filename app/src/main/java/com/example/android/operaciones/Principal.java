package com.example.android.operaciones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private TextView res;
    private EditText n1, n2;
    private Resources resources;
    private Spinner operaciones;
    private String op[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        res = (TextView)findViewById(R.id.lblResultado);
        n1 = (EditText)findViewById(R.id.txtnumerouno);
        n2 = (EditText)findViewById(R.id.numerodos);
        operaciones = (Spinner)findViewById(R.id.cmboperaciones);
        resources = this.getResources();
        op = resources.getStringArray(R.array.operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        operaciones.setAdapter(adapter);
    }

    public void calcular(View v){


        if(validar()) {
            int num1, num2, resu;
            num1 = Integer.parseInt(n1.getText().toString());
            num2 = Integer.parseInt(n2.getText().toString());
            resu = num1 + num2;

            res.setText("" + resu);
        }
    }

    public void borrar(View v){
        res.setText("");
        n1.setText("");
        n2.setText("");
        n1.requestFocus();
    }

    public boolean validar(){
        if (n1.getText().toString().isEmpty()){
            n1.setError(resources.getString(R.string.mensaje_error));
            return false;
        }
        if (n2.getText().toString().isEmpty()){
            n2.setError(resources.getString(R.string.mensaje_error_dos));
            return false;
        }
        return true;
    }
}
