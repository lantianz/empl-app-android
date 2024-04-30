package com.ltz.my_empl.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.ltz.my_empl.MainActivity;
import com.ltz.my_empl.R;

import java.util.Map;

public class MineFragment extends BaseFragment {

    private TextView tv_name;
    private TextView tv_gender;
    private TextView tv_student_id;
    private TextView tv_grade;
    private TextView tv_department;
    private TextView tv_major;
    private RelativeLayout rl_link;
    private RelativeLayout rl_about;
    private Button btn_logout;

    public MineFragment() {
    }

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    public static void showLinkDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("友情链接");

        final String[] links = {
                "https://cn.bing.com/",
                "https://www.baidu.com",
                "https://www.bilibili.com",
                "https://sso-443.webvpn.gxnu.edu.cn",
                "http://www.dean.gxnu.edu.cn",
                "http://gxnu.co.cnki.net"
        };

        final String[] names = {
                "必应搜索",
                "百度搜索",
                "哔哩哔哩",
                "广西师大WebVPN",
                "广西师大教务处",
                "广西师大本科毕业论文管理"
        };

        builder.setItems(names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openLink(links[which], context);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private static void openLink(String url, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

    public static void showAboutAppDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("关于APP");

        String introduction =
                "这是一个毕业生就业信息管理系统学生端的APP。\n阅览相关的、感兴趣的就业资讯；\n提交就业信息到Web管理端。";

        builder.setMessage(introduction);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void showLogoutDialog(Context context, Runnable onConfirm) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("确认退出登录");
        builder.setMessage("确定要退出登录吗?");

        builder.setPositiveButton("确定", (dialog, which) -> {
            if (onConfirm != null) {
                onConfirm.run();
            }
            dialog.dismiss();
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        tv_name = mRootView.findViewById(R.id.tv_name);
        tv_gender = mRootView.findViewById(R.id.tv_gender);
        tv_student_id = mRootView.findViewById(R.id.tv_student_id);
        tv_grade = mRootView.findViewById(R.id.tv_grade);
        tv_department = mRootView.findViewById(R.id.tv_department);
        tv_major = mRootView.findViewById(R.id.tv_major);
        rl_link = mRootView.findViewById(R.id.rl_link);
        rl_about = mRootView.findViewById(R.id.rl_about);
        btn_logout = mRootView.findViewById(R.id.btn_logout);

    }

    @Override
    protected void initData() {
        // 获取用户数据
        updateInfo();
        // link点击事件
        rl_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLinkDialog(getContext());
            }
        });
        // about点击事件
        rl_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutAppDialog(getContext());
            }
        });
        // 退出登录
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog(getContext(), new Runnable() {
                    @Override
                    public void run() {
                        removeByKey("user");
                        removeByKey("token");
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    private void updateInfo() {
        Map entity = (Map) JSON.parse(findByKey("user"));
        String str = entity.get("page").toString();
        Map obj = (Map) JSON.parse(str);

        tv_name.setText(obj.get("name").toString());
        tv_gender.setText(obj.get("gender").toString());
        tv_student_id.setText(obj.get("studentId").toString());
        tv_grade.setText(obj.get("grade").toString());
        tv_department.setText(obj.get("department").toString());
        tv_major.setText(obj.get("major").toString());
    }

}