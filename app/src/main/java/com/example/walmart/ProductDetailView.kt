package com.example.walmart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_product_detail_view.*

class ProductDetailView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail_view)
//
        if (intent.hasExtra("image")
            && intent.hasExtra("title")
            && intent.hasExtra("desc")
            && intent.hasExtra("color")
            && intent.hasExtra("itemId")
        ) {
            var imageId = intent.getIntExtra("image", 0)
            var title = intent.getStringExtra("title")
            var color = intent.getStringExtra("color")
            var desc = intent.getStringExtra("desc")
            var itemId = intent.getStringExtra("itemId")
            product_title.text = title;
            product_color.text = getString(R.string.product_color, color)
            productId.text = getString(R.string.walmart_item_id, itemId)
            product_description.text = desc
            imageView2.setImageResource(imageId)
        }
    }
}