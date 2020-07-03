package com.example.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;

/**
 * Created by bian on 2020/7/3 16:04.
 */
public class FlowLayout1 extends ViewGroup {

    private int mHorizontalSpacing = dp2px(16); //每个item横向间距
    private int mVerticalSpacing = dp2px(8); //每个item横向间距

    public FlowLayout1(Context context) {
        super(context);
    }

    public FlowLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
