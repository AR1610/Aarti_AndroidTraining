package com.myappgen7to8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<LangModel> langModelArrayList;
    public MyBaseAdapter(Context context, ArrayList<LangModel> langModelArrayList) {

        this.context = context;
        this.langModelArrayList = langModelArrayList;
    }

    @Override
    public int getCount() {
        return langModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return langModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.raw_custm_list,null);

        CircleImageView circleImageView = convertView.findViewById(R.id.img_data);
        TextView tvData = convertView.findViewById(R.id.tv_data);

        LangModel langModel = langModelArrayList.get(position);
        circleImageView.setImageResource(langModelArrayList.get(position).getImgLang());
        tvData.setText(langModel.getStrLang());

        return convertView;
    }
}
