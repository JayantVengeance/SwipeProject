package com.example.swipeproject;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder>
{

    Context context;
    List<PostPojo> list;

    public void setFilteredList(List<PostPojo> filteredList)
    {
        this.list=filteredList;
        notifyDataSetChanged();
    }
    public Adapter(Context context, List<PostPojo> list) {
        this.context = context;
        this.list = list;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView price, product_name, product_type,tax;
        ImageView image;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

                price=(TextView) itemView.findViewById(R.id.pr);
                product_name=(TextView)itemView.findViewById(R.id.pn);
                product_type=(TextView)itemView.findViewById(R.id.pt);
                tax=(TextView)itemView.findViewById(R.id.tax);
                image=(ImageView)itemView.findViewById(R.id.imageView2);
        }
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_view,parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.product_name.setText(""+list.get(position).getProduct_name());
        holder.price.setText(""+(int) list.get(position).getPrice());
        holder.product_type.setText(""+list.get(position).getProduct_type());
        holder.tax.setText(""+(int) list.get(position).getTax());


        //Loading image using Picasso
        String path=list.get(position).getImage();

        if(path.trim().length()!=0)
        Picasso.with(context.getApplicationContext()).load(list.get(position).getImage()).into(holder.image);
        else
        {
            Picasso.with(context.getApplicationContext()).load("https://assets-global.website-files.com/6009ec8cda7f305645c9d91b/601082646d6bf4446451b0a4_6002086f72b72717ae01d954_google-doc-error-message.png").into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
