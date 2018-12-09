package com.example.qianfan.cs125finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.widget.TextView;

import com.bachors.img2ascii.Img2Ascii;

public class ImageTransform {

    public MainActivity activity;
    TextView textView = new TextView(activity.getContext());

    public ImageTransform(MainActivity act) {
        activity = act;
    }

    public void convert() {
        Bitmap image = BitmapFactory.decodeFile(filename);

        new Img2Ascii()
                .bitmap(image)
                .quality(1) // 1 - 5
                .color(true)
                .convert(new Img2Ascii.Listener() {
                    @Override
                    public void onProgress(int percentage) {
                        textView.setText(String.valueOf(percentage) + " %");
                    }

                    @Override
                    public void onResponse(Spannable text) {
                        textView.setText(text);
                    }
                });
    }

}
