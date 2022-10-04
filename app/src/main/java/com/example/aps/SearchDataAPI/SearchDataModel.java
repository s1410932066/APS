package com.example.aps.SearchDataAPI;

import android.util.Log;

import com.example.aps.APIService.APIService;
import com.example.aps.APIService.RetrofitManager;
import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.SearchAllData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SearchDataModel implements SearchDataContract.IModel{
    SearchDataContract.IPresenter callback;
    APIService myAPIService;
    public SearchDataModel(SearchDataContract.IPresenter callback){
        this.callback = callback;
    }

    @Override
    public void SearchAllData(String token, String sale_order, String manufacture) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<SearchAllData>>> observable = myAPIService.getSearchData(token, sale_order, manufacture);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<SearchAllData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<SearchAllData>> ResponseSearchData) {
//                        Log.e("yes", listResponse.body().toString());
//                        Log.e("yes", listResponse.body().get(0).getRelated_tech_route().getTech_routing_name());
                        List<SearchAllData> searchData = ResponseSearchData.body();
                        callback.callback_P_SearchAllData(searchData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("NO", e.toString());
                    }
                });
    }


    @Override
    public void Current_id(String token, String item_id) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<GetCurrentStageData>>> observable = myAPIService.GetCurrentStage(token, item_id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<GetCurrentStageData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<GetCurrentStageData>> listResponse) {
                        List<GetCurrentStageData> getCurrentStageData = listResponse.body();
                        callback.callback_P_Current_id(getCurrentStageData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void SoId_item_id(String token, String sale_order, String online_date, String customer) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<SoIdData>>> observable = myAPIService.getSaleOrder(token, sale_order, online_date, customer);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<SoIdData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<SoIdData>> listResponse) {
                        //Log.e("yes",listResponse.body().get(0).getItem_id() );
                        List<SoIdData> SoId_item_id = listResponse.body() ;
                        callback.callback_P_SoId_item_id(SoId_item_id);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
