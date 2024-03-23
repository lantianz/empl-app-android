package com.ltz.my_empl.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.ltz.my_empl.R;
import com.ltz.my_empl.WebActivity;
import com.ltz.my_empl.adapter.NewsAdapter;
import com.ltz.my_empl.api.Api;
import com.ltz.my_empl.api.ApiConfig;
import com.ltz.my_empl.api.Callback;
import com.ltz.my_empl.entity.NewsEntity;
import com.ltz.my_empl.entity.NewsListResponse;
import com.ltz.my_empl.entity.NewsSearchResponse;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends BaseFragment {

    NewsSearchResponse responseSearch = new NewsSearchResponse();
    NewsListResponse response = new NewsListResponse();
    private EditText et_search;
    private Button btn_search;
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private NewsAdapter newsAdapter;
    private List<NewsEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private int pageNum = 1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    newsAdapter.setDatas(datas);
                    newsAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };


    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        et_search = mRootView.findViewById(R.id.et_search);
        btn_search = mRootView.findViewById(R.id.btn_search);
        recyclerView = mRootView.findViewById(R.id.recyclerView);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(getActivity());
        recyclerView.setAdapter(newsAdapter);
        // 搜索
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    btn_search.performClick();
                    return true;
                }
                return false;
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = et_search.getText().toString().trim();
                getSearchList(keyword);
            }
        });
        // 点击item传递obj进详情页
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Serializable obj) {
//                showToast("点击了项目："+ obj.toString());
                NewsEntity newsEntity = (NewsEntity) obj;
                final String jsonData = JSON.toJSONString(newsEntity);

                Intent in = new Intent(getActivity(), WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("jsonData", jsonData);
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNum = 1;
                getNewsList(true);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                if (response != null) {
                    if (response.getPage().getTotalPage() < (pageNum + 1)) {
                        showToast("没有更多数据");
                        refreshLayout.finishLoadMore(true);
                        return;
                    }
                }
                pageNum++;
                getNewsList(false);
            }
        });
        getNewsList(true);

    }

    private void getSearchList(final String keyword) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        Api.config(ApiConfig.NEWS_LIST_SEARCH, params).getRequest(getActivity(), new Callback() {

            @Override
            public void onSuccess(final String res) {
                responseSearch = new Gson().fromJson(res, NewsSearchResponse.class);
                if (responseSearch != null && responseSearch.getCode() == 20000) {
                    List<NewsEntity> list = responseSearch.getData();
                    if (list != null && list.size() > 0) {
                        datas = list;
                        mHandler.sendEmptyMessage(0);
                        showToastAsync(responseSearch.getMessage());
                    } else {
                        showToastAsync("没有更多数据");
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                showToastAsync("网络异常");
            }
        });
    }

    private void getNewsList(final boolean isRefresh) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("pageNum", pageNum);
        params.put("pageSize", ApiConfig.PAGE_SIZE);
        Api.config(ApiConfig.NEWS_LIST_PAGE, params).getRequest(getActivity(), new Callback() {
            @Override
            public void onSuccess(final String res) {
                if (isRefresh) {
                    refreshLayout.finishRefresh(true);
                } else {
                    refreshLayout.finishLoadMore(true);
                }
                response = new Gson().fromJson(res, NewsListResponse.class);
                if (response != null && response.getCode() == 20000) {
                    List<NewsEntity> list = response.getPage().getList();
                    if (list != null && list.size() > 0) {
                        if (isRefresh) {
                            datas = list;
                        } else {
                            datas.addAll(list);
                        }
                        mHandler.sendEmptyMessage(0);
                    } else {
                        if (isRefresh) {
                            showToastAsync("暂时无数据");
                        } else {
                            showToastAsync("没有更多数据");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (isRefresh) {
                    refreshLayout.finishRefresh(true);
                } else {
                    refreshLayout.finishLoadMore(true);
                }
            }
        });
    }
}