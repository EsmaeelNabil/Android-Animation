package com.esmaeel.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    ShopProductsAdapter shopProductsAdapter;
    ArrayList<ShopProductResponse.DataBean.ProductsBean> shopProducts = new ArrayList<>();
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.bottom_sheet)
    LinearLayout bottomSheet;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // for making the bottom sheet background transparent
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bottom_sheet, container, false);
        ButterKnife.bind(this, v);


        shopProducts.clear();
        for (int i = 0; i < 20; i++) {
            shopProducts.add(
                    new ShopProductResponse.DataBean.ProductsBean("Dummy name ", " Dummy description", "https://images.unsplash.com/photo-1577462206317-de0a1ab78378?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=300&q=60")
            );
        }
        shopProductsAdapter = new ShopProductsAdapter(shopProducts, getContext());
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rec.setAdapter(shopProductsAdapter);
        return v;
    }

    private static final String TAG = "CustomBottomFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        EventBus.getDefault().post(new MainActivity.fragmentAppearnece(true));
        Log.e(TAG, "onAttach:");

    }


    @Override
    public void onPause() {
        super.onPause();
//        EventBus.getDefault().post(new MainActivity.fragmentAppearnece(false));
        Log.e(TAG, "onPause: ");

    }


}