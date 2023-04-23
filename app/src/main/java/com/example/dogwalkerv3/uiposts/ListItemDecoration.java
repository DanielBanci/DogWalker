package com.example.dogwalkerv3.uiposts;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceHeight;
    private int lateralSpace;

    public ListItemDecoration(int spaceHeight, int lateralSpace) {
        this.spaceHeight = spaceHeight;
        this.lateralSpace = lateralSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = spaceHeight;
        outRect.top = spaceHeight;
        outRect.left = lateralSpace;
        outRect.right = lateralSpace;
    }
}
