package com.example.onlinegroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.onlinegroceries.adapter.AllCategoryAdapter;
import com.example.onlinegroceries.adapter.CategoryAdapter;
import com.example.onlinegroceries.model.AllCategoryModel;
import com.example.onlinegroceries.model.AllCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {

    RecyclerView allCategoryRecyclerView;
    AllCategoryAdapter allCategoryAdapter;
    List<AllCategoryModel> categoryModelList;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecyclerView = findViewById(R.id.allCategoryRecycler);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategory.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        categoryModelList = new ArrayList<>();
        categoryModelList.add(new AllCategoryModel(1, R.drawable.ic_cookies));
        categoryModelList.add(new AllCategoryModel(2, R.drawable.ic_dairy));
        categoryModelList.add(new AllCategoryModel(3, R.drawable.ic_drink));
        categoryModelList.add(new AllCategoryModel(4, R.drawable.ic_desert));
        categoryModelList.add(new AllCategoryModel(5, R.drawable.ic_egg));
        categoryModelList.add(new AllCategoryModel(6, R.drawable.ic_fish));
        categoryModelList.add(new AllCategoryModel(7, R.drawable.ic_juce));
        categoryModelList.add(new AllCategoryModel(8, R.drawable.ic_meat));
        categoryModelList.add(new AllCategoryModel(9, R.drawable.ic_salad));
        categoryModelList.add(new AllCategoryModel(10, R.drawable.ic_spices));
        categoryModelList.add(new AllCategoryModel(11, R.drawable.ic_veggies));

        setAllCategoryRecycler(categoryModelList);
    }

    private void setAllCategoryRecycler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,4);
        allCategoryRecyclerView.setLayoutManager(layoutManager);
        allCategoryRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(16), true));
        allCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,categoryModelList);

        allCategoryAdapter = new AllCategoryAdapter(this, allCategoryModelList);
        allCategoryRecyclerView.setAdapter(allCategoryAdapter);
    }

    //Now we need some item decoration class for Manage Spacing

    public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private final int spanCount;
        private final int spacing;
        private final boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}