package com.example.aps.DataResponse;

import java.io.Serializable;
import java.util.List;

public class GetSoDataData implements Serializable { //裝配製令
    private related_parent_part related_parent_part;
    public class related_parent_part implements Serializable{
        private List<downstream_child> downstream_child;
        public class downstream_child implements Serializable{
            private String unit_id;
            private String unit_qty;
            private String base_qty;
            private parent parent;

            public class parent implements Serializable{
                private String material_id;
                private String bomkey_name;

                public parent(String material_id, String bomkey_name) {
                    this.material_id = material_id;
                    this.bomkey_name = bomkey_name;
                }

                public String getMaterial_id() {
                    return material_id;
                }

                public String getBomkey_name() {
                    return bomkey_name;
                }
            }

            public downstream_child(String unit_id, String unit_qty, String base_qty, GetSoDataData.related_parent_part.downstream_child.parent parent) {
                this.unit_id = unit_id;
                this.unit_qty = unit_qty;
                this.base_qty = base_qty;
                this.parent = parent;
            }

            public String getUnit_id() {
                return unit_id;
            }

            public String getUnit_qty() {
                return unit_qty;
            }

            public String getBase_qty() {
                return base_qty;
            }

            public GetSoDataData.related_parent_part.downstream_child.parent getParent() {
                return parent;
            }
        }

        public related_parent_part(List<GetSoDataData.related_parent_part.downstream_child> downstream_child) {
            this.downstream_child = downstream_child;
        }

        public List<GetSoDataData.related_parent_part.downstream_child> getDownstream_child() {
            return downstream_child;
        }
    }

    public GetSoDataData(GetSoDataData.related_parent_part related_parent_part) {
        this.related_parent_part = related_parent_part;
    }

    public GetSoDataData.related_parent_part getRelated_parent_part() {
        return related_parent_part;
    }
}
