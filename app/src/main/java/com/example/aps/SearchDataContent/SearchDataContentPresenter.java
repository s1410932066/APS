package com.example.aps.SearchDataContent;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.GetNextPartData;
import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

public class SearchDataContentPresenter implements SearchDataContentContract.IPresenter{
    SearchDataContentContract.IView callback;
    public SearchDataContentPresenter(SearchDataContentContract.IView callback) {
        this.callback = callback;
    }
    SearchDataContentModel model = new SearchDataContentModel(this);

//    @Override
//    public void getSearchDataContentContract(String token, String so_id) {
//        model.SearchDataContentContract(token, so_id);
//    }

    @Override
    public void getPreManuData(String token, String so_id, String item_id) {
        model.PreManuData(token, so_id, item_id);
    }

    @Override
    public void getCurrentStageData(String token, String item_id) {
        model.CurrentStageData(token, item_id);
    }

    @Override
    public void getNextPartData(String token, String sale_order, String id) {
        model.NextPartData(token, sale_order, id);
    }

    @Override
    public void getSoIdData(String token, String sale_order, String item) {
        model.SoIdData(token, sale_order, item);
    }

    @Override
    public void getSalesOrderData(String token, String sale_order, String online_date, String customer) {
        model.SalesOrderData(token, sale_order, online_date, customer);
    }

//    @Override
//    public void callback_P_SearchDataContentContract(List<SearchAllData> searchContentData) {
//        callback.callback_V_SearchDataContentContract(searchContentData);
//    }

    @Override
    public void callback_P_PreManuData(List<GetPreManuData> preManuData) {
        callback.callback_V_PreManuData(preManuData);
    }

    @Override
    public void callback_P_CurrentStageData(List<GetCurrentStageData> currentStageData) {
        callback.callback_V_CurrentStageData(currentStageData);
    }

    @Override
    public void callback_P_NextPart(List<GetNextPartData> getNextPartData) {
        callback.callback_V_NextPart(getNextPartData);
    }

    @Override
    public void callback_P_SoIdData(GetSoDataData getSoDataData) {
        callback.callback_V_SoIdData(getSoDataData);
    }

    @Override
    public void callback_P_SalesOrderData(List<SoIdData> getSalesOrderData) {
        callback.callback_V_SalesOrderData(getSalesOrderData);
    }
}
