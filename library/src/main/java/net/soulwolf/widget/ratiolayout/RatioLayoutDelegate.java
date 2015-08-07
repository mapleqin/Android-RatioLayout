/**
 * <pre>
 * Copyright 2015 Soulwolf Ching
 * Copyright 2015 The Android Open Source Project for xiaodaow3.0-branche
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.ratiolayout;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * author: Soulwolf Created on 2015/7/26 12:34.
 * email : Ching.Soulwolf@gmail.com
 */
public final class RatioLayoutDelegate<TARGET extends View & RatioMeasureDelegate> {

    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs) {
        return obtain(target,attrs,0);
    }

    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs, int defStyleAttr) {
        return obtain(target,attrs,0,0);
    }

    @SuppressWarnings("unchecked")
    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return new RatioLayoutDelegate(target,attrs,defStyleAttr,defStyleRes);
    }

    private final TARGET mRatioMeasureDelegate;

    private RatioDatumMode mRatioDatumMode;

    private float mDatumWidth = 0.0f;

    private float mDatumHeight = 0.0f;

    private int mWidthMeasureSpec, mHeightMeasureSpec;

    private RatioLayoutDelegate(TARGET target, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        this.mRatioMeasureDelegate = target;
        TypedArray typedArray = mRatioMeasureDelegate.getContext().obtainStyledAttributes(attrs, R.styleable.ViewSizeCalculate, defStyleAttr, defStyleRes);
        if(typedArray != null){
            int datum = typedArray.getInt(R.styleable.ViewSizeCalculate_datumRatio, 0);
            if(datum == 1){
                mRatioDatumMode = RatioDatumMode.DATUM_WIDTH;
            }else if(datum == 2){
                mRatioDatumMode = RatioDatumMode.DATUM_HEIGHT;
            }
            mDatumWidth = typedArray.getFloat(R.styleable.ViewSizeCalculate_widthRatio, mDatumWidth);
            mDatumHeight = typedArray.getFloat(R.styleable.ViewSizeCalculate_heightRatio, mDatumHeight);
            typedArray.recycle();
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mWidthMeasureSpec = widthMeasureSpec;
        this.mHeightMeasureSpec = heightMeasureSpec;
        if(mRatioDatumMode != null && mDatumWidth != 0 && mDatumHeight != 0){
            mRatioMeasureDelegate.setDelegateMeasuredDimension(View.getDefaultSize(0, mWidthMeasureSpec),
                    View.getDefaultSize(0, mHeightMeasureSpec));
            int measuredWidth = mRatioMeasureDelegate.getMeasuredWidth();
            int measuredHeight = mRatioMeasureDelegate.getMeasuredHeight();
            if(mRatioDatumMode == RatioDatumMode.DATUM_WIDTH){
                measuredHeight = (int) (measuredWidth / mDatumWidth * mDatumHeight);
            }else {
                measuredWidth = (int) (measuredHeight / mDatumHeight * mDatumWidth);
            }
            mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, View.MeasureSpec.EXACTLY);
            mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, View.MeasureSpec.EXACTLY);
        }
    }

    public int getWidthMeasureSpec() {
        return mWidthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return mHeightMeasureSpec;
    }

    public void setRatio(RatioDatumMode mode,float datumWidth,float datumHeight){
        if(mode == null){
            throw new IllegalArgumentException("RatioDatumMode == null");
        }
        this.mRatioDatumMode = mode;
        this.mDatumWidth = datumWidth;
        this.mDatumHeight = datumHeight;
        this.mRatioMeasureDelegate.requestLayout();
    }
}
