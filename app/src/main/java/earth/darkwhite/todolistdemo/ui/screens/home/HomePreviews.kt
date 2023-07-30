package earth.darkwhite.todolistdemo.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.ui.screens.home.component.HomeScreenFab
import earth.darkwhite.todolistdemo.ui.screens.home.component.HomeScreenTopAppBar
import earth.darkwhite.todolistdemo.ui.screens.home.component.HomeTodoItem
import earth.darkwhite.todolistdemo.ui.theme.TodoListDemoTheme
import earth.darkwhite.todolistdemo.util.Util


@Preview
@Composable
fun HomeScreenTopAppBarPreview() {
  TodoListDemoTheme {
    HomeScreenTopAppBar()
  }
}

@Preview
@Composable
fun HomeScreenFabPreview() {
  TodoListDemoTheme {
    HomeScreenFab(showFab = true) {}
  }
}

@Preview
@Composable
fun HomeTodoItemPreview() {
  TodoListDemoTheme {
    HomeTodoItem(
      item = Todo(
        title = "Test title",
        description = "This is a big long description to show how the text is display. This is a big long description" +
          " to show how the text is display. This is a big long description to show how the text is display. " +
          "This is a big long description to show how the text is display.",
        isDone = false,
        dueDate = Util.nextDayDueDateMillis()
      )
    ){}
  }
}