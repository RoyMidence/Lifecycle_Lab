package com.example.lifecyclelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetDataActivity extends AppCompatActivity {
    EditText editTextEnterData;
    Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);

        editTextEnterData = findViewById(R.id.editTextEnterData);
        buttonReturn = findViewById(R.id.buttonReturn);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get shared preferences object
                Context context = SetDataActivity.this;
                SharedPreferences sp =
                        PreferenceManager.getDefaultSharedPreferences(context);

                // Get the shared preferences editor
                SharedPreferences.Editor editor = sp.edit();

                // Set preference values to save
                editor.putString("data", editTextEnterData.getText().toString());

                // Actually save values
                editor.apply();

                finish();
            }
        });

    }
}