package com.example.aps.Pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.aps.R;

public class Pagers extends RelativeLayout {
    public Pagers(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);//連接頁面
        View view = inflater.inflate(R.layout.my_pagers , null);//取得頁面元件

        addView(view , ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //將元件放入ViewPager
    }
}
