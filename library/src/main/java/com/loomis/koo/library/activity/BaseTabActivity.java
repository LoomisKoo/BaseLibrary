package com.loomis.koo.library.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.loomis.koo.library.R;
import com.loomis.koo.library.R2;
import com.loomis.koo.library.myinterface.ITabPagerView;

/**
 * @author koo
 */
public abstract class BaseTabActivity extends BaseActivity {
    protected ArrayList<String>        tabTitles;
    protected BasePagerAdapter         adapter;
    protected ArrayList<ITabPagerView> viewList;

    @BindView(R2.id.act_nav_tab_pager_tl_tab)
    TabLayout        actNavTabPagerTlTab;
    @BindView(R2.id.act_nav_tab_pager_vp)
    ViewPager        actNavTabPagerVp;
    @BindView(R2.id.act_nav_tab_pager_ll)
    ConstraintLayout actNavTabPagerLl;

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.test_base_activity_tab);
        ButterKnife.bind(this);
        tabTitles = getTabTitles();
        viewList = getViewList();
        if (tabTitles == null || viewList == null) {
            return;
        }

        for (int i = 0; i < tabTitles.size(); i++) {
            actNavTabPagerTlTab.addTab(actNavTabPagerTlTab.newTab()
                                                          .setText(tabTitles.get(i)));
        }

        actNavTabPagerTlTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                actNavTabPagerVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        actNavTabPagerVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actNavTabPagerTlTab.getTabAt(position)
                                   .select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        actNavTabPagerVp.setAdapter(adapter = new BasePagerAdapter());
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData(Context mContext) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.bind(this)
                   .unbind();
        super.onDestroy();
    }

    class BasePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position)
                                      .getContentView());
            viewList.get(position)
                    .onCreateView(BaseTabActivity.this);
            return viewList.get(position)
                           .getContentView();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    /**
     * 获取tab的title
     *
     * @return
     */
    protected abstract ArrayList<String> getTabTitles();

    /**
     * 获取每个tab的列表
     *
     * @return
     */
    protected abstract ArrayList<ITabPagerView> getViewList();
}
