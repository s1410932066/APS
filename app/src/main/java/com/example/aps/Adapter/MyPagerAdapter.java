package com.example.aps.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View> mPager;//管理分頁陣列
    private int childCount = 0;//取得現在分頁位置

    public MyPagerAdapter(List<View> mPager){
        this.mPager = mPager;           //分頁陣列要由MainActivity傳入
    }

    @Override
    public int getItemPosition(@NonNull Object object) {    //取得分頁位置
        if (childCount>0){
            childCount --;
            return POSITION_NONE;
        }
        return  super.getItemPosition(object);
    }

    @Override
    public int getCount() {     //填入分頁數量
        return mPager.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mPager.get(position).setTag(position);
        ((ViewPager) container).addView(mPager.get(position));  //添加view到mPager容器
//        Log.e("viewpagers", position+" hi");
        return mPager.get(position);//給予view的對應Object id
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;      //判斷從instantiateItem返回来的View與當前的View是否對應。
    }

//    @Override
//    public void notifyDataSetChanged() {
//        childCount = getCount();        //動態新增
//        super.notifyDataSetChanged();
//    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {    //標籤條文字
        switch (position){
            case 0:
                return "生產排程";
            case 1:
                return "當日進度表";
            case 2:
                return "訊息通知";
        }
        return null;
    }

}
