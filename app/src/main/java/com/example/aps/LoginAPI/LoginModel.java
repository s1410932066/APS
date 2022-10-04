package com.example.aps.LoginAPI;

import com.example.aps.APIService.APIService;
import com.example.aps.APIService.RetrofitManager;
import com.example.aps.DataResponse.LoginData;
import com.example.aps.DataResponse.LoginUserGet;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.IModel{
    LoginContract.IPresenter callback;
    APIService myAPIService;
    public LoginModel(LoginContract.IPresenter callback){
        this.callback = callback;
    }
    @Override
    public void setToken(LoginData login1) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Single<LoginUserGet> observable = myAPIService.login(login1);
        observable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new SingleObserver<LoginUserGet>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onSuccess(LoginUserGet loginUserGet) {
                              //Log.e("OK", response.body().getToken());
                              callback.callback_P_token(loginUserGet.getToken());

                      }

                      @Override
                      public void onError(Throwable e) {
                          callback.callback_P_error("帳號或密碼有誤");
                      }
                  });

    }
}
