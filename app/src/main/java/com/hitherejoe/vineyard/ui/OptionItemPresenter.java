package com.hitherejoe.vineyard.ui;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.hitherejoe.vineyard.data.model.Option;


public class OptionItemPresenter extends Presenter {
    private static int GRID_ITEM_WIDTH = 350;
    private static int GRID_ITEM_HEIGHT = 400;

    private Context mContext;

    public OptionItemPresenter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        OptionCardView optionCardView = new OptionCardView(parent.getContext());
        return new ViewHolder(optionCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        //((GridItemView) viewHolder.view).setText((String) item);
        if (item instanceof Option) {
            Option option = (Option) item;
            OptionCardView optionView = (OptionCardView) viewHolder.view;

            if (!option.mTitle.equals(null)) {
                optionView.setMainImageDimensions(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT);
                optionView.setOptionTitleText(option.mTitle);
                String value = option.value;
                if (value != null) optionView.setOptionValueText(option.value);
                Context context = viewHolder.view.getContext();
                optionView.setOptionIcon(ContextCompat.getDrawable(context, option.iconResource));
            }

        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}