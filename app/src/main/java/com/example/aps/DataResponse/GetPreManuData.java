package com.example.aps.DataResponse;

import java.io.Serializable;

public class GetPreManuData implements Serializable {       //前關製令
    private String item_id;
    private String item_name;
    private String qty;
    private String batch;
    private String current_state;

    public GetPreManuData(String item_id, String item_name, String qty, String batch, String current_state) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.qty = qty;
        this.batch = batch;
        this.current_state = current_state;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getQty() {
        return qty;
    }

    public String getBatch() {
        return batch;
    }

    public String getCurrent_state() {
        return current_state;
    }
}


