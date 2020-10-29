package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class AnimalListActivity extends AppCompatActivity {

    public static final String ANIMAL_GROUP = "animalGroup";
    private float textSize = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        Intent intent = getIntent();
        String animalGroup = intent.getStringExtra(ANIMAL_GROUP);

        StringBuilder txtAnimals = new StringBuilder();
        AnimalGroups.getAnimals(animalGroup).forEach(a -> txtAnimals.append(a.getName()).append("\n"));

        TextView textView = findViewById(R.id.text);
        textView.setText(txtAnimals);

        textSize = textView.getTextSize();

        if (savedInstanceState != null){
            textSize = savedInstanceState.getFloat("textSize");
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }

    }



    public void onSendBtnClick(View view) {
        TextView textView = findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("texp/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Animals list");
        startActivity(intent);
    }

    public void onPlusBtnClick(View view) {
        textSize = textSize * 1.1f;
        TextView textView = findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }
}