package com.ltz.my_empl;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ltz.my_empl.api.Api;
import com.ltz.my_empl.api.ApiConfig;
import com.ltz.my_empl.api.Callback;
import com.ltz.my_empl.entity.LoginResponse;
import com.ltz.my_empl.entity.StandInfoResponse;
import com.ltz.my_empl.util.StatusBar;
import com.ltz.my_empl.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private static Context sContext;
    private boolean isHide = false;
    private EditText etUsername;
    private EditText etPassword;
    private ImageView ivShowPwd;
    private boolean isLightMode = true;
    private Button btnLogin;
    private TextView tvChangeIP;
    private Call call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sContext = getApplicationContext();

        StatusBar.setStatusBarTransparent(this);
        StatusBar.setStatusBarLightMode(this, isLightMode);

        // 是否有token
        if (!StringUtils.isEmpty(findByKey("token"))) {
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
        // 更改IP按钮监听
        tvChangeIP = findViewById(R.id.tv_changeIP);
        tvChangeIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeIPDialog(MainActivity.this, new Runnable() {
                    @Override
                    public void run() {
                        // 获取标准信息
                        if (StringUtils.isEmpty(findByKey("type")) || StringUtils.isEmpty(findByKey("province")) ||
                                StringUtils.isEmpty(findByKey("city")) || StringUtils.isEmpty(findByKey("provinceCity"))) {
                            getStandardInfo(new StandardInfoCallback() {
                                @Override
                                public void onStandardInfoReceived(String[] types, String[] provinces, String[] citys, Map<String, String[]> provinceCityMap) {
                                    String strType = String.join(",", types);
                                    String strProvince = String.join(",", provinces);
                                    String strCity = String.join(",", citys);
                                    String strProvinceCity = JSON.toJSONString(provinceCityMap);
                                    insertVal("type", strType);
                                    insertVal("province", strProvince);
                                    insertVal("city", strCity);
                                    insertVal("provinceCity", strProvinceCity);
                                }

                                @Override
                                public void onFailure(Exception error) {
                                    // 处理失败情况
                                }
                            });
                        }

                    }
                });
            }
        });
    }

    public static Context getAppContext() {
        return sContext;
    }

    private void showChangeIPDialog(Context context, Runnable onConfirm) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("请输入IP地址");
        builder.setMessage("当前IP地址:"+ApiConfig.BASE_URL("0"));
        final EditText etIP = new EditText(context);
        builder.setView(etIP);
        builder.setPositiveButton("确定", (dialog, which) -> {
            ApiConfig.BASE_URL(etIP.getText().toString());
            if (onConfirm != null) {
                onConfirm.run();
            }
            dialog.dismiss();
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
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
                Looper.prepare();
                Toast.makeText(MainActivity.this, "超时", Toast.LENGTH_SHORT).show();
                Looper.loop();
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

    public interface StandardInfoCallback {
        void onStandardInfoReceived(String[] types, String[] provinces, String[] citys, Map<String, String[]> provinceCityMap);

        void onFailure(Exception error);
    }

    public void getStandardInfo(final StandardInfoCallback callback) {
        Api.config(ApiConfig.STAND_INFO, null).getRequest(this, new Callback() {

            @Override
            public void onSuccess(String res) {
                StandInfoResponse response = new Gson().fromJson(res, StandInfoResponse.class);
                String[] type = response.getData().getStandInfo().getCompany_type().toArray(new String[0]);
                String[] t_province = response.getData().getStandInfo().getProvince().toArray(new String[0]);
                String[] t_city = response.getData().getStandInfo().getCity().toArray(new String[0]);
                String[] province = Arrays.stream(t_province)
                        .distinct()
                        .toArray(String[]::new);
                String[] city = Arrays.stream(t_city)
                        .distinct()
                        .toArray(String[]::new);
                Map<String, String[]> province_city = new HashMap<>();
                // 遍历每个省份
                for (String p : province) {
                    List<String> citiesForProvince = new ArrayList<>();
                    // 遍历每个城市列表，寻找属于当前省份的城市
                    for (int i = 0; i < t_province.length; i++) {
                        if (Objects.equals(p, t_province[i])) {
                            citiesForProvince.add(t_city[i]);
                        }
                    }
                    // 将该省份的城市列表转换为数组，并放入 Map 中
                    province_city.put(p, citiesForProvince.toArray(new String[0]));
                }
                // 通过回调传递获取的数据
                callback.onStandardInfoReceived(type, province, city, province_city);
            }

            @Override
            public void onFailure(Exception error) {
                // 通过回调传递失败信息
                callback.onFailure(error);
            }
        });
    }

    public String findByKey(String key) {
        SharedPreferences sp = getSharedPreferences("sp_config", MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public void insertVal(String key, String value) {
        SharedPreferences sp = getSharedPreferences("sp_config", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }
}