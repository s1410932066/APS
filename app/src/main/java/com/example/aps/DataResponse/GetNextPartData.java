package com.example.aps.DataResponse;

import java.io.Serializable;

public class GetNextPartData implements Serializable {      //後關製令
    private String unit_qty;
    private String base_qty;
    private String item_id;
    private related_top_parent related_top_parent;
    public static class related_top_parent implements Serializable{
        private String bomkey_name;
        private String unit_id;

        public related_top_parent(String bomkey_name, String unit_id) {
            this.bomkey_name = bomkey_name;
            this.unit_id = unit_id;
        }

        public String getBomkey_name() {
            return bomkey_name;
        }

        public String getUnit_id() {
            return unit_id;
        }
    }

    public GetNextPartData(String unit_qty, String base_qty, String item_id, GetNextPartData.related_top_parent related_top_parent) {
        this.unit_qty = unit_qty;
        this.base_qty = base_qty;
        this.item_id = item_id;
        this.related_top_parent = related_top_parent;
    }

    public String getUnit_qty() {
        return unit_qty;
    }

    public String getBase_qty() {
        return base_qty;
    }

    public String getItem_id() {
        return item_id;
    }

    public GetNextPartData.related_top_parent getRelated_top_parent() {
        return related_top_parent;
    }
}
