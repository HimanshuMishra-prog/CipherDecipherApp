package com.example.cipherdecipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.source.CaesarCipher;
import com.source.vigenereCipher;

public class MainActivityDecipher extends AppCompatActivity {

    TextView t1 ;
    CaesarCipher ceaser ;
    vigenereCipher vig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);

        t1 = (TextView)findViewById(R.id.result);
        Bundle b1 = getIntent().getExtras();
        String data = b1.getString("data");
        String keys = b1.getString("keys");
        String k[] = keys.split(",");
        int [] key = new int[k.length];
        int i =0;
        for(String temp:k) {
            try{key[i] = Integer.parseInt(temp);}
            catch(NumberFormatException e){

            }
            i++;
        }
        String option = b1.getString("option");
        if(option == null) option = "Caeser Cipher";
        if(option.equals("Caeser Cipher")){
            callCaesar(data,key);
        }
        else if(option.equals("Vigenere Cipher")){
            callViginer(data,key);
        }
    }

    private void callViginer(String data, int []key) {
        vig = new vigenereCipher(key);
        String output = vig.decrypt(data);
        t1.setText(output);
    }

    private void callCaesar(String data, int[] key) {
        ceaser = new CaesarCipher(key[0]);
        String output = ceaser.decrypt(data);
        t1.setText(output);
    }
}