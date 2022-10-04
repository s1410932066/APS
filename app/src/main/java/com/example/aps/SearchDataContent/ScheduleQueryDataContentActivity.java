package com.example.aps.SearchDataContent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.GetNextPartData;
import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;
import com.example.aps.Fragment.ContentFragmentCurrentStage;
import com.example.aps.Fragment.ContentFragmentGetSoData;
import com.example.aps.Fragment.ContentFragmentNextPart;
import com.example.aps.Fragment.ContentFragmentPreManu;
import com.example.aps.Fragment.ContentFragmentSalesOrder;
import com.example.aps.R;
import com.example.aps.SearchDataAPI.ScheduleQueryDataActivity;

import java.io.Serializable;
import java.util.List;


public class ScheduleQueryDataContentActivity extends AppCompatActivity implements SearchDataContentContract.IView {
    public RadioGroup radioGroup_menu;
    public RadioButton radioButton_prev_manufacture, radioButton_current_stage, radioButton_next_part, radioButton_assembly, radioButton_Sales;
    public ContentFragmentPreManu fragment1;
    public ContentFragmentCurrentStage fragment2;
    public ContentFragmentNextPart fragment3;
    public ContentFragmentGetSoData fragment4;
    public ContentFragmentSalesOrder fragment5;
    public ImageView img_goBack, img_goNext;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    SearchDataContentPresenter presenter;
    String token, id, so_id, item_id, customer_name, customer_order, person_id;
    TextView tv_mo_id, tv_so_id, tv_item_id, tv_item_name, tv_online_date, tv_qty, tv_tech_routing_name, start_time, end_time;
    SearchAllData searchAllData;
    SearchAllData.related_tech_route related_tech_route;
    SearchAllData.related_parent_part related_parent_part;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query_data_content);
        searchAllData = (SearchAllData) getIntent().getSerializableExtra("SearchAllData");
        related_tech_route = (SearchAllData.related_tech_route) getIntent().getSerializableExtra("SearchAllData.related_tech_route");
        related_parent_part = (SearchAllData.related_parent_part) getIntent().getSerializableExtra("SearchAllData.related_parent_part");
        initViews();
        getData();
        setData();
        setToolbar();

        presenter = new SearchDataContentPresenter(this);
        fragmentManager = getSupportFragmentManager();
        presenter.getPreManuData(token, so_id, item_id);
        presenter.getNextPartData(token, so_id, id);
        presenter.getSoIdData(token, so_id, item_id);
        presenter.getSalesOrderData(token, so_id, "", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getCurrentStageData(token, item_id);
            }
        }, 500);

        radioGroup_menu.check(R.id.radioButton_current_stage);//設定radioButton2選項為選取狀態


