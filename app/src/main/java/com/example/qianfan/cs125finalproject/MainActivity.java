package com.example.qianfan.cs125finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCI = (Button) findViewById(R.id.convertASCII);
        btnCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will convert image to ASCII.");
            }
        });
        Button btnSI = (Button) findViewById(R.id.savePicture);
        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will save the converted picture.");
            }
        });
        Button btnOC = (Button) findViewById(R.id.openCamera);
        btnOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will open the camera.");
            }
        });
        Button btnAI = (Button) findViewById(R.id.accessImages);
        btnAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will access saved images.");
            }
        });
    }
}
