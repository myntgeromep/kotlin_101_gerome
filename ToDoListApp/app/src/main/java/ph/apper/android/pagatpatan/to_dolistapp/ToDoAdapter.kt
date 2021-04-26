package ph.apper.android.pagatpatan.to_dolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ph.apper.android.pagatpatan.to_dolistapp.data.ToDo

class ToDoAdapter(private var todoList : MutableList<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ToDoAdapter.ToDoHolder {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(R.layout.item_todo, viewGroup, shouldAttachToParentImmediately)
        return ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.ToDoHolder, position: Int) {
        val item = todoList[position]
        holder.bindToDo(item)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    class ToDoHolder (v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view : View
        private lateinit var toDo : ToDo
        private var title : TextView

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

        init {
            view = v
            title = view.findViewById(R.id.title_recycler_item)
            v.setOnClickListener(this)
        }

        fun bindToDo(toDo: ToDo) {
            this.toDo = toDo
            title.text = toDo.title
        }
    }
}