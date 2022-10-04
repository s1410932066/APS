package com.example.aps.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.aps.Fragment.ContentFragmentPreManu;
import com.example.aps.Fragment.ContentFragmentCurrentStage;
import com.example.aps.Fragment.ContentFragmentNextPart;
import com.example.aps.Fragment.ContentFragmentGetSoData;
import com.example.aps.Fragment.ContentFragmentSalesOrder;
import com.example.aps.R;

public class TodayDataContent extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    private ContentFragmentPreManu fragment1;
    private ContentFragmentCurrentStage fragment2;
    private ContentFragmentNextPart fragment3;
    private ContentFragmentGetSoData fragment4;
    private ContentFragmentSalesOrder fragment5;
    ImageView img_back, img_next;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_data_content);
        setToolbar();
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        img_back = findViewById(R.id.img_back);
        img_next = findViewById(R.id.img_next);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        radioGroup.check(R.id.radioButton2);
        fragment2 = new ContentFragmentCurrentStage();
        fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment2);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                radioGroup.check(R.id.radioButton3);
                fragment3 = new ContentFragmentNextPart();
                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment3);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                radioGroup.check(R.id.radioButton1);
                fragment1 = new ContentFragmentPreManu();
                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment1);
            }
        });
        fragmentTransaction.commit();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (i){
                    case    R.id.radioButton1:
                        img_back.setVisibility(View.INVISIBLE);
                        radioGroup.check(R.id.radioButton1);
                        fragment1 = new ContentFragmentPreManu();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment1);
                        img_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton2);
                                fragment2 = new ContentFragmentCurrentStage();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment2);
                            }
                        });
                        fragmentTransaction.commit();
                        break;

                    case    R.id.radioButton2:
                        img_next.setVisibility(View.VISIBLE);
                        img_back.setVisibility(View.VISIBLE);
                        radioGroup.check(R.id.radioButton2);
                        fragment2 = new ContentFragmentCurrentStage();
                        fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment2);
                        img_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton3);
                                fragment3 = new ContentFragmentNextPart();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment3);
                            }
                        });
                        img_back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton1);
                                fragment1 = new ContentFragmentPreManu();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment1);
                            }
                        });
                        fragmentTransaction.commit();

                        break;

                    case    R.id.radioButton3:
                        img_next.setVisibility(View.VISIBLE);
                        img_back.setVisibility(View.VISIBLE);
                        radioGroup.check(R.id.radioButton3);
                        fragment3 = new ContentFragmentNextPart();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment3);
                        img_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton4);
                                fragment4 = new ContentFragmentGetSoData();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment4);
                            }
                        });
                        img_back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton2);
                                fragment2 = new ContentFragmentCurrentStage();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment2);
                            }
                        });
                        fragmentTransaction.commit();
                        break;

                    case    R.id.radioButton4:
                        img_next.setVisibility(View.VISIBLE);
                        img_back.setVisibility(View.VISIBLE);
                        radioGroup.check(R.id.radioButton4);
                        fragment4 = new ContentFragmentGetSoData();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment4);
                        img_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton5);
                                fragment5 = new ContentFragmentSalesOrder();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment5);
                            }
                        });
                        img_back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton3);
                                fragment3 = new ContentFragmentNextPart();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment3);
                            }
                        });
                        fragmentTransaction.commit();
                        break;

                    case    R.id.radioButton5:
                        img_next.setVisibility(View.INVISIBLE);
                        radioGroup.check(R.id.radioButton5);
                        fragment5 = new ContentFragmentSalesOrder();
                        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment5);
                        img_back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                radioGroup.check(R.id.radioButton4);
                                fragment4 = new ContentFragmentGetSoData();
                                fragmentTransaction.replace(R.id.fragmentContainerView2 , fragment4);
                            }
                        });
                        fragmentTransaction.commit();
                        break;
                }
            }
        });

    }

    private void setToolbar() {
        Toolbar toolbar_Schedule = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar_Schedule);
        getSupportActionBar().setTitle("當日進度表");
        toolbar_Schedule.setTitleTextColor(Color.WHITE);
        toolbar_Schedule.setNavigationIcon(getDrawable(R.drawable.u154));
        toolbar_Schedule.setContentInsetStartWithNavigation(0);
        toolbar_Schedule.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TodayDataContent.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}
