package ph.apper.android.pagatpatan.to_dolistapp.data

import android.provider.BaseColumns

object DatabaseManager {

    object ToDoEntry : BaseColumns{

        const val TABLE_NAME = "todolist"
        const val _ID = BaseColumns._ID
        const val COLUMN_TITLE = "title"
    }
}