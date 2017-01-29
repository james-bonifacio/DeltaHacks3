package com.example.james.deltahacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCustomEntry;
    private Button btnInitial;
    private Button btnAddEntry;
    private Button btnAchievements;

    private TextView lblScore;
    private TextView lblStreak;
    private TextView lblMacros;

    private ProgressBar dailyProgressCal;
    private ProgressBar dailyProgressFat;
    private ProgressBar dailyProgressProtein;
    private ProgressBar dailyProgressCarbs;
    private ProgressBar dailyProgressSugar;
    private ProgressBar dailyProgressSodium;
    private ProgressBar dailyProgressFiber;


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);

        String data = sharedPref.getString("data", "");
        String[] arr = data.split(":");
        String[] arrCurr = arr[4].split(",");
        String[] arrGoal = arr[3].split(",");


        lblScore.setText("Score: " + arr[0]);
        lblStreak.setText("Streak: " + arr[1]);

        dailyProgressCal.setProgress(Integer.parseInt(arrCurr[0]));
        dailyProgressFat.setProgress(Integer.parseInt(arrCurr[1]));
        dailyProgressProtein.setProgress(Integer.parseInt(arrCurr[2]));
        dailyProgressCarbs.setProgress(Integer.parseInt(arrCurr[3]));
        dailyProgressSugar.setProgress(Integer.parseInt(arrCurr[4]));
        dailyProgressSodium.setProgress(Integer.parseInt(arrCurr[5]));
        dailyProgressFiber.setProgress(Integer.parseInt(arrCurr[6]));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInitial = (Button)findViewById(R.id.btnInitial);
        btnInitial.setOnClickListener(btnClickListener);

        btnAddEntry = (Button)findViewById(R.id.btnAddEntry);
        btnAddEntry.setOnClickListener(btnClickListener);

        lblScore = (TextView)findViewById(R.id.lblScore);
        lblStreak = (TextView)findViewById(R.id.lblStreak);

        dailyProgressCal = (ProgressBar)findViewById(R.id.dailyProgressCal);
        dailyProgressFat = (ProgressBar)findViewById(R.id.dailyProgressFat);
        dailyProgressProtein = (ProgressBar)findViewById(R.id.dailyProgressProtein);
        dailyProgressCarbs = (ProgressBar)findViewById(R.id.dailyProgressCarbs);
        dailyProgressSugar = (ProgressBar)findViewById(R.id.dailyProgressSugar);
        dailyProgressSodium = (ProgressBar)findViewById(R.id.dailyProgressSodium);
        dailyProgressFiber = (ProgressBar)findViewById(R.id.dailyProgressFiber);

        SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
        String data = sharedPref.getString("data", "");
        String[] arr = data.split(":");
        String[] arrCurr = arr[4].split(",");
        String[] arrGoal = arr[3].split(",");


        lblScore.setText("Score: " + arr[0]);
        lblStreak.setText("Streak: " + arr[1]);

        dailyProgressCal.setProgress(Integer.parseInt(arrCurr[0]));
        dailyProgressFat.setProgress(Integer.parseInt(arrCurr[1]));
        dailyProgressProtein.setProgress(Integer.parseInt(arrCurr[2]));
        dailyProgressCarbs.setProgress(Integer.parseInt(arrCurr[3]));
        dailyProgressSugar.setProgress(Integer.parseInt(arrCurr[4]));
        dailyProgressSodium.setProgress(Integer.parseInt(arrCurr[5]));
        dailyProgressFiber.setProgress(Integer.parseInt(arrCurr[6]));


        btnAchievements = (Button)findViewById(R.id.btnAchievements);
        btnAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Achievements.class);

                startActivity(i);
            }
        });
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){



        @Override
        public void onClick(View v) {
            switch(v.getId()){
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
