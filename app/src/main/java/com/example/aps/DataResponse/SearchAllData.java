package com.example.aps.DataResponse;

import java.io.Serializable;

public class SearchAllData implements Serializable {
    private String mo_id;
    private String item_id;
    private String item_name;
    private String qty;
    private String online_date;
    private String complete_date;
    private String so_id;
    private String customer;

//    public SearchAllData(String mo_id, String item_name, String qty, String online_date, String complete_date, String so_id, String customer) {
//        this.mo_id = mo_id;
//        this.item_name = item_name;
//        this.qty = qty;
//        this.online_date = online_date;
//        this.complete_date = complete_date;
//        this.so_id = so_id;
//        this.customer = customer;
//    }

    private related_tech_route related_tech_route;

    public static class related_tech_route implements Serializable{

        private String tech_routing_name;

        public related_tech_route(String tech_routing_name) {
            this.tech_routing_name = tech_routing_name;
        }

        public String getTech_routing_name() {
            return tech_routing_name;
        }
    }
    private related_parent_part related_parent_part;
    public static class related_parent_part implements Serializable{
        private String unit_id;

        public related_parent_part(String unit_id) {
            this.unit_id = unit_id;
        }

        public String getUnit_id() {
            return unit_id;
        }
    }

    public SearchAllData(String mo_id, String item_name, String qty, String online_date, String complete_date, String so_id, String customer, SearchAllData.related_tech_route related_tech_route, SearchAllData.related_parent_part related_parent_part) {
        this.mo_id = mo_id;
        this.item_name = item_name;
        this.qty = qty;
        this.online_date = online_date;
        this.complete_date = complete_date;
        this.so_id = so_id;
        this.customer = customer;
        this.related_tech_route = related_tech_route;
        this.related_parent_part = related_parent_part;
    }

    public String getMo_id() {
        return mo_id;
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

    public String getOnline_date() {
        return online_date;
    }

    public String getComplete_date() {
        return complete_date;
    }

    public String getSo_id() {
        return so_id;
    }

    public String getCustomer() {
        return customer;
    }

    public SearchAllData.related_tech_route getRelated_tech_route() {
        return related_tech_route;
    }

    public SearchAllData.related_parent_part getRelated_parent_part() {
        return related_parent_part;
    }
}
