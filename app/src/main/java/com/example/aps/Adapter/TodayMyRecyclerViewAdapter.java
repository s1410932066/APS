package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TodayMyRecyclerViewAdapter extends RecyclerView.Adapter<TodayMyRecyclerViewAdapter.ViewHolder> {

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;
    public TodayMyRecyclerViewAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.arrayList = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_so, tv_om, tv_item_id, tv_item_name, tv_qty, tv_complete_date, tv_online_date, tv_techroutekey_id;
        View mView;
        ImageView img_go;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id1);
            tv_om= itemView.findViewById(R.id.tv_om1);
            tv_so = itemView.findViewById(R.id.tv_so1);
            tv_item_id= itemView.findViewById(R.id.tv_item_id1);
            tv_item_name= itemView.findViewById(R.id.tv_item_name1);
            tv_qty= itemView.findViewById(R.id.tv_qty1);
            tv_complete_date= itemView.findViewById(R.id.tv_complete_date1);
            tv_online_date= itemView.findViewById(R.id.tv_online_date1);
            tv_techroutekey_id= itemView.findViewById(R.id.tv_techroutekey_id1);
            mView = itemView;
        }

        void setData(int position){
            tv_id.setText(arrayList.get(position).get("id"));
            tv_om.setText(arrayList.get(position).get("om"));
            tv_so.setText(arrayList.get(position).get("so"));
            tv_item_id.setText(arrayList.get(position).get("item_id"));
            tv_item_name.setText(arrayList.get(position).get("item_name"));
            tv_qty.setText(arrayList.get(position).get("qty"));
            tv_complete_date.setText(arrayList.get(position).get("complete_date"));
            tv_online_date.setText(arrayList.get(position).get("online_date"));
            tv_techroutekey_id.setText(arrayList.get(position).get("techroutekey_id"));
            mView.setOnClickListener(getOnClickListener(position));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_today_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //點擊事件
    private View.OnClickListener getOnClickListener(int position){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null && view != null){
                    mOnItemClickListener.onItemClick(view,position);
                }
            }
        };
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
}
