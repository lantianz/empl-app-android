package com.ltz.my_empl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.ltz.my_empl.api.Api;
import com.ltz.my_empl.api.ApiConfig;
import com.ltz.my_empl.api.Callback;
import com.ltz.my_empl.entity.LoginResponse;
import com.ltz.my_empl.util.StatusBar;
import com.ltz.my_empl.util.StringUtils;

import java.util.HashMap;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    private boolean isHide = false;
    private EditText etUsername;
    private EditText etPassword;
    private ImageView ivShowPwd;
    private boolean isLightMode = true;
    private Button btnLogin;
    private Call call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBar.setStatusBarTransparent(this);
        StatusBar.setStatusBarLightMode(this, isLightMode);

        // 是否有token
        if (!StringUtils.isEmpty(getStringFromSp("token"))) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        // 密码显示图标监听
        ivShowPwd = findViewById(R.id.show_password);
        ivShowPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowPassword();
            }
        });
        // 登录按钮监听
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                login(username, password);
            }
        });
    }

    private void isShowPassword() {
        if (!isHide) {
            ivShowPwd.setImageResource(R.drawable.pwd_show);
            HideReturnsTransformationMethod method1 = HideReturnsTransformationMethod.getInstance();
            etPassword.setTransformationMethod(method1);
            isHide = true;
        } else {
            ivShowPwd.setImageResource(R.drawable.pwd_hide);
            TransformationMethod method2 = PasswordTransformationMethod.getInstance();
            etPassword.setTransformationMethod(method2);
            isHide = false;
        }
        //重置光标位置
        int index = etPassword.getText().toString().length();
        etPassword.setSelection(index);
    }

    private void login(String username, String password) {
        if (!isUsernameValid(username)) {
            Toast.makeText(this, "请输入有效的账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isPasswordValid(password)) {
            Toast.makeText(this, "请输入有效的密码", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("password", password);
        // post请求
        Api.config(ApiConfig.LOGIN, params).postRequest(this, new Callback() {
            @Override
            public void onSuccess(String res) {
                // 转换JSON
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(res, LoginResponse.class);
                if (loginResponse.getCode() == 20000) {
                    String token = loginResponse.getData();
                    SharedPreferences sp = getSharedPreferences("sp_config", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("token", token);
                    editor.putString("user", res);
                    editor.apply();
                    // 跳转首页
                    Intent intent = new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    // 异步处理
                    Looper.prepare();
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                } else {
                    // 异步处理
                    Looper.prepare();
                    Toast.makeText(MainActivity.this, loginResponse.getMsg(), Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }

            @Override
            public void onFailure(Exception error) {

            }
        });
    }

    private boolean isUsernameValid(String username) {
        // 账号只包含字母和数字，限制长度6-30
        String usernamePattern = "^[a-zA-Z0-9]{6,30}$";
        return !TextUtils.isEmpty(username) && username.matches(usernamePattern);
    }

    private boolean isPasswordValid(String password) {
        // 密码限制长度至少6位
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }


    protected String getStringFromSp(String key) {
        SharedPreferences sp = getSharedPreferences("sp_config", MODE_PRIVATE);
        return sp.getString(key, "");
    }
}