package com.example.saimarestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, contact, experience;
    RadioGroup method;
    RadioButton dineIn, takeAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.txtName);
        contact = (EditText) findViewById(R.id.txtContact);
        experience = (EditText) findViewById(R.id.txtExperience);
        method = (RadioGroup) findViewById(R.id.txtMethod);
        dineIn = (RadioButton) findViewById(R.id.dineIn);
        takeAway = (RadioButton) findViewById(R.id.takeAway);

        if (savedInstanceState != null) {

            name.setText(savedInstanceState.getString("NAME"));
            contact.setText(savedInstanceState.getString("CONTACT"));
            experience.setText(savedInstanceState.getString("EXPERIENCE"));
            if (method.getCheckedRadioButtonId() == R.id.dineIn) {
                dineIn.setChecked(true);
            } else {
                takeAway.setChecked(true);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString("NAME", name.getText().toString());
        savedInstanceState.putString("CONTACT", contact.getText().toString());
        savedInstanceState.putString("EXPERIENCE", experience.getText().toString());
        savedInstanceState.putInt("METHOD", method.getCheckedRadioButtonId());

        super.onSaveInstanceState(savedInstanceState);
    }
}