package earth.darkwhite.todolistdemo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
  
  @Insert
  suspend fun insertTodo(todo: Todo)
  
  @Query("SELECT * FROM todo_table order BY `index` ASC")
  fun getTodos(): Flow<List<Todo>>
}