package com.testactionbar.vincentzx.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tabs extends LinearLayout {
	private OnClickListener mClickListener;
	private String[] mTabNames;

	public void setmClickListener(OnClickListener mClickListener) {
		this.mClickListener = mClickListener;
	}

	public Tabs(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Tabs(Context context) {
		super(context);

	}

	public void addTabItems(Context context, String[] strings,OnClickListener clickListener) {
		this.mClickListener = clickListener;
		mTabNames = strings;
		for (int i = 0; i < mTabNames.length; i++) {
			View view = LayoutInflater.from(context).inflate(
					R.layout.layout_item_tabitem, null);
			LayoutParams layoutParams = new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1);
			view.setLayoutParams(layoutParams);
			((TextView) view.findViewById(R.id.tab_name)).setText(mTabNames[i]);
			((TextView) view.findViewById(R.id.tab_name))
					.setTextColor(getResources().getColor(
							i == 0 ? R.color.main_red_color
									: R.color.main_black_color));
			view.findViewById(R.id.tab_item_selected).setBackgroundColor(
					getResources().getColor(
							i == 0 ? R.color.main_red_color
									: R.color.tab_item_v_line_color));
			View tabItem = view.findViewById(R.id.tab_item);
			tabItem.setTag(mTabNames[i]);
			tabItem.setOnClickListener(mClickListener);
			addView(view);
		}
	}

	public void pageSelected(final int index) {
		for (int i = 0; i < mTabNames.length; i++) {
			View view = getChildAt(i);

			((TextView) view.findViewById(R.id.tab_name))
					.setTextColor(getResources().getColor(
							i == index ? R.color.main_red_color
									: R.color.main_black_color));
			view.findViewById(R.id.tab_item_selected).setBackgroundColor(
					getResources().getColor(
							i == index ? R.color.main_red_color
									: R.color.tab_item_v_line_color));
		}
	}
}
