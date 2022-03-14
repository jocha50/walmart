package adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.ProductDetailView
import com.example.walmart.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.product_list_card_view.view.*
import model.Product

class ProductAdaptor(
    val context: Context,
    private val productList: ArrayList<Product>,
    private val img: IntArray
) : RecyclerView.Adapter<ProductAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_card_view, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.product.apply {
            productTitle.text = productList[position].title
            productPrice.text = productList[position].price.toString()
            productColor.text = productList[position].color
            productImage.setImageResource(img[position])
        }

        holder.itemView.product.setOnClickListener {
            val intent = Intent(context, ProductDetailView::class.java)

            intent.putExtra("title", productList[position].title)
            intent.putExtra("price", productList[position].price)
            intent.putExtra("color", productList[position].color)
            intent.putExtra("desc", productList[position].desc)
            intent.putExtra("itemId", productList[position].itemId)
            intent.putExtra("image", img[position])




            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}