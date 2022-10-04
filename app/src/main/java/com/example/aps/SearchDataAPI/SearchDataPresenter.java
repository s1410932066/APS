package com.example.aps.SearchDataAPI;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

public class SearchDataPresenter implements SearchDataContract.IPresenter{
    SearchDataContract.IView callback;
    public SearchDataPresenter(SearchDataContract.IView callback){
        this.callback = callback;
    }
    SearchDataModel model = new SearchDataModel(this);

    @Override
    public void getSearchAllData(String token, String sale_order, String manufacture) {
        model.SearchAllData(token, sale_order, manufacture);
    }


    @Override
    public void getCurrent_id(String token, String item_id) {
        model.Current_id(token, item_id);
    }

    @Override
    public void getSoId_item_id(String token, String sale_order, String online_date, String customer) {
        model.SoId_item_id(token, sale_order ,online_date, customer);
    }


    @Override
    public void callback_P_SearchAllData(List<SearchAllData> searchData) {
        callback.callback_V_SearchAllData(searchData);
    }

    @Override
    public void callback_P_SoId_item_id(List<SoIdData> SoId_item_id) {
        callback.callback_V_SoId_item_id(SoId_item_id);
    }

    @Override
    public void callback_P_Current_id(List<GetCurrentStageData> getCurrentStageData) {
        callback.callback_V_Current_id(getCurrentStageData);
    }
}