//RadioGroup點擊事件
        radioGroup_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton_prev_manufacture:
                        setData();
                        img_goBack.setVisibility(View.INVISIBLE);
                        if (fragment1 != null){
                            presenter.getPreManuData(token, so_id, item_id);
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.hide(fragment1)
                                               .hide(fragment2)
                                               .hide(fragment3)
                                               .hide(fragment4)
                                               .hide(fragment5)
                                               .show(fragment1).commit();
                        }
                        break;

                    case R.id.radioButton_current_stage:
                        setData();
                        if (fragment2 != null){
                            presenter.getCurrentStageData(token, item_id);
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.hide(fragment1)
                                               .hide(fragment2)
                                               .hide(fragment3)
                                               .hide(fragment4)
                                               .hide(fragment5)
                                               .show(fragment2).commit();
                        }
                        break;

                    case R.id.radioButton_next_part:
                        setData();
                        if (fragment3 != null){
                            presenter.getNextPartData(token, so_id, id);
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.hide(fragment1)
                                               .hide(fragment2)
                                               .hide(fragment3)
                                               .hide(fragment4)
                                               .hide(fragment5)
                                               .show(fragment3).commit();
                        }
                        break;

                    case R.id.radioButton_assembly:
                        setData();
                        if (fragment4 != null){
                            presenter.getSoIdData(token, so_id, item_id);
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.hide(fragment1)
                                               .hide(fragment2)
                                               .hide(fragment3)
                                               .hide(fragment4)
                                               .hide(fragment5)
                                               .show(fragment4).commit();
                        }
                        break;

                    case R.id.radioButton_Sales:
                        tv_mo_id.setText(so_id);
                        tv_item_id.setText("客戶名稱 : " + customer_name);
                        tv_item_name.setText("客戶訂單：" + customer_order);
                        tv_online_date.setText("業務人員：(" + person_id + ")" + " 嚴卉婷");
                        img_goBack.setVisibility(View.VISIBLE);
                        img_goNext.setVisibility(View.INVISIBLE);
                        tv_so_id.setVisibility(View.INVISIBLE);
                        tv_qty.setVisibility(View.INVISIBLE);
                        tv_tech_routing_name.setVisibility(View.INVISIBLE);
                        start_time.setVisibility(View.INVISIBLE);
                        end_time.setVisibility(View.INVISIBLE);
                        if (fragment5 != null){
                            presenter.getSalesOrderData(token, so_id, "", "");
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.hide(fragment1)
                                               .hide(fragment2)
                                               .hide(fragment3)
                                               .hide(fragment4)
                                               .hide(fragment5)
                                               .show(fragment5).commit();
                        }
                        break;
                }
            }
        });

    }

    @Override   //PreManuData1
    public void callback_V_PreManuData(List<GetPreManuData> preManuData) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment1 == null){
            fragment1 = new ContentFragmentPreManu();
        }
        if (!fragment1.isAdded()){
        Bundle bundle = new Bundle();
        bundle.putSerializable("GetPreManuData", (Serializable) preManuData);
        bundle.putSerializable("SearchAllData", (Serializable) searchAllData);
        fragment1.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment1).hide(fragment1).commit();
            Log.e("f1已Add", "yes");
        }

        if (fragment1 != null && !fragment1.isHidden()){
//            Log.e("f1正在顯示", "yes");
            img_goNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f1->f2", "yes");
                    radioGroup_menu.check(R.id.radioButton_current_stage);
                }
            });
        }
    }

    @Override   //CurrentStageData2
    public void callback_V_CurrentStageData(List<GetCurrentStageData> currentStageData) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment2 == null){
            fragment2 = new ContentFragmentCurrentStage();
        }
        if (!fragment2.isAdded()){
            Bundle bundle = new Bundle();
            bundle.putSerializable("GetCurrentStageData", (Serializable) currentStageData);
            bundle.putSerializable("SearchAllData", (Serializable) searchAllData);
            fragment2.setArguments(bundle);
            fragmentTransaction.add(R.id.fragmentContainerView, fragment2).show(fragment2).commit();
            Log.e("f2已Add", "yes");
        }

        if (fragment2 != null && !fragment2.isHidden()){
//            Log.e("f2正在顯示", "yes");
            img_goNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f2->f3", "yes");
                    radioGroup_menu.check(R.id.radioButton_next_part);
                }
            });
            img_goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f2->f1", "yes");
                    radioGroup_menu.check(R.id.radioButton_prev_manufacture);
                }
            });
        }
    }

    @Override   //NextPart3
    public void callback_V_NextPart(List<GetNextPartData> getNextPartData) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment3 == null){
            fragment3 = new ContentFragmentNextPart();
        }
        if (!fragment3.isAdded()){
        Bundle bundle = new Bundle();
        bundle.putSerializable("GetNextPartData", (Serializable) getNextPartData);
        bundle.putSerializable("SearchAllData", (Serializable) searchAllData);
        fragment3.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment3).hide(fragment3).commit();
            Log.e("f3已Add", "yes");
        }
        if (fragment3 != null && !fragment3.isHidden()){
//            Log.e("f3正在顯示", "yes");
            img_goNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f3->f4", "yes");
                    radioGroup_menu.check(R.id.radioButton_assembly);
                }
            });
            img_goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f3->f2", "yes");
                    radioGroup_menu.check(R.id.radioButton_current_stage);
                }
            });
        }
    }

    @Override   //SoIdData4
    public void callback_V_SoIdData(GetSoDataData getSoDataData) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment4 == null){
            fragment4 = new ContentFragmentGetSoData();
        }
        if (!fragment4.isAdded()){
        Bundle bundle = new Bundle();
        bundle.putSerializable("GetSoDataData", (Serializable) getSoDataData);
        bundle.putSerializable("SearchAllData", (Serializable) searchAllData);
        fragment4.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment4).hide(fragment4).commit();
            Log.e("f4已Add", "yes");
        }
        if (fragment4 != null && !fragment4.isHidden()){
//            Log.e("f4正在顯示", "yes");
            img_goNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f4->f5", "yes");
                    radioGroup_menu.check(R.id.radioButton_Sales);
                }
            });
            img_goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f4->f3", "yes");
                    radioGroup_menu.check(R.id.radioButton_next_part);
                }
            });
        }
    }

    @Override   //SalesOrderData5
    public void callback_V_SalesOrderData(List<SoIdData> getSalesOrderData) {

        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment5 == null){
            fragment5 = new ContentFragmentSalesOrder();
        }
        if (!fragment5.isAdded()){
        Bundle bundle = new Bundle();
        bundle.putSerializable("SalesOrderData", (Serializable) getSalesOrderData);
        bundle.putSerializable("SearchAllData", searchAllData);
        fragment5.setArguments(bundle);
        fragmentTransaction.add(R.id.fragmentContainerView, fragment5).hide(fragment5).commit();
            Log.e("f5已Add", "yes");
        }
        if (fragment5 != null && !fragment5.isHidden()){
//            Log.e("f5正在顯示", "yes");
            img_goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("f5->f4", "yes");
                    radioGroup_menu.check(R.id.radioButton_assembly);
                }
            });
        }
    }

    private void getData() {    //取得接收資料
        so_id = searchAllData.getSo_id();
        SharedPreferences params = getSharedPreferences("getParams", MODE_PRIVATE);
        id = params.getString("id", "");
        token = params.getString("token", "");
        item_id = params.getString("item_id", "");
        customer_name = params.getString("customer_name", "");
        customer_order = params.getString("customer_order", "");
        person_id = params.getString("person_id", "");
    }

    private void initViews() {      //初始化綁定
        radioGroup_menu = findViewById(R.id.radioGroup_menu);
        radioButton_prev_manufacture = findViewById(R.id.radioButton_prev_manufacture);
        radioButton_current_stage = findViewById(R.id.radioButton_current_stage);
        radioButton_next_part = findViewById(R.id.radioButton_next_part);
        radioButton_assembly = findViewById(R.id.radioButton_assembly);
        radioButton_Sales = findViewById(R.id.radioButton_Sales);
        img_goNext = findViewById(R.id.img_gonext);
        img_goBack = findViewById(R.id.img_goback);
        tv_so_id = findViewById(R.id.tv_so_id);
        tv_mo_id = findViewById(R.id.tv_mo_id);
        tv_item_id = findViewById(R.id.tv_item_id);
        tv_item_name = findViewById(R.id.tv_item_name);
        tv_online_date = findViewById(R.id.tv_online_date);
        tv_qty = findViewById(R.id.tv_qty);
        tv_tech_routing_name = findViewById(R.id.tv_tech_routing_name);
        start_time = findViewById(R.id.start_time);
        end_time = findViewById(R.id.end_time);
    }

    private void setData() {        //資料顯示
        tv_so_id.setVisibility(View.VISIBLE);
        tv_mo_id.setVisibility(View.VISIBLE);
        tv_item_id.setVisibility(View.VISIBLE);
        tv_item_name.setVisibility(View.VISIBLE);
        tv_online_date.setVisibility(View.VISIBLE);
        tv_qty.setVisibility(View.VISIBLE);
        tv_tech_routing_name.setVisibility(View.VISIBLE);
        start_time.setVisibility(View.VISIBLE);
        end_time.setVisibility(View.VISIBLE);
        img_goBack.setVisibility(View.VISIBLE);
        img_goNext.setVisibility(View.VISIBLE);
        tv_so_id.setText(searchAllData.getSo_id());
        tv_mo_id.setText(searchAllData.getMo_id());
        tv_item_id.setText(item_id);
        tv_item_name.setText(searchAllData.getItem_name());
        tv_online_date.setText("預計上線 : " + searchAllData.getOnline_date());
        tv_qty.setText("生產數量 : " + searchAllData.getQty());
//        tv_tech_routing_name.setText(related_tech_route.getTech_routing_name());
        tv_tech_routing_name.setText(searchAllData.getRelated_tech_route().getTech_routing_name());
    }

    private void setToolbar() {     //Toolbar設定
        Toolbar toolbar_Schedule = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar_Schedule);
        getSupportActionBar().setTitle("進度表查詢");
        toolbar_Schedule.setTitleTextColor(Color.WHITE);
        toolbar_Schedule.setNavigationIcon(getDrawable(R.drawable.u154));
        toolbar_Schedule.setContentInsetStartWithNavigation(0);
        toolbar_Schedule.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScheduleQueryDataContentActivity.this, ScheduleQueryDataActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("so_id",so_id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}