package com.example.qianfan.cs125finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_PIC_REQUEST = 1888;
    ImageView imageViewer;

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
        imageViewer = (ImageView) findViewById(R.id.imageView01);


        /**
        Button btnOC = (Button) findViewById(R.id.openCamera);
        ImageView imageView = (ImageView) findViewById(R.id.imageView01);
               btnOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will open the camera.");
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });
         **/

        Button btnAI = (Button) findViewById(R.id.accessImages);
        btnAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CS125FinalProject", "Will access saved images.");
            }
        });
    }

    public void OpenCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewer.setImageBitmap(bitmap);
        }
    }

    public Context getContext() {
        return MainActivity.this;
    }
}
