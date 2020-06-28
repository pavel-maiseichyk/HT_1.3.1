package com.example.ht_131;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Values extends AppCompatActivity {

    private EditText steps;
    private EditText weight;

    private static final String TAG = "myApp";

    private SharedPreferences sharedPreferencesSTEPS;
    private SharedPreferences sharedPreferencesWEIGHT;

    private static final String STEPS = "steps";
    private static final String WEIGHT = "weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values);

        init();

    }

    public void init() {

        Log.i(TAG, "Инициализация...");

        steps = findViewById(R.id.steps);
        weight = findViewById(R.id.weight);

        sharedPreferencesWEIGHT = getSharedPreferences("WeightPrefs", MODE_PRIVATE);
        sharedPreferencesSTEPS = getSharedPreferences("StepsPrefs", MODE_PRIVATE);

        steps.setText(sharedPreferencesSTEPS.getString(STEPS, ""));
        weight.setText(sharedPreferencesWEIGHT.getString(WEIGHT, ""));

        Log.i(TAG, "Инициализация завершена");

    }

    public void saveButtonClicked(View view) {

        Log.i(TAG, "Нажата кнопка 'Сохранить'");

        sharedPreferencesSTEPS.edit().putString(STEPS, steps.getText().toString()).apply();
        sharedPreferencesWEIGHT.edit().putString(WEIGHT, weight.getText().toString()).apply();

        Toast.makeText(this, "Сохранено!", Toast.LENGTH_SHORT).show();

    }
}