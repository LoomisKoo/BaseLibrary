package koo.loomis.com.baselibrary.test.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test.util
 * @ClassName: BuildTypeUtil
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 16:53
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 16:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BuildTypeUtil {
    //判断当前应用是否是debug状态
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
        catch (Exception e) {
            return false;
        }
    }
}
