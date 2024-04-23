package com.example.crud_api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext;
    private List<Produit> prods;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;
        TextView prix;

        public MyViewHolder(View itemView) {
            super(itemView);

            this.title = (TextView) itemView.findViewById(R.id.txtProdId);
            this.subtitle = (TextView) itemView.findViewById(R.id.txtProdname);
            this.prix = (TextView) itemView.findViewById(R.id.txtProdprix);
        }
    }

    public ProductAdapter(Context mContext, List<Produit> prods) {
        this.mContext = mContext;
        this.prods = prods;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_prod, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {
        Produit prod = prods.get(i);
        holder.title.setText(prod.getIdProduit());
        holder.subtitle.setText(prod.getNomProduit());
        holder.prix.setText(Double.valueOf(prod.getPrixProduit()).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProdActivity.class);
                intent.putExtra("id", String.valueOf(prods.get(i).getIdProduit()));
                intent.putExtra("des", prods.get(i).getNomProduit());
                intent.putExtra("pri", String.valueOf(prods.get(i).getPrixProduit()));
                mContext.startActivity(intent);
                Toast.makeText(mContext,"Position : "+i,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return prods.size();
    }
}