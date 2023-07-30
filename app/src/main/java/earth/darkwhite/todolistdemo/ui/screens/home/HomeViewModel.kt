package earth.darkwhite.todolistdemo.ui.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import earth.darkwhite.todolistdemo.domain.DbFetchAllResponse
import earth.darkwhite.todolistdemo.domain.DbRepository
import earth.darkwhite.todolistdemo.model.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  dbRepository: DbRepository
) : ViewModel() {
  
  var todoList by mutableStateOf<DbFetchAllResponse>(Resource.Pending)
    private set
  
  init {
    Log.d(TAG, "init: ")
    todoList = dbRepository.getTodosList()
  }
  
  companion object {
    private const val TAG = "HomeViewModel"
  }
}