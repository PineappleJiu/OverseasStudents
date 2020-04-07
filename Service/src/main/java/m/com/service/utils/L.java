package m.com.service.utils;

import android.util.Log;
import m.com.service.BuildConfig;

/* @Describe: 日志调试文件 */

public class L {
    private static final String TAG = "gsj";
    private static boolean sDebug = BuildConfig.DEBUG;

    public static void d(String msg, Object... args){
        if(!sDebug){
            return;
        }
        Log.d(TAG,String.format(msg, args));
    }
}
