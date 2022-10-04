package com.example.aps.SearchDataAPI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.Adapter.FragmentCurrentStageRecyclerViewAdapter;
import com.example.aps.Adapter.QueryMyRecyclerViewAdapter;
import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;
import com.example.aps.R;
import com.example.aps.SearchAPI.ScheduleQueryActivity;
import com.example.aps.SearchDataContent.ScheduleQueryDataContentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleQueryDataActivity extends AppCompatActivity implements SearchDataContract.IView {

    TextView tv_total;
    RecyclerView mQueryRecyclerView, mContentRecyclerView;
    QueryMyRecyclerViewAdapter myQueryRecyclerViewAdapter;
    FragmentCurrentStageRecyclerViewAdapter myContentRecyclerViewAdapter;
    ArrayList<HashMap<String , String>> arrayList = new ArrayList<>();
    SearchDataPresenter presenter;
    String token;
    Bundle bundle;
    String sale_order;
    public List<GetCurrentStageData> currentStageData_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_query_data);

        tv_total = findViewById(R.id.tv_total);
        presenter = new SearchDataPresenter(this);
        token = getSharedPreferences("getParams", MODE_PRIVATE).getString("token", "");
        bundle = getIntent().getExtras();
        sale_order = bundle.getString("so_id");
//        sale_order = getSharedPreferences("getParams", MODE_PRIVATE).getString("sale_order", "");

        presenter.getSearchAllData(token, sale_order, "");
        presenter.getSoId_item_id(token, sale_order, "", "");


        setToolbar();
        mQueryRecyclerView = findViewById(R.id.RecyclerView_schedule_query_data);
        mQueryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQueryRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
/**假資料
        for (int i=0;i<10;i++){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id",String.valueOf(i+1));
        hashMap.put("om", "1MO18120400" + (new Random().nextInt(80)+20));
        hashMap.put("so", "1SOA181130000" + (new Random().nextInt(9)+1));
        hashMap.put("item_id", "F260001-" + (new Random().nextInt(5)+1) + "A");
        hashMap.put("item_name", "MATADOR");
        hashMap.put("qty", "     數量 : 3");
        hashMap.put("complete_date","結關日 : 2018-12-08");
        hashMap.put("online_date", "上線日期 : 2018-12-07");
        hashMap.put("techroutekey_id", "一群-點焊");
        hashMap.put("take_effect", "生效");
        arrayList.add(hashMap);
        }
*/
//        myRecyclerViewAdapter = new QueryMyRecyclerViewAdapter(arrayList);
//        mRecyclerView.setAdapter(myRecyclerViewAdapter);
    }

    private void setToolbar() {
        Toolbar toolbar_Schedule = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar_Schedule);
        getSupportActionBar().setTitle("進度表查詢");
        toolbar_Schedule.setTitleTextColor(Color.WHITE);
        toolbar_Schedule.setNavigationIcon(getDrawable(R.drawable.u154));
        toolbar_Schedule.setContentInsetStartWithNavigation(0);
        toolbar_Schedule.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScheduleQueryDataActivity.this, ScheduleQueryActivity.class);
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

//查詢so_id後，得到的Recycler資料
    @Override
    public void callback_V_SearchAllData(List<SearchAllData> searchData) {
        tv_total.setText("共" + String.valueOf(searchData.size()) + "筆");
        myQueryRecyclerViewAdapter = new QueryMyRecyclerViewAdapter(searchData);
        mQueryRecyclerView.setAdapter(myQueryRecyclerViewAdapter);
        myQueryRecyclerViewAdapter.setOnItemClickListener(new QueryMyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String so_id_f = searchData.get(position).getSo_id();
                String mo_id_f = searchData.get(position).getMo_id();
                presenter.getSearchAllData(token, so_id_f, mo_id_f);
//                Log.e("onItemClick123: ",mo_id);
//                String item_id = searchData.get(position).getItem_id();
                String item_name = searchData.get(position).getItem_name();
                String online_date = searchData.get(position).getOnline_date();
                String qty = searchData.get(position).getQty();
                String tech_routing_name = searchData.get(position).getRelated_tech_route().getTech_routing_name();
                String unit_id = searchData.get(position).getRelated_parent_part().getUnit_id();
                String complete_date = searchData.get(position).getComplete_date();
                String customer = searchData.get(position).getCustomer();
                SearchAllData.related_tech_route related_tech_route = searchData.get(position).getRelated_tech_route();
                SearchAllData.related_parent_part related_parent_part = searchData.get(position).getRelated_parent_part();

                SearchAllData searchAllData = new SearchAllData(mo_id_f, item_name, qty, online_date, complete_date, so_id_f, customer, related_tech_route, related_parent_part);
//                SearchAllData.related_tech_route related_tech_route = new SearchAllData.related_tech_route(tech_routing_name);
//                SearchAllData.related_parent_part related_parent_part = new SearchAllData.related_parent_part(unit_id);
//                Log.e("onItemClick: ",searchAllData.getRelated_parent_part().getUnit_id());
                Intent intent = new Intent(ScheduleQueryDataActivity.this, ScheduleQueryDataContentActivity.class);
                intent.putExtra("SearchAllData", (SearchAllData) searchAllData);
//                        .putExtra("SearchAllData.related_tech_route", (SearchAllData.related_tech_route) related_tech_route)
//                        .putExtra("SearchAllData.related_parent_part", (SearchAllData.related_parent_part) related_parent_part);
                startActivity(intent);
                finish();
            }
        });
    }

    //獲取銷售訂單資料、item_id
    @Override
    public void callback_V_SoId_item_id(List<SoIdData> SoId_item_id) {
        //Log.e("item", SoId_item_id.get(0).getItem_id());
        String item_id = SoId_item_id.get(0).getItem_id();
        presenter.getCurrent_id(token, item_id);
        SharedPreferences getParams = getSharedPreferences("getParams", MODE_PRIVATE);
        getParams.edit().putString("item_id", SoId_item_id.get(0).getItem_id())
                        .putString("customer_name", SoId_item_id.get(0).getSale_order().get(0).getCustomer_name())
                        .putString("customer_order", SoId_item_id.get(0).getSale_order().get(0).getCustomer_order())
                        .putString("person_id", SoId_item_id.get(0).getSale_order().get(0).getPerson_id())
                        .commit();
    }

    @Override
    public void callback_V_Current_id(List<GetCurrentStageData> getCurrentStageData) {
        SharedPreferences getParams = getSharedPreferences("getParams", MODE_PRIVATE);
        getParams.edit().putString("id", getCurrentStageData.get(0).getId()).commit();
    }

}