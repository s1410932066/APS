package com.example.aps.SearchDataAPI;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

public interface SearchDataContract {
    interface IView{
        void callback_V_SearchAllData(List<SearchAllData> searchData);
        void callback_V_SoId_item_id(List<SoIdData> SoId_item_id);
        void callback_V_Current_id(List<GetCurrentStageData> getCurrentStageData);
    }

    interface IPresenter{
        void getSearchAllData(String token, String sale_order, String manufacture);
        void getCurrent_id(String token, String item_id);
        void getSoId_item_id(String token, String sale_order, String online_date, String customer);
        void callback_P_SearchAllData(List<SearchAllData> searchData);
        void callback_P_SoId_item_id(List<SoIdData> SoId_item_id);
        void callback_P_Current_id(List<GetCurrentStageData> getCurrentStageData);
    }

    interface IModel{
        void SearchAllData(String token, String sale_order, String manufacture);
        void Current_id(String token, String item_id);
        void SoId_item_id(String token, String sale_order, String online_date, String customer);
    }
}
