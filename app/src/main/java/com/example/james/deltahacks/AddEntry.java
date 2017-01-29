package com.example.james.deltahacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AddEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        String foods[] = {"Beans", "Greens", "Potatoes", "Tomatoes", "Lamb", "Rams", "Hogs", "Dogs"};

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, foods);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition((position)));
                        Toast.makeText(AddEntry.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
