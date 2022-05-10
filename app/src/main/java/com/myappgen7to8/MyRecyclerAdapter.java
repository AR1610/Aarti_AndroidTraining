package com.myappgen7to8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<UserModel> langModelArrayList;

    public MyRecyclerAdapter(Context context, ArrayList<UserModel> langModelArrayList) {

        this.context = context;
        this.langModelArrayList = langModelArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myview = layoutInflater.inflate(R.layout.raw_custm_list,parent,false);

        return new MyViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvData.setText(langModelArrayList.get(position).getFirst_name()+" "+langModelArrayList.get(position).getLast_name());

    }

    @Override
    public int getItemCount() {
        return langModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imgData;
        TextView tvData;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgData = itemView.findViewById(R.id.img_data);
            tvData = itemView.findViewById(R.id.tv_data);
        }
    }
}
