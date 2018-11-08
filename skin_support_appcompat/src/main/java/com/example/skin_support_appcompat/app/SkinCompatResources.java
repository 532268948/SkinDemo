package com.example.skin_support_appcompat.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;

/**
 * author: tianhuaye
 * date:   2018/11/8 14:45
 * description:
 */
public class SkinCompatResources {

    private static volatile SkinCompatResources sInstance;
    private Resources mResources;
    private boolean isDefaultSkin = true;

    public static SkinCompatResources getInstance() {
        if (sInstance == null) {
            synchronized (SkinCompatResources.class) {
                if (sInstance == null) {
                    sInstance = new SkinCompatResources();
                }
            }
        }
        return sInstance;
    }

    public static ColorStateList getColorStateList(Context context, int resId) {
        return getInstance().getSkinColorStateList(context, resId);
    }

    private ColorStateList getSkinColorStateList(Context context, int resId) {

        if (!isDefaultSkin) {
            int targetResId = getTargetResId(context, resId);
            if (targetResId != 0) {
                return mResources.getColorStateList(targetResId);
            }
        }
        return context.getResources().getColorStateList(resId);
    }

    public int getTargetResId(Context context, int resId) {
        try {
            String resName = null;
            String type = context.getResources().getResourceTypeName(resId);
            return mResources.getIdentifier(resName, type, mSkinPkgName);
        } catch (Exception e) {
            // 换肤失败不至于应用崩溃.
            return 0;
        }
    }
}
