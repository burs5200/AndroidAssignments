package com.example.androidassignments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class StartActivity extends AppCompatActivity {
    private final String ACTIVITY_NAME = "StartActivity";

    @SuppressWarnings("unused")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button bttn = findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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

    @SuppressWarnings("unused")
    public void sendToListItems(View view) {
        Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
        startActivityForResult(intent, 10);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
            if (resultCode == ListItemsActivity.RESULT_OK) {
                assert data != null;
                String messagePassed = data.getStringExtra("Response");
                if (messagePassed != null) {
                    Toast toast = Toast.makeText(this, "ListItemsActivity passed: " + messagePassed, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }

    }

    @SuppressWarnings("unused")
    public void LogChat(View view) {

        Log.i(ACTIVITY_NAME, "User Clicked Start Chat");
        Intent intent = new Intent(StartActivity.this, ChatWindow.class);
        startActivity(intent);

    }
}
