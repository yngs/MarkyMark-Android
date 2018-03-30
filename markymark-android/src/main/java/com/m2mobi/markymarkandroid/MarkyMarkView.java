/*
 * Copyright (C) M2mobi BV - All Rights Reserved
 */

package com.m2mobi.markymarkandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.m2mobi.markymark.MarkyMark;

import java.util.List;

/**
 * Convenience view that can be used to display MarkDown
 */
public class MarkyMarkView extends LinearLayout {

    private MarkyMark<View> mMarkyMark;

    public MarkyMarkView(Context context) {
        super(context);
    }

    public MarkyMarkView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkyMarkView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public MarkyMarkView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Set the MarkyMark instance that will be used to parse the MarkDown content
     * @param pMarkyMark instance of MarkyMark that will be used
     */
    public void setMarkyMark(final MarkyMark<View> pMarkyMark) {
        mMarkyMark = pMarkyMark;
    }

    /**
     * Set the MarkDown that should be displayed in this view
     *
     * @param pMarkDownString The String that should be parsed and displayed
     */
    public void setMarkDown(final String pMarkDownString) {
        removeAllViews();

        if (mMarkyMark != null) {
            List<View> views = mMarkyMark.parseMarkDown(pMarkDownString);
            for (View view : views) {
                addView(view);
            }
        } else {
            throw new IllegalStateException("No instance of MarkyMark provided");
        }
    }
}
