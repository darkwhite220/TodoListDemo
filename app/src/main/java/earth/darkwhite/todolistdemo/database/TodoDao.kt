package earth.darkwhite.todolistdemo.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
  
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertTodo(todo: Todo)
  
  @Delete
  suspend fun deleteTodo(todo: Todo)
  
  @Query("SELECT * FROM todo_table WHERE `index` = :todoId")
  suspend fun getTodoItem(todoId: Long): Todo
  
  @Query("SELECT * FROM todo_table order BY `index` ASC")
  fun getTodoList(): Flow<List<Todo>>
  
}