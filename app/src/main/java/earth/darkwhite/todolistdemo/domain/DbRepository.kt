package earth.darkwhite.todolistdemo.domain

import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.model.Resource
import kotlinx.coroutines.flow.Flow

typealias DbCreateDeleteResponse = Resource<Boolean>
typealias DbFetchAllResponse = Resource<Flow<List<Todo>>>

interface DbRepository {
  
  suspend fun insertTodo(todo: Todo): DbCreateDeleteResponse
  suspend fun deleteTodo(todo: Todo): DbCreateDeleteResponse
  fun getTodosList(): DbFetchAllResponse
}