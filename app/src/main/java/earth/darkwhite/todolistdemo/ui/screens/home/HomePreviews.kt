package earth.darkwhite.todolistdemo.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import earth.darkwhite.todolistdemo.ui.theme.TodoListDemoTheme


@Preview
@Composable
fun HomeScreenFabPreview() {
  TodoListDemoTheme() {
    HomeScreenFab {}
  }
}

@Preview
@Composable
fun HomeScreenTopAppBarPreview() {
  TodoListDemoTheme() {
    HomeScreenTopAppBar()
  }
}