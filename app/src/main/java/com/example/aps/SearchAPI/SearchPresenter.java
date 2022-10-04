package com.example.aps.SearchAPI;

import com.example.aps.DataResponse.SearchCustomer;
import com.example.aps.DataResponse.SearchSoId;

import java.util.List;

public class SearchPresenter implements SearchContract.IPresenter{

    private final SearchContract.IView callback;
    public SearchPresenter(SearchContract.IView callback) {
        this.callback = callback;
    }
    SearchModel model = new SearchModel(this);

    @Override
    public void getSo_Id(String token, String so_id) {
        model.So_Id(token, so_id);
    }

    @Override
    public void getCustomer(String token, String customer) {
        model.Customer(token, customer);
    }

//    @Override
//    public void getSaleOrder(String token, String so_id, String online_date, String customer) {
//        model.SaleOrder(token, so_id, online_date, customer);
//    }


    @Override
    public void callback_P_so_id(List<SearchSoId> searchSoIdData) {
        callback.callback_V_so_id(searchSoIdData);
    }

    @Override
    public void callback_P_customer(List<SearchCustomer> searchCustomerData) {
        callback.callback_V_customer(searchCustomerData);
    }
}
