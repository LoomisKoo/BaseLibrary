package koo.loomis.com.baselibrary.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import koo.loomis.com.baselibrary.R;
import koo.loomis.com.baselibrary.adapter.BaseViewHolder;
import koo.loomis.com.baselibrary.adapter.QuickDelegateAdapter;
import koo.loomis.com.baselibrary.myinterface.ITabPagerView;
import koo.loomis.com.baselibrary.view.BaseListView;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test
 * @ClassName: TestListView
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 17:09
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 17:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestListView extends BaseListView<String> implements ITabPagerView {
    ArrayList<String> testArrayList;
    private int listType;

    public TestListView(Context context, int listType) {
        super(context);
        this.listType = listType;
    }

    @Override
    protected QuickDelegateAdapter getAdapter() {
        return new QuickDelegateAdapter<String>(getContext(), R.layout.test_item_base_tab_list) {
            @Override
            protected void onSetItemData(BaseViewHolder holder, String item, int viewType, int position) {
                holder.setText(R.id.tvItem, item);
            }

            @Override
            public LayoutHelper onCreateLayoutHelper() {
                return new LinearLayoutHelper();
            }

            @Override
            protected RecyclerView.ViewHolder onGetViewHolder(ViewGroup parent, int viewType) {
                return super.onGetViewHolder(parent, viewType);
            }
        };
    }

    @Override
    protected void getData(int page, int pageSize) {
        stopRefresh();
        switch (listType) {
            case 0:
                testArrayList.add(new String("k1"));
                break;
            case 1:
                testArrayList.add(new String("k2"));
                testArrayList.add(new String("k2"));
                break;
            case 2:
                testArrayList.add(new String("k3"));
                testArrayList.add(new String("k3"));
                testArrayList.add(new String("k3"));
                break;
            default:
                break;
        }
        adapter.replaceAll(testArrayList);
    }

    @Override
    public View getContentView() {
        return this;
    }

    @Override
    public void onCreateView(Context context) {
        setRefreshEnable(true);
        setLoadMoreEnable(true);
        testArrayList = new ArrayList<>();
    }
}