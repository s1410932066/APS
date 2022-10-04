package com.example.aps.LoginAPI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aps.Activity.MenuActivity;
import com.example.aps.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.IView {
    Button bt_login;
    EditText edit_account , edit_password;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_account = findViewById(R.id.edit_account);
        edit_password = findViewById(R.id.edit_password);

        presenter = new LoginPresenter(this);

        bt_login = findViewById(R.id.button_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edit_account.getText().toString()) || TextUtils.isEmpty(edit_password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "請輸入帳密", Toast.LENGTH_LONG).show();
                }
                else {
                    String account = edit_account.getText().toString();
                    String password = edit_password.getText().toString();
                    presenter.login(account, password);
                    //Log.e("token_save；", token_save);
                }
            }
        });
    }

    @Override
    public void callback_V_token(String token) {
        Toast.makeText(LoginActivity.this, "已配發令牌", Toast.LENGTH_SHORT).show();
        SharedPreferences getParams = getSharedPreferences("getParams", MODE_PRIVATE);
        getParams.edit().putString("token", token).commit();
        //傳送Token
        Intent intent_token = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent_token);
    }
    @Override
    public void callback_V_error(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_LONG).show();
    }
}