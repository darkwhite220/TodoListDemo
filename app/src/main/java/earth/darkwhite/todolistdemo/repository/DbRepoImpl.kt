package earth.darkwhite.todolistdemo.repository

import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.database.TodoDao
import earth.darkwhite.todolistdemo.domain.DbCUDResponse
import earth.darkwhite.todolistdemo.domain.DbFetchAllResponse
import earth.darkwhite.todolistdemo.domain.DbRepository
import earth.darkwhite.todolistdemo.model.Resource
import javax.inject.Inject


class DbRepoImpl @Inject constructor(
  private val todoDao: TodoDao
) : DbRepository {
  
  override suspend fun insertTodo(todo: Todo): DbCUDResponse {
    return try {
      todoDao.insertTodo(todo)
      Resource.Success(true)
    } catch (e: Exception) {
      Resource.Failure(e.localizedMessage.orEmpty())
    }
  }
  
  override suspend fun deleteTodo(todo: Todo): DbCUDResponse {
    return try {
      todoDao.deleteTodo(todo)
      Resource.Success(true)
    } catch (e: Exception) {
      Resource.Failure(e.localizedMessage.orEmpty())
    }
  }
  
  override suspend fun getTodoItem(todoId: Long): Resource<Todo> {
    return try {
      Resource.Success(todoDao.getTodoItem(todoId))
    } catch (e: Exception) {
      Resource.Failure(e.localizedMessage.orEmpty())
    }
  }
  
  override fun getTodosList(): DbFetchAllResponse {
    return try {
      Resource.Success(todoDao.getTodoList())
    } catch (e: Exception) {
      Resource.Failure(e.localizedMessage.orEmpty())
    }
  }
}