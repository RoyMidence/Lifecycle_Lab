package com.example.lifecyclelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextReceivedData;
    Button buttonSwitchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextReceivedData = findViewById(R.id.editTextReceivedData);
        buttonSwitchActivity = findViewById(R.id.buttonSwitchActivity);

        buttonSwitchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SetDataActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        // Get values from shared preferences
        editTextReceivedData.setText(sp.getString("data", "NO_DATA_SET"));
    }
}