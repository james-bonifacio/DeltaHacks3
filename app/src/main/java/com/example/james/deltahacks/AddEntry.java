package com.example.james.deltahacks;

import android.content.Intent;
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
                    }
                }
        );
    }

    private View.OnClickListener btnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            WriteBtn();
            ReadBtn();
        }
    };

    public void WriteBtn() {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write("0:0:0:100,100,100,100,100,100,100:0,0,0,0,0,0,0");
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ReadBtn() {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[100];
            String s="";
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
    }
}
