package com.example.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
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

        //先度量孩子
        for(int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);

            LayoutParams layoutParams = childView.getLayoutParams();
            int childWidthMeasureSpace = getChildMeasureSpace(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), layoutParams.width);
            int childHeightMeasureSpace = getChildMeasureSpace(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutParams.height);
            childView.measure(childWidthMeasureSpace, childHeightMeasureSpace);
        }








        //度量自己
//        setMeasuredDimension();
    }

    private int getChildMeasureSpace(int measureSpace, int padding, int childDimension) {
        int parentWidthSize = Math.max(0, MeasureSpec.getSize(measureSpace) - padding);
        int childMode = 0;
        int childSize = 0;
        switch (MeasureSpec.getMode(measureSpace)) {
            case MeasureSpec.EXACTLY:
                if (childDimension == LayoutParams.MATCH_PARENT) {
                    childMode = MeasureSpec.EXACTLY;
                    childSize = parentWidthSize;
                }
                if (childDimension == LayoutParams.WRAP_CONTENT) {
                    childMode = MeasureSpec.EXACTLY;
                    childSize = parentWidthSize;
                }
                if (childDimension >= 0) {
                    childMode = MeasureSpec.EXACTLY;
                    childSize = childDimension;
                }
            case MeasureSpec.AT_MOST:
                if (childDimension == LayoutParams.MATCH_PARENT) {
                    childMode = MeasureSpec.AT_MOST;
                    childSize = parentWidthSize;
                }
                if (childDimension == LayoutParams.WRAP_CONTENT) {
                    childMode = MeasureSpec.AT_MOST;
                    childSize = parentWidthSize;
                }
                if (childDimension >= 0) {
                    childMode = MeasureSpec.EXACTLY;
                    childSize = childDimension;
                }
            case MeasureSpec.UNSPECIFIED:
                if (childDimension == LayoutParams.MATCH_PARENT) {
                    childMode = MeasureSpec.UNSPECIFIED;
                    childSize = 0;
                }
                if (childDimension == LayoutParams.WRAP_CONTENT) {
                    childMode = MeasureSpec.UNSPECIFIED;
                    childSize = 0;
                }
                if (childDimension >= 0) {
                    childMode = MeasureSpec.EXACTLY;
                    childSize = childDimension;
                }
        }
        return MeasureSpec.makeMeasureSpec(childSize, childMode);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
