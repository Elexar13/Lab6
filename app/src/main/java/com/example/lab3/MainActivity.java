package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            if (savedInstanceState.getInt("seconds")>0){
                seconds = savedInstanceState.getInt("seconds");
            }
        }catch (NullPointerException ignored){
        }


        runTimer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isRunning = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    public void onBtnClick(View view){
        Spinner spinner = findViewById(R.id.spinner);
        String animalGroup = (String) spinner.getSelectedItem();

        Intent intent = new Intent(this, AnimalListActivity.class);
        intent.putExtra(AnimalListActivity.ANIMAL_GROUP, animalGroup);

        startActivity(intent);
    }

    private void runTimer(){
        final TextView timeView = findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);
                if (isRunning) seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
    }

    public void onAnimalBtnClick(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        String animalName = (String) spinner.getSelectedItem();

        System.out.println("aaaaaaaaaaaa");

        Intent intent = new Intent(this, AnimalGroupActivity.class);
        intent.putExtra(AnimalGroupActivity.ANIMAL_NAME, animalName);

        startActivity(intent);
    }
}