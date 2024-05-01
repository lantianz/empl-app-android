package com.ltz.my_empl.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.ltz.my_empl.util.StringUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {

    public static Api api = new Api();
    private static OkHttpClient client;
    private static String requestUrl;
    private static HashMap<String, Object> requestParams;

    public Api() {

    }

    public static Api config(String url, HashMap<String, Object> params) {
        client = new OkHttpClient.Builder()
                .build();
        requestUrl = ApiConfig.BASE_URL("1") + url;
        requestParams = params;
        return api;
    }

    public void postRequest(Context context, final Callback callback) {
        SharedPreferences sp = context.getSharedPreferences("sp_config", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        // 2、创建RequestBody
        JSONObject jsonObject = new JSONObject(requestParams);
        String jsonStr = jsonObject.toString();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonStr);
        // 3、创建Request
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("token", token)
                .post(requestBody)
                .build();
        // 4、创建Call
        final Call call = client.newCall(request);
        // 5、异步请求
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("onFailure", "onFailure: " + e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String result = response.body().string();
                callback.onSuccess(result);
            }
        });
    }

    public void getRequest(Context context, final Callback callback) {
        SharedPreferences sp = context.getSharedPreferences("sp_config", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        String url = getAppendUrl(requestUrl, requestParams);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("token", token)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("onFailure", "onFailure: " + e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String result = response.body().string();

                callback.onSuccess(result);
            }
        });
    }

    private String getAppendUrl(String url, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                if (StringUtils.isEmpty(buffer.toString())) {
                    buffer.append("?");
                } else {
                    buffer.append("&");
                }
                buffer.append(entry.getKey()).append("=").append(entry.getValue());
            }
            url += buffer.toString();
        }
        return url;
    }


}
