package com.baway.baiweitong.adapter;
//时间:2019.11.05
//作者:白维童
//功能:适配器
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.baiweitong.bean.JDBean;
import com.baway.baiweitong.day1105.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private List<JDBean.GriddataBean> list;
    private Context context;

    public GridAdapter(List<JDBean.GriddataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.layout_item,null);
            viewHolder.imageView = convertView.findViewById(R.id.image_view);
            viewHolder.textView = convertView.findViewById(R.id.text_view);
            viewHolder.textView2 = convertView.findViewById(R.id.text_view2);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImageurl()).into(viewHolder.imageView);
        viewHolder.textView.setText(list.get(position).getTitle());
        viewHolder.textView2.setText(list.get(position).getPrice());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView,textView2;
    }
}
