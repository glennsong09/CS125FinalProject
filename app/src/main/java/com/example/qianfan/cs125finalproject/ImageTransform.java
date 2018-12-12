package com.example.qianfan.cs125finalproject;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;

import com.bachors.img2ascii.Img2Ascii;

public class ImageTransform {

    public MainActivity activity;

    public ImageTransform(MainActivity act) {
        activity = act;
    }

    public void convert() {
        Bitmap bm=((BitmapDrawable)activity.getImageViewer().getDrawable()).getBitmap();

        new Img2Ascii()
                .bitmap(bm)
                .quality(1) // 1 - 5
                .color(false)
                .convert(new Img2Ascii.Listener() {
                    @Override
                    public void onProgress(int percentage) {
                        activity.getTextView().setText(String.valueOf(percentage) + " %");
                    }

                    @Override
                    public void onResponse(Spannable text) {

                        text.setSpan(new ScaleXSpan(2f), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        //pixel 2 or xl
                        text.setSpan(new RelativeSizeSpan(0.2f), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        //s8+
                        //text.setSpan(new RelativeSizeSpan(0.11f), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        text.setSpan(new TypefaceSpan("monospace"), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        activity.getTextView().setText(text);
                        Log.i("CS125FinalProject", text.toString());
                    }
                });
    }

}