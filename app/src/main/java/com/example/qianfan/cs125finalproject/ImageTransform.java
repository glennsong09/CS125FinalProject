package com.example.qianfan.cs125finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.widget.TextView;

import com.bachors.img2ascii.Img2Ascii;

public class ImageTransform {

    public MainActivity activity;

    public ImageTransform(MainActivity act) {
        activity = act;
    }

    public void convert() {
        //Bitmap image = BitmapFactory.decodeFile(filename);

        Bitmap bm=((BitmapDrawable)activity.getImageViewer().getDrawable()).getBitmap();

        new Img2Ascii()
                .bitmap(bm)
                .quality(1) // 1 - 5
                .color(true)
                .convert(new Img2Ascii.Listener() {
                    @Override
                    public void onProgress(int percentage) {
                        activity.getTextView().setText(String.valueOf(percentage) + " %");
                    }

                    @Override
                    public void onResponse(Spannable text) {
                        activity.getTextView().setText(text);
                    }
                });
    }

}