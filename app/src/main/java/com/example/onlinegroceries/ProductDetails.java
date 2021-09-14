package com.example.onlinegroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    ImageView img;
    TextView proName, proDesc, proPrice;
    int image;
    ImageView back;
    String name, desc, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        image = intent.getIntExtra("image", R.drawable.b1);
        desc = intent.getStringExtra("desc");
        price = intent.getStringExtra("price");

        back = findViewById(R.id.backBtn);
        img = findViewById(R.id.bg_image);
        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.productDesc);
        proPrice = findViewById(R.id.productPrice);

        proName.setText(name);
        proDesc.setText(desc);
        proPrice.setText(price);
        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}