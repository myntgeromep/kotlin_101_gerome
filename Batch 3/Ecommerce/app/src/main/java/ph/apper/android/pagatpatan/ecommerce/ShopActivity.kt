package ph.apper.android.pagatpatan.ecommerce

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
            showDialog()
        }

        myList.add("Notebook")
        myList.add("Laptop")
        myList.add("Charger")
        myList.add("Phone")
        myList.add("Tablet")

        list_items.adapter = ListAdapter(this, myList)
        list_items.layoutManager = LinearLayoutManager(this)
    }

    fun showDialog(){
        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Ecommerce")
        builder.setMessage("Thank you for purchasing!")
        builder.setIcon(R.mipmap.ic_launcher)

        builder.setPositiveButton("OK", {dialog, which -> dialog.dismiss(); mainPage()})

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    fun mainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}