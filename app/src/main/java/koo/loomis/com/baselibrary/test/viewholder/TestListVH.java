package koo.loomis.com.baselibrary.test.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import koo.loomis.com.baselibrary.R;
import koo.loomis.com.baselibrary.adapter.BaseViewHolder;

/**
 * @ProjectName: BaseLibrary
 * @Package: koo.loomis.com.baselibrary.test
 * @ClassName: TestListVH
 * @Description: java类作用描述
 * @Author: koo
 * @CreateDate: 2019/4/11 14:31
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 14:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestListVH extends BaseViewHolder {
    @BindView(R.id.tvContent)
    TextView tvContent;

    public TestListVH(Context context, ViewGroup parent, int layoutId) {
        super(context, parent, layoutId);
    }

    public void setData(String content) {
        tvContent.setText(content);
    }
}
