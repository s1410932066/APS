package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.R;

import java.util.List;

public class FragmentCurrentStageRecyclerViewAdapter extends RecyclerView.Adapter<FragmentCurrentStageRecyclerViewAdapter.ViewHolder> {

    List<GetCurrentStageData> currentStageData;
    public FragmentCurrentStageRecyclerViewAdapter(List<GetCurrentStageData> currentStageData) {
        this.currentStageData = currentStageData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView serial_id, material_id, material_name, unit_dosage, required_unit, unit_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serial_id = itemView.findViewById(R.id.serial_id_f2);
            material_id = itemView.findViewById(R.id.material_id_f2);
            material_name = itemView.findViewById(R.id.material_name_f2);
            unit_dosage = itemView.findViewById(R.id.unit_dosage_f2);
            required_unit = itemView.findViewById(R.id.required_unit_f2);
            unit_name = itemView.findViewById(R.id.unit_name_f2);
        }
        void setData(int position){
            serial_id.setText(String.valueOf(position+1));
            material_id.setText(currentStageData.get(position).getParent().getBomkey_id());
            material_name.setText(currentStageData.get(position).getParent().getBomkey_name());
            unit_dosage.setText(currentStageData.get(position).getBase_qty());
            required_unit.setText(currentStageData.get(position).getUnit_qty());
            unit_name.setText(currentStageData.get(position).getUnit_id());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_current_stage_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return currentStageData.size();
    }


}
