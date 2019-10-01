package com.example.androidassignments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPref = LoginActivity.this.getPreferences(Context.MODE_PRIVATE);

        String emailString = "email@domain.com";
        EditText emailText = findViewById(R.id.emailText);
        String email = sharedPref.getString(getString(R.string.app_name), emailString);
        emailText.setText(email);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        Log.i(ACTIVITY_NAME, "In onPause()");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.i(ACTIVITY_NAME, "In onStop()");
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();

    }

    public void saveEmail(@SuppressWarnings("unused") View view) {
        EditText emailText = findViewById(R.id.emailText);
        String emailString = emailText.getText().toString();
        SharedPreferences sharedPref = LoginActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.i(ACTIVITY_NAME, emailString);
        editor.putString(getString(R.string.app_name), emailString);
        editor.apply();
        Intent intent = new Intent(LoginActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
