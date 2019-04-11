package koo.loomis.com.baselibrary.test.activity;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;

import koo.loomis.com.baselibrary.activity.BaseTabActivity;
import koo.loomis.com.baselibrary.mvp.IBasePresenter;
import koo.loomis.com.baselibrary.myinterface.ITabPagerView;
import koo.loomis.com.baselibrary.test.TestListView;
import koo.loomis.com.baselibrary.test.util.ARouteUtil;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test.activity
 * @ClassName: TestTabActivity
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 17:02
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 17:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = ARouteUtil.ROUTE_TEST_BASE_TAB_LIST_ACTIVITY)
public class TestTabListActivity extends BaseTabActivity {
    @Override
    protected ArrayList<String> getTabTitles() {
        ArrayList testList = new ArrayList();
        testList.add("title1");
        testList.add("title2");
        testList.add("title3");
        return testList;
    }

    @Override
    protected ArrayList<ITabPagerView> getViewList() {
        ArrayList<ITabPagerView> viewList = new ArrayList<>();

        viewList.add(new TestListView(this, 0));
        viewList.add(new TestListView(this, 1));
        viewList.add(new TestListView(this, 2));
        return viewList;
    }

    @Override
    protected IBasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
