package com.example.aps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.R;

public class FragmentGetSoDataRecyclerViewAdapter extends RecyclerView.Adapter<FragmentGetSoDataRecyclerViewAdapter.ViewHolder> {
    GetSoDataData getSoDataData;
    public FragmentGetSoDataRecyclerViewAdapter(GetSoDataData getSoDataData) {
        this.getSoDataData = getSoDataData;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView serial_id, material_id, material_name, unit_dosage, required_unit, unit_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serial_id = itemView.findViewById(R.id.serial_id_f4);
            material_id = itemView.findViewById(R.id.material_id_f4);
            material_name = itemView.findViewById(R.id.material_name_f4);
            unit_dosage = itemView.findViewById(R.id.unit_dosage_f4);
            required_unit = itemView.findViewById(R.id.required_unit_f4);
            unit_name = itemView.findViewById(R.id.unit_name_f4);
        }
        void setData(int position){
            serial_id.setText(String.valueOf(position+1));
            material_id.setText(getSoDataData.getRelated_parent_part().getDownstream_child().get(position).getParent().getMaterial_id());
            material_name.setText(getSoDataData.getRelated_parent_part().getDownstream_child().get(position).getParent().getBomkey_name());
            unit_dosage.setText(getSoDataData.getRelated_parent_part().getDownstream_child().get(position).getBase_qty());
            required_unit.setText(getSoDataData.getRelated_parent_part().getDownstream_child().get(position).getUnit_qty());
            unit_name.setText(getSoDataData.getRelated_parent_part().getDownstream_child().get(position).getUnit_id());
        }
    }

    @NonNull
    @Override
    public FragmentGetSoDataRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_content_get_so_id_data_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentGetSoDataRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return getSoDataData.getRelated_parent_part().getDownstream_child().size();
    }


}
