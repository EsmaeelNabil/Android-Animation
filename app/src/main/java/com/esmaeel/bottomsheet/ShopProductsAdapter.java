package com.esmaeel.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopProductsAdapter extends RecyclerView.Adapter<ShopProductsAdapter.Holder> {

    ArrayList<ShopProductResponse.DataBean.ProductsBean> products;
    Context context;
    int type;
    View listItem;



    public ShopProductsAdapter(ArrayList<ShopProductResponse.DataBean.ProductsBean> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater;
        View listItem = null;
        layoutInflater = LayoutInflater.from(parent.getContext());
        listItem = layoutInflater.inflate(R.layout.shop_fragment_item_verticalt, parent, false);
        return new Holder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ShopProductResponse.DataBean.ProductsBean model = products.get(position);

        Glide.with(context).load(model.getMain_image()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image);
        holder.productName.setText(model.getProduct_name());
        holder.productDetails.setText(model.getProduct_description());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    static
    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.product_name)
        TextView productName;
        @BindView(R.id.product_details)
        TextView productDetails;
        View view;

        Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }
}
