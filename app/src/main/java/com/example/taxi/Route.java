package com.example.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Route extends AppCompatActivity {

    private final String TAG = "Route";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        setContentView(R.layout.activity_route);

        Button buttonOk = findViewById(R.id.buttonOk);

        final TextView editText = findViewById(R.id.editText);
        final TextView editText2 = findViewById(R.id.editText2);
        final TextView editText3 = findViewById(R.id.editText3);
        final TextView editText4 = findViewById(R.id.editText4);
        final TextView editText5 = findViewById(R.id.editText5);
        final TextView editText6 = findViewById(R.id.editText6);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                String route = editText.getText().toString() + "\n" +
                        editText2.getText().toString() + "\n" +
                        editText3.getText().toString() + "\n" +
                        editText4.getText().toString() + "\n" +
                        editText5.getText().toString() + "\n" +
                        editText6.getText().toString() + "\n";

                intent.putExtra("route", route);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
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
}
