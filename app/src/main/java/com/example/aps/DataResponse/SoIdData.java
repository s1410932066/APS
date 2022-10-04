package com.example.aps.DataResponse;

import java.io.Serializable;
import java.util.List;

public class SoIdData implements Serializable {
    private String item_id;
    private List<sale_order> sale_order;
    public static class sale_order implements Serializable{
        private String so_id;
        private String item;
        private String qty;
        private String material_spec;
        private String sunit_id;
        private String untrans_qty;
        private String cu_remark;
        private String customer_name;
        private String customer_order;
        private String person_id;

        public sale_order(String so_id, String item, String qty, String material_spec, String sunit_id, String untrans_qty, String cu_remark, String customer_name, String customer_order, String person_id) {
            this.so_id = so_id;
            this.item = item;
            this.qty = qty;
            this.material_spec = material_spec;
            this.sunit_id = sunit_id;
            this.untrans_qty = untrans_qty;
            this.cu_remark = cu_remark;
            this.customer_name = customer_name;
            this.customer_order = customer_order;
            this.person_id = person_id;
        }

        public String getSo_id() {
            return so_id;
        }

        public String getItem() {
            return item;
        }

        public String getQty() {
            return qty;
        }

        public String getMaterial_spec() {
            return material_spec;
        }

        public String getSunit_id() {
            return sunit_id;
        }

        public String getUntrans_qty() {
            return untrans_qty;
        }

        public String getCu_remark() {
            return cu_remark;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public String getCustomer_order() {
            return customer_order;
        }

        public String getPerson_id() {
            return person_id;
        }
    }

    public SoIdData(String item_id, List<SoIdData.sale_order> sale_order) {
        this.item_id = item_id;
        this.sale_order = sale_order;
    }

    public String getItem_id() {
        return item_id;
    }

    public List<SoIdData.sale_order> getSale_order() {
        return sale_order;
    }
}
