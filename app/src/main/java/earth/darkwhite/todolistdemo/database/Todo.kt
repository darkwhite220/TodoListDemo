package earth.darkwhite.todolistdemo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
  @PrimaryKey(autoGenerate = true)
  val index: Long = 0,
  val title: String,
  val description: String,
  val done: Boolean,
  val duoDate: Long
)
