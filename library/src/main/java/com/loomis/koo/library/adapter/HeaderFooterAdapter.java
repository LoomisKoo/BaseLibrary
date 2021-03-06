package com.loomis.koo.library.adapter;

import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import java.util.ArrayList;

/**
 * @param <G>
 * @author
 */
public class HeaderFooterAdapter<G> extends QuickDelegateAdapter<G> {
    HeaderFooterViewModel model;
    int                   viewType;

    public HeaderFooterAdapter(Context context, int viewType, int layoutResId, HeaderFooterViewModel footerViewModel, ArrayList list) {
        super(context, layoutResId, list);
        this.model = footerViewModel;
        this.viewType = viewType;
    }

    @Override
    protected void onSetItemData(BaseViewHolder holder, G item, int viewType, int position) {
        model.setData(holder, item);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper(1);
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }
}