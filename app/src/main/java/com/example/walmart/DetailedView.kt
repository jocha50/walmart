package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detailed_view.*
import model.Product
import adapter.ProductAdaptor

class DetailedView : AppCompatActivity() {
    val images = intArrayOf(
        R.drawable.laptop,
        R.drawable.phone,
        R.drawable.piano,
        R.drawable.watch,
        R.drawable.speaker
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)


        val productList = ArrayList<Product>()
        productList.add(
            Product(
                "laptop",
                2000.0,
                "blue",
                "src/image/laptop",
                "12",
                "2021 Newest HP 14\" HD Laptop Light-Weight, AMD 3020e(Up to 2.6GHz), 8GB RAM, 128GB SSD + 64GB eMMC, 1 Year Office 365, WiFi, Bluetooth 5, USB Type-A&C, HDMI, Webcam, Win10, w/Ghost Manta Accessories"
            )
        )
        productList.add(
            Product(
                "Motorola One 5G Ace Phone Brand New",
                1000.0,
                "Golden",
                "src/image/phone",
                "15",
                "Motorola One 5G Ace | 2021 | 2-Day battery | Unlocked | Made for US by Motorola | 6/128GB | 48MP Camera | Hazy Silver"
            )
        )

        productList.add(
            Product(
                "piano",
                500.0,
                "white",
                "src/image/piano",
                "17",
                "RockJam 61 Key Keyboard Piano With Pitch Bend Kit, Keyboard Stand, Piano Bench, Headphones, Simply Piano App & Keynote Stickers"
            )
        )

        productList.add(
            Product(
                "smart watch",
                300.0,
                "black",
                "src/image/watch",
                "20",
                "HAFURY Android Smart Watch, Activity Fitness Tracker for Women Men, Smartwatch for Android & iOS Phones, Heart Rate Monitor, IP68 Waterproof Fitness Watch, Sleep, Calories, Step Tracker, Black"
            )
        )

        productList.add(
            Product(
                "speaker",
                100.0,
                "grey",
                "src/image/speaker",
                "10",
                "UP TO 10 HOURS OF PLAYTIME - The JBL Clip 3 features a built-in rechargeable Li-ion battery with up to 10 hours of battery life, plus a metal carabiner so you can easily hook it to your clothes, backpack, or belt loop.\n" +
                        "NOISE CANCELLING & WIRELESS STREAMING - Wirelessly stream high-quality sound from your smartphone or tablet. Plus, take crystal-clear calls from your speaker with the touch of a button, thanks to the noise and echo-cancelling speakerp"
            )
        )

        val adaptor = ProductAdaptor(this, productList, images)
        recyclerView.adapter = adaptor
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}