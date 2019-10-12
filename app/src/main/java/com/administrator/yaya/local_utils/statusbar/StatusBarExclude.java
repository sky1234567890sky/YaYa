package com.administrator.yaya.local_utils.statusbar;

import android.os.Build;

/**
 * @author sky
 * @version 0.5
 * @since 0.5
 */
public class StatusBarExclude {
    static boolean exclude = false;

    public static void excludeIncompatibleFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar");
        } catch (NoSuchMethodException e) {
            exclude |= Build.BRAND.contains("Meizu");
        }
    }
}
