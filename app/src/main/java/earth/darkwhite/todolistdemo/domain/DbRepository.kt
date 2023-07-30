package earth.darkwhite.todolistdemo.domain

import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.model.Resource
import kotlinx.coroutines.flow.Flow

typealias DbCUDResponse = Resource<Boolean>
typealias DbFetchAllResponse = Resource<Flow<List<Todo>>>

interface DbRepository {
  
  suspend fun insertTodo(todo: Todo): DbCUDResponse
  suspend fun deleteTodo(todo: Todo): DbCUDResponse
  suspend fun getTodoItem(todoId: Long): Resource<Todo>
  fun getTodosList(): DbFetchAllResponse
}