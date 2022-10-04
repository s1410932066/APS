package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.R;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

public class FragmentSalesOrderRecyclerViewAdapter extends RecyclerView.Adapter<FragmentSalesOrderRecyclerViewAdapter.ViewHolder> {
    List<SoIdData> getSalesOrderData;
    public FragmentSalesOrderRecyclerViewAdapter(List<SoIdData> getSalesOrderData) {
        this.getSalesOrderData = getSalesOrderData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView serial_number, Product_number, Product_Specifications, quantity, unit, unit_not_released, Precautions;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serial_number = itemView.findViewById(R.id.serial_number_SO );
            Product_number = itemView.findViewById(R.id.Product_number_SO );
            Product_Specifications = itemView.findViewById(R.id.Product_Specifications_SO );
            quantity = itemView.findViewById(R.id.quantity_SO );
            unit = itemView.findViewById(R.id.unit_SO );
            unit_not_released = itemView.findViewById(R.id.unit_not_released_SO );
            Precautions = itemView.findViewById(R.id.Precautions_SO);
        }
        void setData(int position){
            serial_number.setText(String.valueOf(position+1));
            Product_number.setText(getSalesOrderData.get(position).getSale_order().get(position).getItem());
            Product_Specifications.setText(getSalesOrderData.get(position).getSale_order().get(position).getMaterial_spec());
            quantity.setText(getSalesOrderData.get(position).getSale_order().get(position).getQty());
            unit.setText(getSalesOrderData.get(position).getSale_order().get(position).getSunit_id());
            unit_not_released.setText(getSalesOrderData.get(position).getSale_order().get(position).getUntrans_qty());
            Precautions.setText(getSalesOrderData.get(position).getSale_order().get(position).getCu_remark());

        }
    }

    @NonNull
    @Override
    public FragmentSalesOrderRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_sales_order_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentSalesOrderRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return getSalesOrderData.size();
    }


}
