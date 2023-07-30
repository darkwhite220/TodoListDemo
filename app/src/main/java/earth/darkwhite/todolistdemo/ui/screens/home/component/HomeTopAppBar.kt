package earth.darkwhite.todolistdemo.ui.screens.home.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar() {
  CenterAlignedTopAppBar(
    title = { Text(text = "Home Screen") }
  )
}
