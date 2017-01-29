package com.example.james.deltahacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCustomEntry;
    private Button btnInitial;
    private Button btnAddEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCustomEntry = (Button)findViewById(R.id.btnCustomEntry);
        btnCustomEntry.setOnClickListener(btnClickListener);

        btnInitial = (Button)findViewById(R.id.btnInitial);
        btnInitial.setOnClickListener(btnClickListener);

        btnAddEntry = (Button)findViewById(R.id.btnAddEntry);
        btnAddEntry.setOnClickListener(btnClickListener);
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnCustomEntry:
                    Intent i = new Intent(v.getContext(), CustomEntry.class);

                    startActivity(i);
                    break;
                case R.id.btnInitial:
                    Intent j = new Intent(v.getContext(), InitialSetup.class);

                    startActivity(j);
                    break;
                case R.id.btnAddEntry:
                    Intent k = new Intent(v.getContext(), AddEntry.class);

                    startActivity(k);
                    break;
            }
        }
    };

}
