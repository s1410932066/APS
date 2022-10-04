package com.example.aps.DataResponse;

import java.io.Serializable;

public class GetCurrentStageData implements Serializable {  //本階製令
    private String id;
    private String item_id;
    private String unit_id;
    private String base_qty;//單用
    private String unit_qty;//需用
    private parent parent;
    public class parent implements Serializable{
        private String bomkey_id;
        private String bomkey_name;

        public parent(String bomkey_id, String bomkey_name) {
            this.bomkey_id = bomkey_id;
            this.bomkey_name = bomkey_name;
        }

        public String getBomkey_id() {
            return bomkey_id;
        }

        public String getBomkey_name() {
            return bomkey_name;
        }
    }

    public GetCurrentStageData(String id, String item_id, String unit_id, String base_qty, String unit_qty, GetCurrentStageData.parent parent) {
        this.id = id;
        this.item_id = item_id;
        this.unit_id = unit_id;
        this.base_qty = base_qty;
        this.unit_qty = unit_qty;
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public String getBase_qty() {
        return base_qty;
    }

    public String getUnit_qty() {
        return unit_qty;
    }

    public GetCurrentStageData.parent getParent() {
        return parent;
    }
}
