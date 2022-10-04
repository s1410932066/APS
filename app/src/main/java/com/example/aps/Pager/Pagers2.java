package com.example.aps.Pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.aps.R;

public class Pagers2 extends RelativeLayout {

    public Pagers2(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);//連接頁面
        View view2 = inflater.inflate(R.layout.my_pagers2 , null);//取得頁面元件

        addView(view2 , ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //將元件放入ViewPager

    }
}
