package com.own.fitness.app.aputils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
     boolean enableScrolling = true;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private boolean scrollingEnabled() {
        return this.enableScrolling;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (scrollingEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (scrollingEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScrolling(boolean z) {
        this.enableScrolling = z;
    }
}
