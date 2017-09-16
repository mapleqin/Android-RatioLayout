/*
 * <pre>
 * Copyright 2015 The Android Open Source Project for Android-RatioLayout
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
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * author: Amphiaraus
 * since : 2017/9/13 上午10:39.
 */
public final class RatioLayoutDelegate<TARGET extends View & RatioMeasureDelegate> {

    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs) {
        return obtain(target, attrs, 0);
    }

    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs, int defStyleAttr) {
        return obtain(target, attrs, 0, 0);
    }

    @SuppressWarnings("unchecked")
    public static <TARGET extends View & RatioMeasureDelegate> RatioLayoutDelegate obtain(TARGET target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return new RatioLayoutDelegate(target, attrs, defStyleAttr, defStyleRes);
    }

    private final TARGET mRatioTarget;

    private RatioDatumMode mRatioDatumMode;
    private float mDatumWidth;
    private float mDatumHeight;
    private float mAspectRatio;
    private boolean mIsSquare;

    private int mWidthMeasureSpec, mHeightMeasureSpec;

    private RatioLayoutDelegate(TARGET target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mRatioTarget = target;
        TypedArray a = mRatioTarget.getContext().obtainStyledAttributes(attrs, R.styleable.ViewSizeCalculate, defStyleAttr, defStyleRes);
        mRatioDatumMode = RatioDatumMode.valueOf(a.getInt(R.styleable.ViewSizeCalculate_datumRatio, 0));
        mDatumWidth = a.getFloat(R.styleable.ViewSizeCalculate_widthRatio, mDatumWidth);
        mDatumHeight = a.getFloat(R.styleable.ViewSizeCalculate_heightRatio, mDatumHeight);
        mIsSquare = a.getBoolean(R.styleable.ViewSizeCalculate_isSquare, false);
        mAspectRatio = a.getFloat(R.styleable.ViewSizeCalculate_aspectRatio, mAspectRatio);
        a.recycle();
    }

    private RatioDatumMode shouldRatioDatumMode(ViewGroup.LayoutParams params) {
        if (mRatioDatumMode == null || mRatioDatumMode == RatioDatumMode.DATUM_AUTO) {
            if (params.width > 0 || shouldLinearParamsWidth(params)
                    || params.width == ViewGroup.LayoutParams.MATCH_PARENT) {
                return RatioDatumMode.DATUM_WIDTH;
            }
            if (params.height > 0 || shouldLinearParamsHeight(params)
                    || params.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                return RatioDatumMode.DATUM_HEIGHT;
            }
            return null;
        }
        return mRatioDatumMode;
    }

    private boolean shouldLinearParamsWidth(ViewGroup.LayoutParams params) {
        if (!(params instanceof LinearLayout.LayoutParams)) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) params;
        return layoutParams.width == 0 && layoutParams.weight > 0;
    }

    private boolean shouldLinearParamsHeight(ViewGroup.LayoutParams params) {
        if (!(params instanceof LinearLayout.LayoutParams)) {
            return false;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) params;
        return layoutParams.height == 0 && layoutParams.weight > 0;
    }

    public final void update(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthMeasureSpec = widthMeasureSpec;
        mHeightMeasureSpec = heightMeasureSpec;

        final RatioDatumMode mode = shouldRatioDatumMode(mRatioTarget.getLayoutParams());
        final int wp = mRatioTarget.getPaddingLeft() + mRatioTarget.getPaddingRight();
        final int hp = mRatioTarget.getPaddingTop() + mRatioTarget.getPaddingBottom();

        if (mode == RatioDatumMode.DATUM_WIDTH) {
            final int width = View.MeasureSpec.getSize(widthMeasureSpec);
            if (mIsSquare) {
                final int height = resolveSize(width - wp + hp, heightMeasureSpec);
                mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            } else if (mAspectRatio > 0) {
                final int height = resolveSize(Math.round((width - wp) / mAspectRatio + hp), heightMeasureSpec);
                mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            } else if (mDatumWidth > 0 && mDatumHeight > 0) {
                final int height = resolveSize(Math.round((width - wp) / mDatumWidth * mDatumHeight + hp), heightMeasureSpec);
                mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            }
        } else if (mode == RatioDatumMode.DATUM_HEIGHT) {
            final int height = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mIsSquare) {
                final int width = resolveSize(height - hp + wp, widthMeasureSpec);
                mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
            } else if (mAspectRatio > 0) {
                final int width = resolveSize(Math.round((height - hp) / mAspectRatio + wp), widthMeasureSpec);
                mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
            } else if (mDatumWidth > 0 && mDatumHeight > 0) {
                final int width = resolveSize(Math.round((height - hp) / mDatumHeight * mDatumWidth + wp), widthMeasureSpec);
                mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
            }
        }
    }

    public final int getWidthMeasureSpec() {
        return mWidthMeasureSpec;
    }

    public final int getHeightMeasureSpec() {
        return mHeightMeasureSpec;
    }

    private void requestLayout() {
        mRatioTarget.requestLayout();
    }

    private int resolveSize(int size, int measureSpec) {
        /*return View.resolveSize(size,measureSpec);*/
        return size;
    }

    public final void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight) {
        mRatioDatumMode = mode;
        mDatumWidth = datumWidth;
        mDatumHeight = datumHeight;
        requestLayout();
    }

    public final void setSquare(boolean square) {
        mIsSquare = square;
        requestLayout();
    }

    public final void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }
}
