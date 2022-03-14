package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_catagory.*

class ShoppingCatagory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_catagory)
        val userName = intent.getSerializableExtra("user");
        loggedInUserName.setText("Welcome ${userName}")
    }

//    fun toastEventHandler(view: View){
//        println("test toast")
//        var id = view.id.toString();
//        print("ID ** ${view}")
//        var categoryType: String = "";
//        when(id){
//            "electronics" -> categoryType ="Electronics"
//            "clothing" -> categoryType = "Clothing"
//            "beauty" -> categoryType = "Beauty"
//            "food" -> categoryType = "Food"
//        }
//        Toast.makeText(this,"You have chosen the ${categoryType} category of shopping",Toast.LENGTH_LONG).show()
//    }

    fun electronics(view : View){
//                Toast.makeText(this,"You have chosen the Electronics category of shopping",Toast.LENGTH_LONG).show()
        var intent = Intent(this, DetailedView::class.java)
        intent.putExtra("id", view.id)
        startActivity(intent)
    }
    fun clothing(view : View){
        Toast.makeText(this,"You have chosen the Clothing category of shopping",Toast.LENGTH_LONG).show()
    }
    fun beauty(view : View){
        Toast.makeText(this,"You have chosen the Beauty category of shopping",Toast.LENGTH_LONG).show()
    }
    fun food(view : View){
        Toast.makeText(this,"You have chosen the Food category of shopping",Toast.LENGTH_LONG).show()
    }

}