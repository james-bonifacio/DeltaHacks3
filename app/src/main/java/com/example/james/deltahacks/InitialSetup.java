package com.example.james.deltahacks;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InitialSetup extends AppCompatActivity {
    private RadioButton radioCustom;
    private EditText field;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup);

        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);

                startActivity(i);
            }
        });


        radioCustom = (RadioButton)findViewById(R.id.radioCustom);
        field = (EditText)findViewById(R.id.dockey);



        View.OnClickListener listen = new View.OnClickListener() {
            @Override

            public void onClick(View v) {



                field.setVisibility(View.VISIBLE);

            }
        };
        radioCustom.setOnClickListener(listen);


    }
}
