package earth.darkwhite.todolistdemo.ui.screens.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.ui.screens.create.component.CreateScreenFab
import earth.darkwhite.todolistdemo.ui.screens.create.component.CreateScreenTopAppBar
import earth.darkwhite.todolistdemo.ui.theme.TodoListDemoTheme

@Preview
@Composable
fun CreateScreenTopAppBarPreview() {
  TodoListDemoTheme {
    CreateScreenTopAppBar({}, {})
  }
}

@Preview
@Composable
fun CreateScreenFabPreview() {
  TodoListDemoTheme {
    CreateScreenFab {}
  }
}

@Preview
@Composable
fun CreateScreenContentPreview() {
  TodoListDemoTheme {
    CreateScreenContent(
      todo = Todo(title = "", description = "", isDone = false, dueDate = 0),
      onCreateEvent = {},
      onBackClick = {}
    )
  }
}
