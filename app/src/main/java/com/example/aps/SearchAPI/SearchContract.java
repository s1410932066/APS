package com.example.aps.SearchAPI;

import com.example.aps.DataResponse.SearchCustomer;
import com.example.aps.DataResponse.SearchSoId;

import java.util.List;

public interface SearchContract {
    interface IView{
        void callback_V_so_id(List<SearchSoId> searchSoIdData);
        void callback_V_customer(List<SearchCustomer> searchCustomerData);
    }
    interface IPresenter{
        void getSo_Id(String token, String so_id);
        void getCustomer(String token, String customer);
        //void getSaleOrder(String token, String so_id, String online_date, String customer);
        void callback_P_so_id(List<SearchSoId> searchSoIdData);
        void callback_P_customer(List<SearchCustomer> searchCustomerData);
    }
    interface IModel{
        void So_Id(String token, String so_id);
        void Customer(String token, String customer);
        //void SaleOrder(String token, String so_id, String online_date,String customer);
    }
}
