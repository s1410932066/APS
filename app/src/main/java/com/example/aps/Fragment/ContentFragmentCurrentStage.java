package com.example.aps.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.Adapter.FragmentCurrentStageRecyclerViewAdapter;
import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.R;

import java.util.List;

public class ContentFragmentCurrentStage extends Fragment {
    private Context mContext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_2current_stage, container, false);
        Bundle bundle = getArguments();
        if (bundle != null){
            List<GetCurrentStageData> currentStageData = (List<GetCurrentStageData>) bundle.getSerializable("GetCurrentStageData");
            SearchAllData searchAllData = (SearchAllData) bundle.getSerializable("SearchAllData");
            TextView so_source_fragment, mo_source_fragment, components_id_fragment, components_name_fragment, quantity_fragment, unit_id_fragment, APS_title_fragment;
            String item_id;
            RecyclerView mCurrentStageRecyclerView;
            FragmentCurrentStageRecyclerViewAdapter mCurrentStageRecyclerViewAdapter;
            so_source_fragment = view.findViewById(R.id.so_source);
            mo_source_fragment = view.findViewById(R.id.mo_source);
            components_id_fragment = view.findViewById(R.id.components_id);
            components_name_fragment = view.findViewById(R.id.components_name);
            quantity_fragment = view.findViewById(R.id.quantity);
            unit_id_fragment = view.findViewById(R.id.unit_id);
            APS_title_fragment = view.findViewById(R.id.APS_title);
            mCurrentStageRecyclerView = view.findViewById(R.id.RecyclerView_Content_Current_Stage);
            mCurrentStageRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mCurrentStageRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
            mCurrentStageRecyclerViewAdapter = new FragmentCurrentStageRecyclerViewAdapter(currentStageData);
            mCurrentStageRecyclerView.setAdapter(mCurrentStageRecyclerViewAdapter);
            SharedPreferences params = mContext.getSharedPreferences("getParams", mContext.MODE_PRIVATE);
            item_id = params.getString("item_id", "");
            so_source_fragment.setText("來源訂單: " + searchAllData.getSo_id());
            mo_source_fragment.setText("製令單號: " + searchAllData.getMo_id());
            components_id_fragment.setText("母件編號: " + item_id);
            components_name_fragment.setText(searchAllData.getItem_name());
            quantity_fragment.setText("生產數量: " + searchAllData.getQty());
            APS_title_fragment.setText("明昌國際工業股份有限公司\n場內製造命令(" + searchAllData.getRelated_tech_route().getTech_routing_name() + ")");
            unit_id_fragment.setText(searchAllData.getRelated_parent_part().getUnit_id());
        }
        return view;
    }

}