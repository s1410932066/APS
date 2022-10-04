package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.R;
import com.example.aps.DataResponse.SearchAllData;

import java.util.ArrayList;
import java.util.List;

public class QueryMyRecyclerViewAdapter extends RecyclerView.Adapter<QueryMyRecyclerViewAdapter.ViewHolder> {

    private OnItemClickListener mOnItemClickListener;
    //ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    List<SearchAllData> searchData = new ArrayList<>();
    public QueryMyRecyclerViewAdapter(List<SearchAllData> searchData) {
        this.searchData = searchData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1_id, tv1_so, tv1_mo, tv1_item_id, tv1_customer, tv1_qty, tv1_complete_date, tv1_online_date, tv1_tech_routing_name, tv1_take_effect;
        View mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1_id = itemView.findViewById(R.id.tv1_id);
            tv1_mo= itemView.findViewById(R.id.tv1_mo);
            tv1_so = itemView.findViewById(R.id.tv1_so);
            tv1_item_id= itemView.findViewById(R.id.tv1_item_id);
            tv1_customer= itemView.findViewById(R.id.tv1_customer);
            tv1_qty= itemView.findViewById(R.id.tv1_qty);
            tv1_complete_date= itemView.findViewById(R.id.tv1_complete_date);
            tv1_online_date= itemView.findViewById(R.id.tv1_online_date);
            tv1_tech_routing_name= itemView.findViewById(R.id.tv1_tech_routing_name);
            tv1_take_effect = itemView.findViewById(R.id.tv1_take_effect);
            mView = itemView;
        }
        void setData(int position){
            tv1_id.setText(String.valueOf(position+1));
            tv1_mo.setText(searchData.get(position).getMo_id());
            tv1_so.setText(searchData.get(position).getSo_id());
            tv1_item_id.setText(searchData.get(position).getItem_id());
            tv1_customer.setText(searchData.get(position).getCustomer());
            tv1_qty.setText("  數量 : " + searchData.get(position).getQty());
            tv1_complete_date.setText("結關日 : " + searchData.get(position).getComplete_date());
            tv1_online_date.setText("上線日 : " + searchData.get(position).getOnline_date());
            tv1_tech_routing_name.setText(searchData.get(position).getRelated_tech_route().getTech_routing_name());
            tv1_take_effect.setText("生效");
//            tv1_id.setText(arrayList.get(position).get("id"));
//            tv1_om.setText(arrayList.get(position).get("om"));
//            tv1_so.setText(arrayList.get(position).get("so"));
//            tv1_item_id.setText(arrayList.get(position).get("item_id"));
//            tv1_item_name.setText(arrayList.get(position).get("item_name"));
//            tv1_qty.setText(arrayList.get(position).get("qty"));
//            tv1_complete_date.setText(arrayList.get(position).get("complete_date"));
//            tv1_online_date.setText(arrayList.get(position).get("online_date"));
//            tv1_tech_routing_name.setText(arrayList.get(position).get("techroutekey_id"));
//            tv1_take_effect.setText("生效");
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null && view != null){
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_query_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return searchData.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

}
