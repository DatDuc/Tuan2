package com.example.tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity5 extends AppCompatActivity {


    CheckBox ckCase;
    CheckBox ckUpCase;
    CheckBox ckNumber;
    CheckBox ckSpecial;

    TextView txtPass;
    EditText txtLenght;
    ArrayList<Integer> a = new ArrayList<Integer>();
    Button btngene;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btngene =  findViewById(R.id.btngene);
        txtLenght = findViewById(R.id.txtLenght);
        txtPass = findViewById(R.id.txtPass);
        ckCase = findViewById(R.id.ckCase);
        ckUpCase = findViewById(R.id.ckUpCase);
        ckNumber = findViewById(R.id.ckNumber);
        ckSpecial = findViewById(R.id.ckSpecial);


        btngene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.clear();
                txtPass.setText("");

                if(ckCase.isChecked())
                    a.add(1);
                if(ckUpCase.isChecked())
                    a.add(2);
                if(ckNumber.isChecked())
                    a.add(3);
                if(ckSpecial.isChecked())
                    a.add(4);
                int length = Integer.parseInt(String.valueOf(txtLenght.getText()));
                String pass = "";
                for(int i = 0; i < length; i++){
                    int check = randomPosition(a);

                    if(check == 1)
                        pass = pass + randomLowercase();
                    if(check == 2)
                        pass = pass + randomUpcase();
                    if(check == 3)
                        pass = pass + randomNumber();
                    if(check == 4)
                        pass = pass + randomSymbol();
                }
                txtPass.setText(pass);

            }
        });


    }

    int randomPosition(ArrayList<Integer> b){
        Random random = new Random();
        int index = random.nextInt(b.size());
        return b.get(index);
    }

    char randomUpcase(){
        Random random = new Random();
        char c = (char)(random.nextInt(26) + 'A');
        return c;
    }

    char randomLowercase(){
        Random random = new Random();
        char c = (char)(random.nextInt(26) + 'a');
        return c;
    }

    char randomNumber() {
        Random random = new Random();
        char c = (char) (random.nextInt(9) + '0');
        return c;
    }

    char randomSymbol() {
        Random random = new Random();
        char c = (char)(random.nextInt(14) + '!');
        return c;
    }


}