package ph.apper.android.pagatpatan.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.list_items
import kotlinx.android.synthetic.main.shop_cart.*
import ph.apper.android.pagatpatan.ecommerce.adapters.ListAdapter

class ShopActivity : AppCompatActivity() {

    var myList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shop_cart)

        btn_checkout.setOnClickListener{

        }

        myList.add("Notebook")
        myList.add("Laptop")
        myList.add("Charger")
        myList.add("Phone")
        myList.add("Tablet")

        list_items.adapter = ListAdapter(this, myList)
        list_items.layoutManager = LinearLayoutManager(this)
    }
}