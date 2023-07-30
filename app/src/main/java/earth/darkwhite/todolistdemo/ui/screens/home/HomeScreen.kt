package earth.darkwhite.todolistdemo.ui.screens.home

import androidx.compose.runtime.Composable
import earth.darkwhite.todolistdemo.ui.screens.home.component.HomeScreenContent

@Composable
fun HomeScreen(
  onFabClick: () -> Unit,
  onItemClick: (todoId: Long) -> Unit,
  viewModel: HomeViewModel
) {
  val todoList = viewModel.todoList
  HomeScreenContent(
    todoList = todoList,
    onFabClick = onFabClick,
    onItemClick = onItemClick
  )
}

