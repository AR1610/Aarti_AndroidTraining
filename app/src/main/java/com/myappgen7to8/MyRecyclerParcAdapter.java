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

public class MyRecyclerParcAdapter extends RecyclerView.Adapter<MyRecyclerParcAdapter.MyViewHolder> {
    Context context;
    ArrayList<LangModel> langModelArrayListl;

    public MyRecyclerParcAdapter(Context context, ArrayList<LangModel> langModelArrayList) {
        this.context = context;
        this.langModelArrayListl = langModelArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myvieww = layoutInflater.inflate(R.layout.raw_custm_list, parent, false);

        return new MyViewHolder(myvieww);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imgData.setImageResource(langModelArrayListl.get(position).getImgLang());
        holder.tvData.setText(langModelArrayListl.get(position).getStrLang());

    }

    @Override
    public int getItemCount() {
        return langModelArrayListl.size();
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
