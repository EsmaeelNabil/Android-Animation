package com.esmaeel.bottomsheet;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    void init() {
        shopProducts.clear();
        for (int i = 0; i < 20; i++) {
            shopProducts.add(
                    new ShopProductResponse.DataBean.ProductsBean("Dummy name ", " Dummy description", "https://images.unsplash.com/photo-1577462206317-de0a1ab78378?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=300&q=60")
            );
        }
        shopProductsAdapter = new ShopProductsAdapter(shopProducts, getApplicationContext());
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rec.setAdapter(shopProductsAdapter);
    }

    ShopProductsAdapter shopProductsAdapter;
    ArrayList<ShopProductResponse.DataBean.ProductsBean> shopProducts = new ArrayList<>();

    @BindView(R.id.logo)
    CircleImageView logo;
    @BindView(R.id.root)
    LinearLayout root;
    CustomBottomSheetDialogFragment sheet;
    FragmentManager manager;
    @BindView(R.id.move_me)
    LinearLayout moveMe;

    BottomSheetBehavior sheetBehavior;
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.bottom_sheet)
    LinearLayout bottomSheet;

    @BindView(R.id.top_sheet)
    LinearLayout topSheet;

    @BindView(R.id.swipe_word)
    TextView swipe_word;
    @BindView(R.id.animate_me)
    LottieAnimationView animateMe;


    void hideTopSheet() {
        topSheet.setVisibility(View.INVISIBLE);
//        topSheet.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator(0.4f)).start();
    }

    void showTopSheet() {
        topSheet.setVisibility(View.VISIBLE);
        topSheet.animate().alpha(1f).setInterpolator(new AccelerateInterpolator(0.4f)).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sheet = new CustomBottomSheetDialogFragment();
        manager = getSupportFragmentManager();
        init();

        YoYo.with(Techniques.Bounce)
                .duration(1000)
                .repeat(-1)
                .playOn(logo);

//        YoYo.with(Techniques.Flash)
//                .duration(3500)
//                .repeat(-1)
//                .playOn(swipe_word);


        logo.setOnClickListener(v -> {

        });
        root.setOnClickListener(v -> {
        });

        SwipeEvents.detect(root, new SwipeEvents.SwipeCallback() {
            @Override
            public void onSwipeTop() {
                showSheet();
                hideMainViews();
            }

            @Override
            public void onSwipeRight() {
//                showToast(" right");
            }

            @Override
            public void onSwipeBottom() {
//                toggleBottomSheet();
//                showMainViews();
            }

            @Override
            public void onSwipeLeft() {
//                showToast(" left");
            }
        });


        sheetBehavior = BottomSheetBehavior.from(bottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        hideTopSheet();

//                        showMainViews();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        showTopSheet();
                        hideMainViews();
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        hideTopSheet();
                        showMainViews();
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        hideMainViews();
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                topSheet.animate().alpha(slideOffset).setInterpolator(new AccelerateInterpolator(0f)).start();

            }
        });


    }


    void hideMainViews() {
        moveMe.animate().translationY(-500).alpha(0.0f).setInterpolator(new AccelerateInterpolator(0.4f)).start();
        animateMe.animate().translationY(-500).alpha(0.0f).setInterpolator(new AccelerateInterpolator(0.4f)).start();
        moveMe.setEnabled(false);
    }

    void showMainViews() {
        moveMe.animate().translationY(0f).alpha(1.0f).setInterpolator(new DecelerateInterpolator(0.5f)).start();
        animateMe.animate().translationY(0f).alpha(1.0f).setInterpolator(new DecelerateInterpolator(0.5f)).start();
        moveMe.setEnabled(true);
    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }





    public void showSheet() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    void hideSheet() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

}
