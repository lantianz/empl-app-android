package com.ltz.my_empl.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ltz.my_empl.R;

public class MySpinnerAdapter extends BaseAdapter {
    private String[] select_item;
    private Context context;
    private ViewHolder mViewHolder;

    public MySpinnerAdapter(Context context, String[] select_item) {
        this.select_item = select_item;
        this.context = context;
    }

    @Override
    public int getCount() {
        return select_item.length;
    }

    //获取item的标识
    @Override
    public Object getItem(int position) {
        return position;
    }

    //获取item的id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //获取item视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //判断是否有可复用的view对象，没有的话走if，有的话走else
        if (convertView == null) {
            //找到我们自定义的行布局
            convertView = View.inflate(context, R.layout.select_item, null);
            //实例化ViewHolder内部类
            mViewHolder = new ViewHolder();
            //给ViewHolder里的控件初始化，通过我们自定义的行布局
            mViewHolder.select_item = convertView.findViewById(R.id.tv_item_name);
            //给convertView设置一个标签
            convertView.setTag(mViewHolder);
        } else {
            //获取我们设置过的标签，实现复用convertView
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        //分别给每个控件设置相应的内容
        mViewHolder.select_item.setText(select_item[position]);
        //返回convertView对象
        return convertView;
    }

    //新建ViewHolder内部类，用来定义我们行布局中所用到的控件
    class ViewHolder {
        private TextView select_item;
    }
}
