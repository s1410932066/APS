package com.example.aps.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.Adapter.FragmentSalesOrderRecyclerViewAdapter;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;
import com.example.aps.R;

import java.util.List;


public class ContentFragmentSalesOrder extends Fragment {
    private Context mContext;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_5, container, false);
        TextView tv_so_source, tv_customer_name, tv_customer_order, tv_business, tv_APS_title;
        Bundle bundle = getArguments();
        if (bundle != null){
            List<SoIdData> getSalesOrderData = (List<SoIdData>) bundle.getSerializable("SalesOrderData");
            SearchAllData searchAllData = (SearchAllData) bundle.getSerializable("SearchAllData");
            RecyclerView mSalesOrderRecyclerView;
            FragmentSalesOrderRecyclerViewAdapter mSalesOrderRecyclerViewAdapter;
            tv_APS_title = view.findViewById(R.id.APS_title);
            tv_so_source = view.findViewById(R.id.so_source);
            tv_customer_name = view.findViewById(R.id.customer_name);
            tv_customer_order = view.findViewById(R.id.customer_order);
            tv_business = view.findViewById(R.id.business);
            mSalesOrderRecyclerView = view.findViewById(R.id.RecyclerView_Content_Sales_Order);
            mSalesOrderRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mSalesOrderRecyclerViewAdapter = new FragmentSalesOrderRecyclerViewAdapter(getSalesOrderData);
            mSalesOrderRecyclerView.setAdapter(mSalesOrderRecyclerViewAdapter);

            tv_APS_title.setText("明昌國際工業股份有限公司\n訂購憑單(" + searchAllData.getRelated_tech_route().getTech_routing_name() + ")");
            tv_so_source.setText("單據號碼: " + searchAllData.getSo_id());
            tv_customer_name.setText("客戶名稱: " + getSalesOrderData.get(0).getSale_order().get(0).getCustomer_name());
            tv_customer_order.setText("客戶訂單: " + getSalesOrderData.get(0).getSale_order().get(0).getCustomer_order());
            tv_business.setText("業務人員: " + getSalesOrderData.get(0).getSale_order().get(0).getPerson_id());
        }
        return view;
    }
}