package com.example.skin_support_appcompat.helper;

/**
 * author: tianhuaye
 * date:   2018/11/7 15:03
 */

public abstract class SkinCompatHelper {

    protected static final String SYSTEM_ID_PREFIX = "1";
    public static final int INVALID_ID = 0;

    final static public int checkResourceId(int resId) {
        String hexResId = Integer.toHexString(resId);
        return hexResId.startsWith(SYSTEM_ID_PREFIX) ? INVALID_ID : resId;
    }

    abstract public void applySkin();
}
