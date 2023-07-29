package earth.darkwhite.todolistdemo.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :ViewModel(){
  
  init {
    Log.d(TAG, "init: ")
  }
  
  companion object {
    private const val TAG = "HomeViewModel"
  }
}