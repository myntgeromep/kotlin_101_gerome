package ph.apper.android.pagatpatan.ecommerce.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import ph.apper.android.pagatpatan.ecommerce.R

class ListAdapter(val context: Context, val myList: ArrayList<String>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(myItem: String){
            itemView.title_recycler_item.text = myItem
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val myListItem = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false)
        return ViewHolder(myListItem)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.count()
    }
}