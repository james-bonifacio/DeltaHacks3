package com.example.james.deltahacks;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AddEntry extends AppCompatActivity {

    private Button btnAddEntry;
    private int[] valToAdd = {0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);


        btnAddEntry = (Button)findViewById(R.id.btnAddEntry);

        btnAddEntry.setOnClickListener(btnClickListener);

        String foods[] = {"Beans", "Greens", "Potatoes", "Tomatoes", "Lamb", "Rams", "Hogs", "Dogs"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, foods);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition((position)));
                        Toast.makeText(AddEntry.this, food, Toast.LENGTH_SHORT).show();

                        switch (food){
                            case "Beans":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 10;
                                }
                                break;
                            case "Greens":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 20;
                                }
                                break;
                            case "Potatoes":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 30;
                                }
                                break;
                            case "Tomatoes":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 40;
                                }
                                break;
                            case "Lamb":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 50;
                                }
                                break;
                            case "Rams":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 60;
                                }
                                break;
                            case "Hogs":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 70;
                                }
                                break;
                            case "Dogs":
                                for (int i=0; i<7; i++ ){
                                    valToAdd[i] = 80;
                                }
                                break;
                        }
                    }
                }
        );


    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
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
        try {
            FileOutputStream fileout=openFileOutput(text, MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(text);
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ReadBtn() {

        String s="";
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[100];

            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }

            System.out.println(s);
            InputRead.close();
            Toast.makeText(getBaseContext(), s,Toast.LENGTH_SHORT).show();



        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;

    }
}
