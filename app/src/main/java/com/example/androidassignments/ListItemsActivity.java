package com.example.androidassignments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@SuppressWarnings("unused")
public class ListItemsActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private final String ACTIVITY_NAME = "ListItemsActivity";

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
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.i(ACTIVITY_NAME, "Inside If");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        Log.i(ACTIVITY_NAME, "After If");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
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

    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageButton = findViewById(R.id.imageButton);
            imageButton.setImageBitmap(imageBitmap);
        }
    }

    public void clickPicture(View view) {
        dispatchTakePictureIntent();
    }

    public void setOnCheckedChange(View view) {
        Switch swch = findViewById(R.id.switch1);
        CharSequence text;
        int duration;
        if (swch.isChecked()) {
            text = "Switch is On";
            duration = Toast.LENGTH_SHORT;
        } else {
            text = "Switch is OFF";
            duration = Toast.LENGTH_LONG;
        }
        Toast toast = Toast.makeText(this, text, duration); //this is the ListActivity
        toast.show(); //display your message box

    }

    @SuppressWarnings("unused")
    public void OnCheckedChanged(View view) {
        CheckBox ckBox = findViewById(R.id.checkBox);
        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("Response", "Here is my response");

                        setResult(ListItemsActivity.RESULT_OK, resultIntent);
                        finish();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .show();

    }
}
