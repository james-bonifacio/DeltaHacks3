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

public class CustomEntry extends AppCompatActivity {

    private SeekBar seekBarCalories, seekBarFat, seekBarProtein, seekBarCarbs, seekBarSugar, seekBarFiber, seekBarSodium;
    private TextView lblCalories, lblFat, lblProtein, lblCarbs, lblSugar, lblFiber, lblSodium;
    private Button btnSubmit;
    private int[] valToAdd = {0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_entry);

        seekBarCalories();
        seekBarFat();
        seekBarProtein();
        seekBarCarbs();
        seekBarSugar();
        seekBarFiber();
        seekBarSodium();

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(btnClickListener);
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            valToAdd[0] = seekBarCalories.getProgress();
            valToAdd[1] = seekBarFat.getProgress();
            valToAdd[2] = seekBarProtein.getProgress();
            valToAdd[3] = seekBarCarbs.getProgress();
            valToAdd[4] = seekBarSugar.getProgress();
            valToAdd[5] = seekBarSodium.getProgress();
            valToAdd[6] = seekBarFiber.getProgress();

            String current = ReadBtn();

            String[] arr = current.split(":");

            for (int i=0;i<5;i++){
                System.out.println(arr[i]);
            }

            String[] arrCurr = arr[4].split(",");

            System.out.println("Val to add: " + valToAdd[0]);

            for (int i=0;i<7;i++){
                arrCurr[i] = Integer.toString(Integer.parseInt(arrCurr[i]) + valToAdd[i]);
                System.out.println(arrCurr[i]);
            }

            String toWrite = arr[0]+":"+arr[1]+":"+arr[2]+":"+arr[3]+":";

            for (int i=0; i<7; i++){
                toWrite = toWrite + arrCurr[i]+",";
            }

            //remove last comma
            toWrite = toWrite.substring(0,toWrite.length()-1);

            System.out.println("Out: " + toWrite);

            WriteBtn(toWrite);

        }
    };

    public void WriteBtn(String text) {
        // add-write text into file

        SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("data", text);
        editor.apply();
    }

    public String ReadBtn() {

        SharedPreferences sharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);

        String data = sharedPref.getString("data", "");

        System.out.println(data);

        return data;

    }

    public void seekBarCalories(){

        seekBarCalories = (SeekBar) findViewById(R.id.seekBarCalories);
        lblCalories = (TextView) findViewById(R.id.lblCalories);

        seekBarCalories.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblCalories.setText("Calories: " + String.valueOf(seekBarCalories.getProgress()));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblCalories.setText("Calories: " + String.valueOf(seekBarCalories.getProgress()));
                    }
                }
        );
    }

    public void seekBarFat(){

        seekBarFat = (SeekBar) findViewById(R.id.seekBarFat);
        lblFat = (TextView) findViewById(R.id.lblFat);


        seekBarFat.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblFat.setText("Fat: " + String.valueOf(seekBarFat.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblFat.setText("Fat: " + String.valueOf(seekBarFat.getProgress()) + "g");

                    }
                }
        );

    }

    public void seekBarProtein(){
        seekBarProtein = (SeekBar) findViewById(R.id.seekBarProtein);
        lblProtein = (TextView) findViewById(R.id.lblProtein);


        seekBarProtein.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblProtein.setText("Protein: " + String.valueOf(seekBarProtein.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblProtein.setText("Protein: " + String.valueOf(seekBarProtein.getProgress()) + "g");

                    }
                }
        );

    }

    public void seekBarCarbs(){

        seekBarCarbs = (SeekBar) findViewById(R.id.seekBarCarbs);
        lblCarbs = (TextView) findViewById(R.id.lblCarbs);


        seekBarCarbs.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblCarbs.setText("Carbohydrates: " + String.valueOf(seekBarCarbs.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblCarbs.setText("Carbohydrates: " + String.valueOf(seekBarCarbs.getProgress()) + "g");

                    }
                }
        );

    }

    public void seekBarSugar(){

        seekBarSugar = (SeekBar) findViewById(R.id.seekBarSugar);
        lblSugar = (TextView) findViewById(R.id.lblSugar);


        seekBarSugar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblSugar.setText("Sugar: " + String.valueOf(seekBarSugar.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblSugar.setText("Sugar: " + String.valueOf(seekBarSugar.getProgress()) + "g");

                    }
                }
        );

    }

    public void seekBarFiber(){

        seekBarFiber = (SeekBar) findViewById(R.id.seekBarFiber);
        lblFiber = (TextView) findViewById(R.id.lblFiber);


        seekBarFiber.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblFiber.setText("Fiber: " + String.valueOf(seekBarFiber.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblFiber.setText("Fiber: " + String.valueOf(seekBarFiber.getProgress()) + "g");

                    }
                }
        );

    }

    public void seekBarSodium(){

        seekBarSodium = (SeekBar) findViewById(R.id.seekBarSodium);
        lblSodium = (TextView) findViewById(R.id.lblSodium);


        seekBarSodium.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){


                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        lblSodium.setText("Sodium: " + String.valueOf(seekBarSodium.getProgress()) + "g");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        lblSodium.setText("Sodium: " + String.valueOf(seekBarSodium.getProgress()) + "g");

                    }
                }
        );

    }
}
