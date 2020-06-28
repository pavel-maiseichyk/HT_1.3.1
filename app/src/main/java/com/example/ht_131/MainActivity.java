package com.example.ht_131;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText age;

    private SharedPreferences sharedPreferencesNAME;
    private SharedPreferences sharedPreferencesAGE;

    private static final String TAG = "myApp";
    private static final String NAME = "name";
    private static final String AGE = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init() {

        Log.i(TAG, "Инициализация...");

        name = findViewById(R.id.inputName);
        age = findViewById(R.id.inputAge);

        sharedPreferencesNAME = getSharedPreferences("NamePrefs", MODE_PRIVATE);
        sharedPreferencesAGE = getSharedPreferences("AgePrefs", MODE_PRIVATE);

        name.setText(sharedPreferencesNAME.getString(NAME, ""));
        age.setText(sharedPreferencesAGE.getString(AGE, ""));

        Log.i(TAG, "Инициализация завершена");

    }


    public void saveButtonClicked(View view) {

        Log.i(TAG, "Нажата кнопка 'Сохранить'");

        String nameText = name.getText().toString();
        String ageText = age.getText().toString();

        sharedPreferencesNAME.edit().putString(NAME, nameText).apply();
        sharedPreferencesAGE.edit().putString(AGE, ageText).apply();

        Toast.makeText(this, "Сохранено!", Toast.LENGTH_SHORT).show();

    }

    public void toValuesButtonClicked(View view) {

        Log.i(TAG, "Нажата кнопка 'Показатели'");

        Intent intent = new Intent(MainActivity.this, Values.class);
        startActivity(intent);

    }


    public void toPressureButtonClicked(View view) {

        Log.i(TAG, "Нажата кнопка 'Давление'");

        Intent intent = new Intent(MainActivity.this, Pressure.class);
        startActivity(intent);

    }
}


