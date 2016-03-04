package com.example.administrator.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ModelView> {

    List<String> list;
    Context context;

    public RecyclerViewAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
    }



    int i = 0;
    //填充view
    @Override
    public ModelView onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("onCreateViewHolder",(i++)+",");
        return new ModelView(View.inflate(context,R.layout.list_item,null));
    }


    //数据初始化
    @Override
    public void onBindViewHolder(ModelView holder, int position) {
        Log.e("onBindViewHolder",position+",");
        holder.tv_text.setText(list.get(position) + "");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //view holder
    public class ModelView extends RecyclerView.ViewHolder {

        public ImageView iv_img;
        public TextView tv_text;

        public ModelView(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

}