package com.example.aps.SearchDataContent;

import com.example.aps.APIService.APIService;
import com.example.aps.APIService.RetrofitManager;
import com.example.aps.DataResponse.GetCurrentStageData;
import com.example.aps.DataResponse.GetNextPartData;
import com.example.aps.DataResponse.GetPreManuData;
import com.example.aps.DataResponse.GetSoDataData;
import com.example.aps.DataResponse.SoIdData;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SearchDataContentModel implements SearchDataContentContract.IModel{
    SearchDataContentContract.IPresenter callback;
    APIService mAPIService;
    public SearchDataContentModel(SearchDataContentContract.IPresenter callback){
        this.callback = callback;
    }

    @Override
    public void PreManuData(String token, String so_id, String item_id) {
        mAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<GetPreManuData>>> observable = mAPIService.GetPreManu(token, so_id, item_id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<GetPreManuData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<GetPreManuData>> listResponse) {
                        //Log.e("yesssss!!", listResponse.body().get(0).getItem_name());
                        List<GetPreManuData> preManuData = listResponse.body();
                        callback.callback_P_PreManuData(preManuData);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void CurrentStageData(String token, String item_id) {
        mAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<GetCurrentStageData>>> observable = mAPIService.GetCurrentStage(token, item_id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<GetCurrentStageData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<GetCurrentStageData>> listResponse) {
                        //Log.e("yesss", listResponse.body().get(0).getParent().getBomkey_name());
                        List<GetCurrentStageData> currentStageData = listResponse.body();
                        callback.callback_P_CurrentStageData(currentStageData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void NextPartData(String token, String sale_order, String id) {
        mAPIService = RetrofitManager.getInstance().getAPI();
        Single<List<GetNextPartData>> observable = mAPIService.GetNextPart(token, sale_order, id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<GetNextPartData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<GetNextPartData> getNextPartData) {
//                        Log.e("tekfjafj", getNextPartData.get(0).getRelated_top_parent().getBomkey_name());
                        callback.callback_P_NextPart(getNextPartData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void SoIdData(String token, String sale_order, String item) {
        mAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<GetSoDataData>> observable = mAPIService.GetSoData(token, sale_order, item);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<GetSoDataData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<GetSoDataData> getSoDataDataResponse) {
                        //Log.e("onSuccess: ", getSoDataDataResponse.body().getCustomer());
                        GetSoDataData getSoDataData = getSoDataDataResponse.body();
                        callback.callback_P_SoIdData(getSoDataData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void SalesOrderData(String token, String sale_order, String online_date, String customer) {
        mAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<SoIdData>>> observable = mAPIService.getSaleOrder(token, sale_order, "", "");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<SoIdData>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<SoIdData>> listResponse) {
                        List<SoIdData> getSalesOrderData = listResponse.body();
                        callback.callback_P_SalesOrderData(getSalesOrderData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
