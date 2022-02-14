package com.example.cipherdecipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.source.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText toManipulate ;
    EditText keys;
    Spinner spin;
    String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toManipulate = (EditText)findViewById(R.id.ed1);
        keys = (EditText)findViewById(R.id.keyText);
        spin  = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tech, R.layout.spinner_text);
        adapter.setDropDownViewResource(R.layout.dropdown);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    public void transferToCipherActivity(View view) {

        Intent I1 = new Intent(this,MainActivitySecond.class);
        I1.putExtra("data",toManipulate.getText().toString());
        I1.putExtra("keys",keys.getText().toString());
        I1.putExtra("option",option);
        startActivity(I1);
    }


    public void transferToDecipherActivity(View view) {
        Intent I1 = new Intent(this,MainActivityDecipher.class);
        I1.putExtra("data",toManipulate.getText().toString());
        I1.putExtra("keys",keys.getText().toString());
        I1.putExtra("option",option);
        startActivity(I1);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        option = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}