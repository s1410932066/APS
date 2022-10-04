package com.example.aps.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.Activity.TodayDataContent;
import com.example.aps.Adapter.TodayMyRecyclerViewAdapter;
import com.example.aps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class TodayFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_2, container, false);

        RecyclerView mRecyclerView;
        TodayMyRecyclerViewAdapter myRecyclerViewAdapter;
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        for (int i=0;i<10;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("id",String.valueOf(i+1));
            hashMap.put("om", "1MO18120400" + (new Random().nextInt(80)+20));
            hashMap.put("so", "1SOA181130000" + (new Random().nextInt(9)+1));
            hashMap.put("item_id", "F260001-" + (new Random().nextInt(5)+1) + "A");
            hashMap.put("item_name", "MATADOR");
            hashMap.put("qty", "     數量 : 3");
            hashMap.put("complete_date","結關日 : 2018-12-07");
            hashMap.put("online_date", "計劃開始 : 08:00");
            hashMap.put("techroutekey_id", "一群-點焊");
            arrayList.add(hashMap);
        }
        mRecyclerView = view.findViewById(R.id.RecyclerView_schedule_of_day);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        myRecyclerViewAdapter = new TodayMyRecyclerViewAdapter(arrayList);
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        //RecyclerView點擊事件
        myRecyclerViewAdapter.setOnItemClickListener(new TodayMyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Log.e("", position+1 + "號");
                Intent intent = new Intent(getActivity(), TodayDataContent.class);
                startActivity(intent);
            }
        });
        return view;
    }
}