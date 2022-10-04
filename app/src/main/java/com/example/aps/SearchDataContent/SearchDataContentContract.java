package com.example.aps.SearchDataContent;

import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.GetNextPartData;
import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

public interface SearchDataContentContract {
    interface IView{
        void callback_V_PreManuData(List<GetPreManuData> preManuData);
        void callback_V_CurrentStageData(List<GetCurrentStageData> currentStageData);
        void callback_V_NextPart(List<GetNextPartData> getNextPartData);
        void callback_V_SoIdData(GetSoDataData getSoDataData);
        void callback_V_SalesOrderData(List<SoIdData> getSalesOrderData);
    }
    interface IPresenter{
        void getPreManuData(String token, String so_id, String item_id);
        void getCurrentStageData(String token, String item_id);
        void getNextPartData(String token, String sale_order, String id);
        void getSoIdData(String token, String sale_order, String item);
        void getSalesOrderData(String token, String sale_order, String online_date, String customer);
        void callback_P_PreManuData(List<GetPreManuData> preManuData);
        void callback_P_CurrentStageData(List<GetCurrentStageData> currentStageData);
        void callback_P_NextPart(List<GetNextPartData> getNextPartData);
        void callback_P_SoIdData(GetSoDataData getSoDataData);
        void callback_P_SalesOrderData(List<SoIdData> getSalesOrderData);
    }
    interface IModel{
        void PreManuData(String token, String so_id, String item_id);
        void CurrentStageData(String token, String item_id);
        void NextPartData(String token, String sale_order, String id);
        void SoIdData(String token, String sale_order, String item);
        void SalesOrderData(String token, String sale_order, String online_date, String customer);
    }
}
