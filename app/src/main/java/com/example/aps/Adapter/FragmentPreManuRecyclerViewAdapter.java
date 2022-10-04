package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.R;

import java.util.List;

public class FragmentPreManuRecyclerViewAdapter extends RecyclerView.Adapter<FragmentPreManuRecyclerViewAdapter.ViewHolder> {
    List<GetPreManuData> preManuData;
    public FragmentPreManuRecyclerViewAdapter(List<GetPreManuData> preManuData) {
        this.preManuData = preManuData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView serial_id, material_id, material_name, unit_dosage, required_unit, unit_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serial_id = itemView.findViewById(R.id.serial_id_f1);
            material_id = itemView.findViewById(R.id.material_id_f1);
            material_name = itemView.findViewById(R.id.material_name_f1);
            unit_dosage = itemView.findViewById(R.id.unit_dosage_f1);
            required_unit = itemView.findViewById(R.id.required_unit_f1);
            unit_name = itemView.findViewById(R.id.unit_name_f1);
        }
        void setData(int position){
            serial_id.setText(String.valueOf(position+1));
            material_id.setText(preManuData.get(position).getItem_id());
            material_name.setText(preManuData.get(position).getItem_name());
            unit_dosage.setText(preManuData.get(position).getCurrent_state());
            required_unit.setText(preManuData.get(position).getBatch());
            unit_name.setText("PCS");
        }
    }

    @NonNull
    @Override
    public FragmentPreManuRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_pre_manu_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentPreManuRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return preManuData.size();
    }


}
