package com.own.fitness.app.aputils;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {


    GestureDetector f847a;
    onItemClickListener mListener;

    public interface onItemClickListener {
        void OnItem(View view, int i);
    }

    public RecyclerItemClickListener(Context context, onItemClickListener onitemclicklistener) {
        this.mListener = onitemclicklistener;
        this.f847a = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.mListener == null || !this.f847a.onTouchEvent(motionEvent)) {
            return false;
        }
        this.mListener.OnItem(findChildViewUnder, recyclerView.getChildAdapterPosition(findChildViewUnder));
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        Log.d("", "sd");
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Log.d("", "sd");
    }
}
