package com.example.aps.LoginAPI;

import com.example.aps.DataResponse.LoginData;

public interface LoginContract {
    interface IView{
        void callback_V_token(String token);
        void callback_V_error(String error);
    }
    interface IPresenter{
        void login(String account, String password);
        void callback_P_token(String token);
        void callback_P_error(String error);
    }
    interface IModel{
        void setToken(LoginData login1);
    }
}
