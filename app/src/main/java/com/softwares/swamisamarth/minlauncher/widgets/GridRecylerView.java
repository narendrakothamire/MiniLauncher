package com.softwares.swamisamarth.minlauncher.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Narendra on 9/5/2016.
 */
public class GridRecylerView extends RecyclerView {

    public GridRecylerView(Context context) {
        super(context);
    }

    public GridRecylerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GridRecylerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }
}
