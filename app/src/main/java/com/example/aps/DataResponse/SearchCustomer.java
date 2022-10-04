package com.example.aps.DataResponse;

import java.io.Serializable;

public class SearchCustomer implements Serializable {
    private String customer_name;

    public SearchCustomer(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer() {
        return customer_name;
    }
}
