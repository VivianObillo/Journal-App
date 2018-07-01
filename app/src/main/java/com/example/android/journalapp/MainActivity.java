package com.example.android.journalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText entryET;
    private Button btn;
    private ListView entriesList;

    private ArrayList<String> entries;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryET = findViewById(R.id.entry_edit_text);
        btn = findViewById(R.id.save_btn);
        entriesList = findViewById(R.id.entries_list);

        entries = FileSaver.readData( context; this);

        adapter = new ArrayAdapter<String>( context; this, android.R.layout.simple_list_item_1, entries);
        entriesList.setAdapter(adapter);

        btn.setOnClickListener(this);
        entriesList.setOnClickListener(this)

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:
                String entryEntered = entryET.getText().toString();
                adapter.add(entryEntered);
                entryET.setText("");
                FileSaver.writeData(entries, context; this);
                Toast.makeText( context; this,text; "Entry Saved", Toast.LENGTH_SHORT).show[];
                break;
        }
    }
}





