package com.example.ht_131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Pressure extends AppCompatActivity {

    private EditText highPressure;
    private EditText lowPressure;
    private EditText pulse;
    private EditText dateAndTime;

    private CheckBox tachycardia;

    private static final String TAG = "myApp";

    SharedPreferences sharedPreferencesHIGHP;
    SharedPreferences sharedPreferencesLOWP;
    SharedPreferences sharedPreferencesPULSE;
    SharedPreferences sharedPreferencesDATE;
    SharedPreferences sharedPreferencesTACH;

    private static final String HIGHP = "highPressure";
    private static final String LOWP = "lowPressure";
    private static final String PULSE = "pulse";
    private static final String DATE = "dateAndTime";
    private static final String TACH = "tachycardia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();

    }

    public void init() {

        Log.i(TAG, "Инициализация...");

        highPressure = findViewById(R.id.highPressure);
        lowPressure = findViewById(R.id.lowPressure);
        pulse = findViewById(R.id.pulse);
        dateAndTime = findViewById(R.id.dateAndTime);
        tachycardia = findViewById(R.id.tachycardia);

        sharedPreferencesHIGHP = getSharedPreferences("highPressurePrefs", MODE_PRIVATE);
        sharedPreferencesLOWP = getSharedPreferences("lowPressurePrefs", MODE_PRIVATE);
        sharedPreferencesPULSE = getSharedPreferences("pulsePrefs", MODE_PRIVATE);
        sharedPreferencesDATE = getSharedPreferences("datePrefs", MODE_PRIVATE);
        sharedPreferencesTACH = getSharedPreferences("tachPrefs", MODE_PRIVATE);

        highPressure.setText(sharedPreferencesHIGHP.getString(HIGHP, ""));
        lowPressure.setText(sharedPreferencesLOWP.getString(LOWP, ""));
        pulse.setText(sharedPreferencesPULSE.getString(PULSE, ""));
        dateAndTime.setText(sharedPreferencesDATE.getString(DATE, ""));
        tachycardia.setChecked(sharedPreferencesTACH.getBoolean(TACH, false));

        Log.i(TAG, "Инициализация завершена");

    }

    public void saveButtonClicked(View view) {

        Log.i(TAG, "Нажата кнопка 'Сохранить'");

        sharedPreferencesHIGHP.edit().putString(HIGHP, highPressure.getText().toString()).apply();
        sharedPreferencesLOWP.edit().putString(LOWP, lowPressure.getText().toString()).apply();
        sharedPreferencesPULSE.edit().putString(PULSE, pulse.getText().toString()).apply();
        sharedPreferencesDATE.edit().putString(DATE, dateAndTime.getText().toString()).apply();
        sharedPreferencesTACH.edit().putBoolean(TACH, tachycardia.isChecked()).apply();

        Toast.makeText(this, "Сохранено!", Toast.LENGTH_SHORT).show();

    }
}