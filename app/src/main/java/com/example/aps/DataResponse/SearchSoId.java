package com.example.aps.DataResponse;

import java.io.Serializable;

public class SearchSoId implements Serializable {
    private String so_id;

    public SearchSoId(String so_id) {
        this.so_id = so_id;
    }

    public String getSo_id() {
        return so_id;
    }

}
