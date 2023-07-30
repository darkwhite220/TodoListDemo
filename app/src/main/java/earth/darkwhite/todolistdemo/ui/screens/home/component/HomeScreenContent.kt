package earth.darkwhite.todolistdemo.ui.screens.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import earth.darkwhite.todolistdemo.domain.DbFetchAllResponse
import earth.darkwhite.todolistdemo.model.Resource
import earth.darkwhite.todolistdemo.ui.component.ProgressBar
import earth.darkwhite.todolistdemo.ui.component.mediumPad


@Composable
fun HomeScreenContent(
  todoList: DbFetchAllResponse,
  onFabClick: () -> Unit,
  onItemClick: (todoId: Long) -> Unit
) {
  val lazyListState = rememberLazyListState()
  
  Scaffold(
    topBar = { HomeScreenTopAppBar() },
    floatingActionButton = { HomeScreenFab(showFab = lazyListState.isScrollingUp(), onClick = onFabClick) }
  ) { innerPad ->
    Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      when (todoList) {
        Resource.Pending -> {
          ProgressBar()
        }
        
        is Resource.Failure -> {
          Text(text = todoList.e)
        }
        
        is Resource.Success -> {
          val data by todoList.data.collectAsStateWithLifecycle(initialValue = emptyList())
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPad),
            state = lazyListState,
            contentPadding = PaddingValues(mediumPad),
            verticalArrangement = Arrangement.spacedBy(mediumPad)
          ) {
            items(items = data) { item ->
              HomeTodoItem(
                item = item,
                onClick = { onItemClick(it) }
              )
            }
          }
        }
      }
    }
  }
}

/**
 * Returns whether the lazy list is currently scrolling up.
 */
@Composable
private fun LazyListState.isScrollingUp(): Boolean {
  var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
  var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
  return remember(this) {
    derivedStateOf {
      if (previousIndex != firstVisibleItemIndex) {
        previousIndex > firstVisibleItemIndex
      } else {
        previousScrollOffset >= firstVisibleItemScrollOffset
      }.also {
        previousIndex = firstVisibleItemIndex
        previousScrollOffset = firstVisibleItemScrollOffset
      }
    }
  }.value
}