package com.example.skin_support_appcompat.helper.impl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.skin_support_appcompat.R;
import com.example.skin_support_appcompat.app.SkinCompatResources;
import com.example.skin_support_appcompat.helper.SkinCompatHelper;

/**
 * author: tianhuaye
 * date:   2018/11/7 15:06
 */
public class SkinCompatTextHelper extends SkinCompatHelper {

    private static final String TAG = SkinCompatTextHelper.class.getSimpleName();

//    protected int mDrawableBottomResId = INVALID_ID;
//    protected int mDrawableLeftResId = INVALID_ID;
//    protected int mDrawableRightResId = INVALID_ID;
//    protected int mDrawableTopResId = INVALID_ID;
    private int mTextColorResId = INVALID_ID;
    private int mTextColorHintResId = INVALID_ID;

    final TextView mView;

    public static SkinCompatTextHelper create(TextView textView) {
        if (Build.VERSION.SDK_INT >= 17) {
            return null;
        }
        return new SkinCompatTextHelper(textView);
    }

    private SkinCompatTextHelper(TextView view) {
        mView = view;
    }

    /**
     * 读取控件属性
     * @param attrs
     * @param defStyleAttr
     */
    public void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        final Context context = mView.getContext();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SkinTextAppearance, defStyleAttr, 0);
        if (a.hasValue(R.styleable.SkinTextAppearance_android_textColor)) {
            mTextColorResId = a.getResourceId(R.styleable.SkinTextAppearance_android_textColor, INVALID_ID);
        }
        if (a.hasValue(R.styleable.SkinTextAppearance_android_textColorHint)) {
            mTextColorHintResId = a.getResourceId(
                    R.styleable.SkinTextAppearance_android_textColorHint, INVALID_ID);
        }
        a.recycle();
        applySkin();
    }

    private void applyTextColorResource() {
        mTextColorResId = checkResourceId(mTextColorResId);
        if (mTextColorResId != INVALID_ID) {
            try {
                ColorStateList color = SkinCompatResources.getColorStateList(mView.getContext(), mTextColorResId);
                mView.setTextColor(color);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void applySkin() {
        applyTextColorResource();
    }


}
