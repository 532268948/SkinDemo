package com.example.skin_support_appcompat.app;

import android.content.Context;
import android.content.res.Resources;

/**
 * author: tianhuaye
 * date:   2018/11/7 16:31
 * description:
 */
public class SkinManager {

    private static SkinManager mInstance;
    private Context mContext;
    private Resources mResources;

    public static SkinManager getInstance() {
        if (mInstance == null) {
            synchronized (SkinManager.class) {
                if (mInstance == null) {
                    mInstance = new SkinManager();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public Resources getmResources() {
        return this.mResources;
    }
}
