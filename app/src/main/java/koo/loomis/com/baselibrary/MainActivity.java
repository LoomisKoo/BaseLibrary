package koo.loomis.com.baselibrary;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import koo.loomis.com.baselibrary.test.util.ARouteUtil;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnBaseActivity)
    Button btnBaseActivity;
    @BindView(R.id.btnBaseListActivity)
    Button btnBaseListActivity;
    @BindView(R.id.btnBaseTabActivity)
    Button btnBaseTabActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnBaseActivity.setOnClickListener(v -> testBaseActivity());
        btnBaseListActivity.setOnClickListener(v -> testBaseListActivity());
        btnBaseTabActivity.setOnClickListener(v -> testBaseTabListActivity());
    }

    private void testBaseActivity() {
        ARouteUtil.startActivity(this, ARouteUtil.ROUTE_TEST_BASE_ACTIVITY);
    }

    private void testBaseListActivity() {
        ARouteUtil.startActivity(this, ARouteUtil.ROUTE_TEST_BASE_LIST_ACTIVITY);
    }

    private void testBaseTabListActivity() {
        ARouteUtil.startActivity(this, ARouteUtil.ROUTE_TEST_BASE_TAB_LIST_ACTIVITY);
    }
}
