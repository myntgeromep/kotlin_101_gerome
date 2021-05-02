package ph.apper.android.pagatpatan.ecommerce

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.android.pagatpatan.ecommerce.adapters.ListAdapter

class MainActivity : AppCompatActivity() {

    var myList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_shop.setOnClickListener{
            shopPage()
        }

        myList.add("Notebook")
        myList.add("Laptop")
        myList.add("Charger")
        myList.add("Phone")
        myList.add("Tablet")

        list_items.adapter = ListAdapter(this, myList)
        list_items.layoutManager = LinearLayoutManager(this)
    }

    fun shopPage() {
        val intent = Intent(this, ShopActivity::class.java)
        startActivity(intent)
    }
}