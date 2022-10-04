package com.example.aps.SearchAPI;

import com.example.aps.APIService.APIService;
import com.example.aps.APIService.RetrofitManager;
import com.example.aps.DataResponse.SearchCustomer;
import com.example.aps.DataResponse.SearchSoId;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SearchModel implements SearchContract.IModel{

    private final SearchContract.IPresenter callback;
    APIService myAPIService;
    List<SearchSoId> arrayList = new ArrayList<SearchSoId>();

    public SearchModel(SearchContract.IPresenter callback) {
        this.callback = callback;
    }

    @Override
    public void So_Id(String token, String so_id) {
        //Log.e("hi" , token);
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<SearchSoId>>> observable = myAPIService.getSo_Id(token, so_id);
        observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new SingleObserver<Response<List<SearchSoId>>>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onSuccess(Response<List<SearchSoId>> responseSoId) {
                          List<SearchSoId> searchSoIdData = responseSoId.body();
                          callback.callback_P_so_id(searchSoIdData);
                          //Log.e("HO", searchSoIdData.toString());
                      }

                      @Override
                      public void onError(Throwable e) {

                      }
                  });

    }

    @Override
    public void Customer(String token, String customer) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<Response<List<SearchCustomer>>> observable = myAPIService.getCustomer(token,customer);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<List<SearchCustomer>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<SearchCustomer>> responseCustomer) {
                        List<SearchCustomer> searchCustomerData = responseCustomer.body();
                        //Log.e("", searchCustomerData.get(1).getCustomer());
                        callback.callback_P_customer(searchCustomerData);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

//    @Override
//    public void SaleOrder(String token, String so_id, String online_date, String customer) {
//        myAPIService = RetrofitManager.getInstance().getAPI();
//        Single<Response<List<SearchData>>> observable = myAPIService.getSaleOrder(token,so_id,online_date,customer);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<Response<List<SearchData>>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Response<List<SearchData>> listResponse) {
//                        Log.e("123123", listResponse.body().get(0).getSo_id());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("123123", e.toString());
//                    }
//                });
//    }
}
