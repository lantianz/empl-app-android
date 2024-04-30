package com.ltz.my_empl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltz.my_empl.R;
import com.ltz.my_empl.api.ApiConfig;
import com.ltz.my_empl.entity.NewsEntity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<NewsEntity> datas;
    private OnItemClickListener mOnItemClickListener;

    public NewsAdapter(Context context) {
        this.mContext = context;
    }

    public NewsAdapter(Context context, List<NewsEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setDatas(List<NewsEntity> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsEntity newsEntity = datas.get(position);
        ViewHolder vh = (ViewHolder) holder;
        vh.title.setText(newsEntity.getTitle());
        vh.author.setText(newsEntity.getAuthor());
        vh.send_time.setText(newsEntity.getSendTime());
        vh.newsEntity = newsEntity;
        Picasso.get()
                .load(ApiConfig.BASE_URL("1") + ApiConfig.FILE_DOWNLOAD + newsEntity.getFrontImg())
                .into(vh.front_img);
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else {
            return 0;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Serializable obj);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView author;
        private TextView send_time;
        private ImageView front_img;
        private NewsEntity newsEntity;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            send_time = view.findViewById(R.id.send_time);
            front_img = view.findViewById(R.id.front_img);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(newsEntity);
                    }
                }
            });

        }
    }

}
