package com.example.aps.LoginAPI;

import com.example.aps.DataResponse.LoginData;

public class LoginPresenter implements LoginContract.IPresenter{
    private final LoginContract.IView callback;
    public LoginPresenter(LoginContract.IView callback) {
        this.callback = callback;
    }
    LoginModel model = new LoginModel(this);
    @Override
    public void login(String account, String password) {
        LoginData login1 = new LoginData(account, password);
        model.setToken(login1);

    }

    @Override
    public void callback_P_token(String token) {
        callback.callback_V_token(token);
    }

    @Override
    public void callback_P_error(String error) {
        callback.callback_V_error(error);
    }
}
