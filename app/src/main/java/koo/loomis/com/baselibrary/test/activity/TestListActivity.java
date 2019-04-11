package koo.loomis.com.baselibrary.test.activity;

import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import androidx.recyclerview.widget.RecyclerView;
import koo.loomis.com.baselibrary.R;
import com.loomis.koo.library.activity.BaseListActivity;
import com.loomis.koo.library.adapter.BaseViewHolder;
import com.loomis.koo.library.adapter.QuickDelegateAdapter;
import com.loomis.koo.library.mvp.IBasePresenter;
import koo.loomis.com.baselibrary.test.util.ARouteUtil;
import koo.loomis.com.baselibrary.test.viewholder.TestListVH;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test
 * @ClassName: TestListActivity
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 13:54
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 13:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Route(path = ARouteUtil.ROUTE_TEST_BASE_LIST_ACTIVITY)
public class TestListActivity extends BaseListActivity {
    @Override
    protected void getData(int page, int pageSize) {
        adapter.add("test1");
        adapter.add("test2");
        adapter.add("test3");
        adapter.add("test4");
        adapter.add("test5");
        adapter.add("test6");
        stopRefresh();
    }

    @Override
    protected QuickDelegateAdapter getAdapter() {

        return new QuickDelegateAdapter<String>(this, 0) {
            @Override
            protected void onSetItemData(BaseViewHolder holder, String item, int viewType, int position) {
                ((TestListVH) holder).setData(item);
            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new LinearLayoutHelper();
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TestListVH vh = new TestListVH(TestListActivity.this, parent, R.layout.test_item_list);
                return vh;
            }
        };
    }

    @Override
    protected IBasePresenter createPresenter() {
        return null;
    }


}
