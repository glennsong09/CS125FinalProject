package com.example.qianfan.cs125finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
                BitmapDrawable drawable = (BitmapDrawable) imageViewer.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                /**
                File sdCardDirectory = Environment.getExternalStorageDirectory();
                File image = new File(sdCardDirectory, "download.png");
                */
                File image = new File(v.getContext().getExternalCacheDir(),"test.png");
                boolean success = false;
                FileOutputStream outStream;
                try {
                    outStream = new FileOutputStream(image);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                    outStream.flush();
                    outStream.close();
                    success = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnOC = (Button) findViewById(R.id.openCamera);
        imageViewer = (ImageView) findViewById(R.id.imageView01);

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
