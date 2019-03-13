package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.widget.SeekBar.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timesTables();
    }
    protected void timesTables(){
        SeekBar timesTablesSeekBar = findViewById(R.id.seekBar);
        timesTablesSeekBar.setMax(20);
        final ListView timesTableView= findViewById(R.id.timesTables);
        final ArrayList<Integer> timesTable=new ArrayList<Integer>();

        for(int a=1;a<=10;a++){
            timesTable.add(a*1);
        }
        ArrayAdapter<Integer> readyTimesTable=new ArrayAdapter<Integer>(getBaseContext(), android.R.layout.simple_list_item_1,timesTable);
        timesTableView.setAdapter(readyTimesTable);
        timesTablesSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                final ArrayList<Integer> timesTable2=new ArrayList<Integer>();

                for(int a=1;a<=10;a++){
                    timesTable2.add(a*progress);
                }
                ArrayAdapter<Integer> readyTimesTable=new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,timesTable2);
                timesTableView.setAdapter(readyTimesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
