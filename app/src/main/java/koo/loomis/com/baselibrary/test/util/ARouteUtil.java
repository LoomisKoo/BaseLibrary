package koo.loomis.com.baselibrary.test.util;

import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test.util
 * @ClassName: ARouteUtil
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 13:57
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 13:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ARouteUtil {
    public final static String ROUTE_TEST_BASE_LIST_ACTIVITY = "/test/base_list_activity";
    public final static String ROUTE_TEST_BASE_ACTIVITY      = "/test/base_activity";
    public final static String ROUTE_TEST_BASE_TAB_LIST_ACTIVITY      = "/test/base_tab_list_activity";

    public static void startActivity(Context context, String route) {
        ARouter.getInstance()
               .build(route)
               .navigation(context);
    }

    public static void startActivity(String route) {
        ARouter.getInstance()
               .build(route)
               .navigation();
    }
}
