package earth.darkwhite.todolistdemo.ui.screens.create

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.domain.DbCreateDeleteResponse
import earth.darkwhite.todolistdemo.domain.DbRepository
import earth.darkwhite.todolistdemo.model.Resource
import earth.darkwhite.todolistdemo.util.Util.nextDayDueDateMillis
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CreateViewModel @Inject constructor(
  private val dbRepository: DbRepository
) : ViewModel() {
  
  val todo = MutableStateFlow(
    Todo(
      title = "",
      description = "",
      isDone = false,
      dueDate = nextDayDueDateMillis()
    )
  )
  
  val dbCreateDeleteResponse = mutableStateOf<DbCreateDeleteResponse>(Resource.Pending)
  
  init {
    Log.d(TAG, "init: ")
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
        viewModelScope.launch { dbCreateDeleteResponse.value = dbRepository.insertTodo(todo.value) }
      }
      
      CreateEvent.OnDeleteTask           -> {
        viewModelScope.launch { dbCreateDeleteResponse.value = dbRepository.insertTodo(todo.value) }
      }
    }
  }
  
  companion object {
    private const val TAG = "CreateViewModel"
  }
}