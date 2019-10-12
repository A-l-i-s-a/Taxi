package com.example.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sPref;

    EditText phone;
    EditText name;
    EditText surname;

    Button button;

    final String SAVED_PHONE = "saved_phone";
    final String SAVED_NAME = "saved_name";
    final String SAVED_SURNAME = "saved_surname";
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.editTextPhone);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserInfo.class);
                intent.putExtra("phone", phone.getText().toString());
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("surname", surname.getText().toString());

                startActivity(intent);
            }
        });
        loadData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
        saveData();
    }


    void saveData() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putString(SAVED_PHONE, phone.getText().toString());
        ed.putString(SAVED_NAME, name.getText().toString());
        ed.putString(SAVED_SURNAME, surname.getText().toString());

        ed.apply();
    }

    void loadData() {
        sPref = getPreferences(MODE_PRIVATE);

        phone.setText(sPref.getString(SAVED_PHONE, ""));
        name.setText(sPref.getString(SAVED_NAME, ""));
        surname.setText(sPref.getString(SAVED_SURNAME, ""));

        button.setText("Войти");
    }
}
