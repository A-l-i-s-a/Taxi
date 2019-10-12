package com.example.taxi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity implements View.OnClickListener {

    Button buttonCallTaxi;
    Button buttonSetRoute;
    TextView textViewRoute;

    private final String TAG = "UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_user_info);

        Bundle extras = getIntent().getExtras();

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPhone = findViewById(R.id.textViewPhone);
        textViewRoute = findViewById(R.id.textViewRoute);

        buttonCallTaxi = findViewById(R.id.buttonCallTaxi);
        buttonCallTaxi.setVisibility(View.GONE);
        buttonCallTaxi.setOnClickListener(this);

        buttonSetRoute = findViewById(R.id.buttonSetRoute);
        buttonSetRoute.setOnClickListener(this);

        if (extras != null) {
            String name = extras.getString("name") + " " + extras.getString("surname");
            textViewName.setText(name);
            textViewPhone.setText(extras.getString("phone"));
        }

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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonCallTaxi:
                Toast.makeText(getApplicationContext(), "Такси успешно отправленно", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSetRoute:
                Intent intent = new Intent("route");
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String route = data.getStringExtra("route");
        textViewRoute.setText(route);
        buttonCallTaxi.setVisibility(View.VISIBLE);
    }
}
