package ph.apper.android.pagatpatan.to_dolistapp

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.android.pagatpatan.to_dolistapp.data.DBHelper
import ph.apper.android.pagatpatan.to_dolistapp.data.DatabaseManager.DiaryEntry.COLUMN_TITLE
import ph.apper.android.pagatpatan.to_dolistapp.data.DatabaseManager.DiaryEntry.TABLE_NAME
import ph.apper.android.pagatpatan.to_dolistapp.data.DatabaseManager.DiaryEntry._ID
import ph.apper.android.pagatpatan.to_dolistapp.data.ToDo

class MainActivity : AppCompatActivity() {

    private lateinit var mDBHelper: DBHelper
    private var todoList: ArrayList<ToDo> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            insertToDo()
            onStart()
        }

        mDBHelper = DBHelper(this)
        displayDataInfo()
    }

    private fun insertToDo() {
        val titleString = et_todo.text.toString().trim() { it <= ' ' }
        val mDBHelper = DBHelper(this)
        val db = mDBHelper.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, titleString)
        }

        val rowId = db.insert(TABLE_NAME, null, values)
        if (rowId.equals(-1)) {
            Toast.makeText(this, "Problem inserting new task", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "New task #$rowId has been added", Toast.LENGTH_SHORT).show()
        }
    }


    private fun displayDataInfo() {
        val db = mDBHelper.readableDatabase

        val projection = arrayOf(_ID, COLUMN_TITLE)
        val cursor: Cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)

        val idColumnIndex = cursor.getColumnIndexOrThrow(_ID)
        val titleColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_TITLE)
        while (cursor.moveToNext()) {
            val currentId = cursor.getInt(idColumnIndex)
            val currentTitle = cursor.getString(titleColumnIndex)
            todoList.add(ToDo(currentId, currentTitle))
        }
        cursor.close()

        linearLayoutManager = LinearLayoutManager(this)
        list_todo.layoutManager = linearLayoutManager

        adapter = ToDoAdapter(todoList)
        list_todo.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        todoList.clear()
        displayDataInfo()
    }

}