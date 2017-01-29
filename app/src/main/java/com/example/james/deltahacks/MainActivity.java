package com.example.james.deltahacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCustomEntry;
    private Button btnInitial;
    private Button btnAddEntry;

    private TextView lblScore;
    private TextView lblStreak;
    private TextView lblMacros;

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

        lblScore = (TextView)findViewById(R.id.lblScore);
        lblStreak = (TextView)findViewById(R.id.lblStreak);
        lblMacros = (TextView)findViewById(R.id.lblMacros);

        SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
        String data = sharedPref.getString("data", "");
        String[] arr = data.split(":");
        String[] arrCurr = arr[4].split(",");


        lblScore.setText("Score: " + arr[0]);
        lblStreak.setText("Streak: " + arr[1]);
        lblMacros.setText(arrCurr[0] +","+ arrCurr[1] + "," + arrCurr[2] + "," + arrCurr[3] + "," +arrCurr[4] + "," + arrCurr[5] +","+ arrCurr[6]);

    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnCustomEntry:

                    SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);

                    String data = sharedPref.getString("data", "");

                    Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(v.getContext(), CustomEntry.class);

                    //startActivity(i);
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
