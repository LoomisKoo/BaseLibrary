package koo.loomis.com.baselibrary;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import koo.loomis.com.baselibrary.test.util.BuildTypeUtil;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary
 * @ClassName: BaseApplication
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 14:05
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 14:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        boolean isDebug = BuildTypeUtil.isApkInDebug(this);
        if (isDebug) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }
}
