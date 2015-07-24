package com.pluslibrary.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class PluaNanumTextView extends TextView {

    public PluaNanumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Typeface tf = Typeface.createFromAsset(context.getAssets(), "nanum.ttf");
        //this.setTypeface(tf);
    }

    public PluaNanumTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //Typeface tf = Typeface.createFromAsset(context.getAssets(), "nanum.ttf");
        //this.setTypeface(tf);
    }

    public PluaNanumTextView(Context context) {
        super(context);
        //Typeface tf = Typeface.createFromAsset(context.getAssets(), "nanum.ttf");
        //this.setTypeface(tf);
    }

}