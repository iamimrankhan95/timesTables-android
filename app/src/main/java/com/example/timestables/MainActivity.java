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

    SeekBar timesTablesSeekBar;
    ListView timesTableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timesTables();
    }
    protected void timesTables(){
        timesTablesSeekBar = findViewById(R.id.seekBar);
        timesTableListView= findViewById(R.id.timesTables);
        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(1);
        ArrayList<Integer> timesTable=new ArrayList<Integer>();
        for(int a=1;a<=10;a++){
            timesTable.add(a*1);
        }
        ArrayAdapter<Integer> readyTimesTable=new ArrayAdapter<Integer>(getBaseContext(), android.R.layout.simple_list_item_1,timesTable);
        timesTableListView.setAdapter(readyTimesTable);
        timesTablesSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<1){
                    timesTablesSeekBar.setProgress(1);//Any variable defined in a method and accessed by an anonymous inner class must be final. Otherwise, you could use that variable in the inner class, unaware that if the variable changes in the inner class, and then it is used later in the enclosing scope, the changes made in the inner class did not persist in the enclosing scope. Basically, what happens in the inner class stays in the inner class.
                    progress=1;
                }
                ArrayList<Integer> timesTable2=new ArrayList<Integer>();

                for(int a=1;a<=10;a++){
                    timesTable2.add(a*progress);
                }
                ArrayAdapter<Integer> readyTimesTable=new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,timesTable2);
                timesTableListView.setAdapter(readyTimesTable);
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
