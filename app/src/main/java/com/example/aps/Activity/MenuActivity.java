package com.example.aps.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.aps.Adapter.MyFragmentPagerAdapter;
import com.example.aps.Fragment.FunctionTable_Fragment1;
import com.example.aps.Fragment.TodayFragment2;
import com.example.aps.Fragment.NothingFragment3;
import com.example.aps.R;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {

    Button bt_schedule, bt_setup;
    private ViewPager viewPager;
    private TabLayout tab;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private FunctionTable_Fragment1 functionTable_fragment1;
    private TodayFragment2 todayFragment2;
    private NothingFragment3 nothingFragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //String token = getSharedPreferences("getToken", MODE_PRIVATE).getString("token", "");

        bt_schedule = findViewById(R.id.button_schedule1);
        bt_setup = findViewById(R.id.button_setup1);

        setToolbar();

        viewPager = findViewById(R.id.mViewPager);
        tab = findViewById(R.id.tab);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        myFragmentPagerAdapter.addFragment(new FunctionTable_Fragment1(),"生產排程");
        myFragmentPagerAdapter.addFragment(new TodayFragment2(),"當日進度表");
        myFragmentPagerAdapter.addFragment(new NothingFragment3(),"訊息通知");
        tab.setupWithViewPager(viewPager);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(1);

        LinearLayout tabStrip = (LinearLayout) tab.getChildAt(0);
        View tabView2 = tabStrip.getChildAt(2);         //第三個tab禁止點擊
        if (tabView2 != null) {
            tabView2.setClickable(false);
        }

/**ViewPagers+TabLayout

        ArrayList<View> mPages = new ArrayList<>();
        mPages.add(new Pagers(this));
        mPages.add(new Pagers2(this));
        mPages.add(new Pagers3(this));

        ViewPager viewPager = findViewById(R.id.mViewPager);
        TabLayout tab = findViewById(R.id.tab);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(mPages);
        tab.setupWithViewPager(viewPager);//將TabLayout綁定給ViewPager
        viewPager.setAdapter(myPagerAdapter);//綁定適配器
        viewPager.setCurrentItem(0);//指定跳到某頁，一定得設置在setAdapter後面

        LinearLayout tabStrip = (LinearLayout) tab.getChildAt(0);
        View tabView2 = tabStrip.getChildAt(2);         //第三個tab禁止點擊
        if (tabView2 != null) {
            tabView2.setClickable(false);
        }**/
    }

//    public void bt_schedule(View view) {
//        Intent intent1 = new Intent(Menu_Activity.this, Schedule_Query_Activity.class);
//        startActivity(intent1);
//    }
//
//    public void bt_setup(View view) {
//        Intent intent2 = new Intent(Menu_Activity.this, Setup_Activity.class);
//        startActivity(intent2);
//    }




    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setNavigationIcon(getDrawable(R.drawable.u154));
//        toolbar.setContentInsetStartWithNavigation(0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}

