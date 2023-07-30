package earth.darkwhite.todolistdemo.ui.screens.create

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.domain.DbCUDResponse
import earth.darkwhite.todolistdemo.domain.DbRepository
import earth.darkwhite.todolistdemo.model.Resource
import earth.darkwhite.todolistdemo.util.Constants.EDIT_ID_DEFAULT_VALUE
import earth.darkwhite.todolistdemo.util.Constants.TODO_ITEM
import earth.darkwhite.todolistdemo.util.Util.nextDayDueDateMillis
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CreateViewModel @Inject constructor(
  private val dbRepository: DbRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel() {
  
  private val todoId: Long = savedStateHandle[TODO_ITEM] ?: EDIT_ID_DEFAULT_VALUE
  
  val todo = MutableStateFlow(
    Todo(
      title = "",
      description = "",
      isDone = false,
      dueDate = nextDayDueDateMillis()
    )
  )
  
  val dbCUDResponse = mutableStateOf<DbCUDResponse>(Resource.Pending)
  
  init {
    Log.d(TAG, "init: ")
    if (todoId != EDIT_ID_DEFAULT_VALUE) {
      viewModelScope.launch {
        when (val temp = dbRepository.getTodoItem(todoId)) {
          Resource.Pending    -> {}
          is Resource.Failure -> {
            dbCUDResponse.value = temp
          }
          
          is Resource.Success -> {
            todo.update {
              it.copy(
                index = temp.data.index,
                title = temp.data.title,
                description = temp.data.description,
                isDone = temp.data.isDone,
                dueDate = temp.data.dueDate
              )
            }
          }
        }
      }
    }
  }
  
  fun onEvent(event: CreateEvent) {
    when (event) {
      is CreateEvent.OnUpdateTitle       -> {
        todo.update { it.copy(title = event.newValue) }
      }
      
      is CreateEvent.OnUpdateDescription -> {
        todo.update { it.copy(description = event.newValue) }
      }
      
      is CreateEvent.OnUpdateIsDone      -> {
        todo.update { it.copy(isDone = event.newValue) }
      }
      
      is CreateEvent.OnUpdateDueDate     -> {
        todo.update { it.copy(dueDate = event.newValue) }
      }
      
      CreateEvent.OnCreateTask           -> {
        // Data checks go here: exp need title or description not be empty
        viewModelScope.launch { dbCUDResponse.value = dbRepository.insertTodo(todo.value) }
      }
      
      CreateEvent.OnDeleteTask           -> {
        viewModelScope.launch { dbCUDResponse.value = dbRepository.deleteTodo(todo.value) }
      }
    }
  }
  
  companion object {
    private const val TAG = "CreateViewModel"
  }
}