package koo.loomis.com.baselibrary.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import koo.loomis.com.baselibrary.R;
import koo.loomis.com.baselibrary.activity.BaseActivity;
import koo.loomis.com.baselibrary.mvp.IBasePresenter;
import koo.loomis.com.baselibrary.test.util.ARouteUtil;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test.TestBaseActivity
 * @ClassName: TestBaseActivity
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 16:03
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 16:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = ARouteUtil.ROUTE_TEST_BASE_ACTIVITY)
public class TestBaseActivity extends BaseActivity {
    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.test_base_activity);
    }

    @Override
    protected IBasePresenter createPresenter() {
        return null;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData(Context mContext) {

    }
}
