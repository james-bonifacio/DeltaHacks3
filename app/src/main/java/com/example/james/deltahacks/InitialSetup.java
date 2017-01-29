package com.example.james.deltahacks;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class InitialSetup extends AppCompatActivity {
    private RadioButton custom;
    private EditText field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup);

        //custom = (RadioButton)findViewById(R.id.customm);
       // field = (EditText)findViewById(R.id.dockey);

        View.OnClickListener listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //field.setHintTextColo;
            }
        };


    }
}
