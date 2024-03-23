package com.ltz.my_empl.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ltz.my_empl.R;
import com.ltz.my_empl.adapter.MySpinnerAdapter;
import com.ltz.my_empl.api.Api;
import com.ltz.my_empl.api.ApiConfig;
import com.ltz.my_empl.api.Callback;
import com.ltz.my_empl.entity.EmplInfoCheckResponse;
import com.ltz.my_empl.entity.Response;
import com.ltz.my_empl.entity.StandInfoResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SubmitFragment extends BaseFragment {

    private String[] type = {""};
    private String[] province = {""};
    private String[] city = {"请先选择省份"};
    private String[] t_province;
    private String[] t_city;
    private Map<String, Object> province_city = new HashMap<>();
    private Button btn_result;
    private TextView student_id;
    private RadioGroup postgraduate_radioGroup;
    private RadioGroup on_time;
    private RadioGroup within_two;
    private EditText company_name;
    private Spinner spinner_company_type;
    private Spinner spinner_company_province;
    private Spinner spinner_company_city;
    private Button btn_date;
    private ImageView iv_submit;
    private String studentId;
    private String companyName;
    private String companyType;
    private String companyProvince;
    private String companyCity;
    private String signDate;
    private String postgraduate;
    private String emplOntime;
    private String emplWithintwo;

    public SubmitFragment() {

    }

    public static SubmitFragment newInstance() {
        SubmitFragment fragment = new SubmitFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_submit;
    }

    @Override
    protected void initView() {
        btn_result = mRootView.findViewById(R.id.btn_result);
        student_id = mRootView.findViewById(R.id.student_id);
        postgraduate_radioGroup = mRootView.findViewById(R.id.postgraduate_radioGroup);
        on_time = mRootView.findViewById(R.id.on_time);
        within_two = mRootView.findViewById(R.id.within_two);
        company_name = mRootView.findViewById(R.id.company_name);
        spinner_company_type = mRootView.findViewById(R.id.spinner_company_type);
        spinner_company_province = mRootView.findViewById(R.id.spinner_company_province);
        spinner_company_city = mRootView.findViewById(R.id.spinner_company_city);
        btn_date = mRootView.findViewById(R.id.btn_date);
        iv_submit = mRootView.findViewById(R.id.iv_submit);
    }

    @Override
    protected void initData() {
        // 获取标准信息
        getStandardInfo(getContext());

        // 获取学号
        Map entity = (Map) JSON.parse(findByKey("user"));
        String str = entity.get("page").toString();
        Map obj = (Map) JSON.parse(str);
        studentId = obj.get("studentId").toString();
        student_id.setText(studentId);

        // 审核结果
        btn_result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkResult(new CheckResultCallback() {
                    @Override
                    public void onPass() {
                        showCheckResultDialog(getActivity(), "通过");
                    }

                    @Override
                    public void onReject(String comment) {
                        showCheckResultDialog(getActivity(), comment);
                    }
                });
            }
        });

        // 单选监听
        postgraduate_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton select = mRootView.findViewById(checkedId);
                postgraduate = select.getText().toString();
            }
        });
        on_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton select = mRootView.findViewById(checkedId);
                emplOntime = select.getText().toString();
            }
        });
        within_two.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton select = mRootView.findViewById(checkedId);
                emplWithintwo = select.getText().toString();
            }
        });

        // companyName
        company_name.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                companyName = s.toString();
            }
        });

        // 设置spinner适配器
        spinner_company_type.setAdapter(new MySpinnerAdapter(getActivity(), type));
        spinner_company_province.setAdapter(new MySpinnerAdapter(getActivity(), province));
        spinner_company_city.setAdapter(new MySpinnerAdapter(getActivity(), city));
        // spinner监听
        spinner_company_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyType = type[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_company_province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyProvince = province[position];
                getCityOfProvince(companyProvince);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_company_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyCity = city[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 日期选择监听
        btn_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        signDate = String.format("%d-%s-%s", year, month >= 10 ? month : "0" + month, dayOfMonth >= 10 ? dayOfMonth : "0" + dayOfMonth);

                        btn_date.setText(signDate);
                    }
                },
                        calendar.get(Calendar.YEAR), // 年
                        calendar.get(Calendar.MONTH), // 月
                        calendar.get(Calendar.DAY_OF_MONTH)); // 日
                dialog.show();
            }
        });

        // 提交信息
        iv_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String status = "waiting";
                HashMap<String, Object> params = new HashMap<String, Object>();
                params.put("studentId", studentId);
                params.put("companyName", companyName);
                params.put("companyType", companyType);
                params.put("companyProvince", companyProvince);
                params.put("companyCity", companyCity);
                params.put("signDate", signDate);
                params.put("postgraduate", postgraduate);
                params.put("emplOntime", emplOntime);
                params.put("emplWithintwo", emplWithintwo);
                params.put("status", status);

                // post请求
                Api.config(ApiConfig.EMPL_SUBMIT, params).postRequest(getActivity(), new Callback() {

                    @Override
                    public void onSuccess(String res) {
                        Response response = new Gson().fromJson(res, Response.class);
                        if (response.getCode() == 20000) {
                            showToastAsync("提交成功");
                        } else {
                            showToastAsync("已有历史提交，请点击审核结果查看是否需要重新提交");
                        }
                    }

                    @Override
                    public void onFailure(Exception error) {
                        showToastAsync("网络错误");
                    }
                });
            }
        });

    }

    public void showCheckResultDialog(Context context, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("审核结果");
        builder.setMessage(content);
        if (!Objects.equals(content, "通过")) {
            builder.setPositiveButton("重新提交", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("studentId", studentId);
                    // 懒得写delete方法了，用post请求后端调用delete
                    Api.config(ApiConfig.EMPL_RESUBMIT, params).postRequest(getActivity(), new Callback() {

                        @Override
                        public void onSuccess(String res) {

                        }

                        @Override
                        public void onFailure(Exception error) {

                        }
                    });
                    dialog.dismiss();
                }
            });
        }

        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void checkResult(CheckResultCallback callback) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("studentId", studentId);
        Api.config(ApiConfig.EMPL_CHECK, params).getRequest(getActivity(), new Callback() {

            @Override
            public void onSuccess(String res) {
                EmplInfoCheckResponse response = new Gson().fromJson(res, EmplInfoCheckResponse.class);
                if (response.getCode() == 20000) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 审核通过
                            callback.onPass();
                        }
                    });
                } else if (response.getCode() == 20001) {
                    String status = response.getData().getStatus();
                    if (Objects.equals(status, "waiting")) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // 未审核
                                callback.onReject("未审核");
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // 审核不通过，显示审核意见
                                callback.onReject(response.getData().getIdeaComment());
                            }
                        });
                    }
                } else if (response.getCode() == 20003) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 未提交
                            callback.onReject("未提交");
                        }
                    });
                }
            }

            @Override
            public void onFailure(Exception error) {

            }
        });
    }

    public void getStandardInfo(Context mContext) {
        Api.config(ApiConfig.STAND_INFO, null).getRequest(mContext, new Callback() {

            @Override
            public void onSuccess(String res) {
                StandInfoResponse response = new Gson().fromJson(res, StandInfoResponse.class);
                type = response.getData().getStandInfo().getCompany_type().toArray(new String[0]);
                t_province = response.getData().getStandInfo().getProvince().toArray(new String[0]);
                ;
                t_city = response.getData().getStandInfo().getCity().toArray(new String[0]);
                ;
                province = Arrays.stream(t_province)
                        .distinct()
                        .toArray(String[]::new);
                city = Arrays.stream(t_city)
                        .distinct()
                        .toArray(String[]::new);
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
            }

            @Override
            public void onFailure(Exception error) {

            }
        });
    }

    public void getCityOfProvince(String selectedProvince) {
        if (province_city.containsKey(selectedProvince)) {
            // 获取所选省份的城市列表
            String[] cities = (String[]) province_city.get(selectedProvince);
            // 更新城市下拉框的适配器
            spinner_company_city.setAdapter(new MySpinnerAdapter(getActivity(), cities));
            // 默认选择设置为第一个城市
            if (cities != null) {
                companyCity = cities[0];
            }
        } else {
            // 在 Map 中找不到所选省份
            showToastAsync("未找到所选省份的城市列表");
            spinner_company_city.setAdapter(new MySpinnerAdapter(getActivity(), new String[]{"暂无城市信息"}));
            companyCity = ""; // 重置城市选择
        }
    }

    // 回调接口处理异步数据
    interface CheckResultCallback {
        void onPass();

        void onReject(String ideaComment);
    }

}