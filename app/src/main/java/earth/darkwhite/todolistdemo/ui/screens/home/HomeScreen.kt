package earth.darkwhite.todolistdemo.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
  onFabClick: () -> Unit,
  viewModel: HomeViewModel
) {
  HomeScreenContent(
    onFabClick = onFabClick
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
  onFabClick: () -> Unit
) {
  Scaffold(
    topBar = { HomeScreenTopAppBar() },
    floatingActionButton = { HomeScreenFab(onClick = onFabClick) }
  ) { innerPad ->
    Column(modifier = Modifier.padding(innerPad)) {
    
    }
  }
}

@Composable
fun HomeScreenFab(
  onClick: () -> Unit
) {
  ExtendedFloatingActionButton(
    text = { Text(text = "Create Task") },
    icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = null) },
    onClick = onClick
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar() {
  CenterAlignedTopAppBar(
    title = { Text(text = "Home Screen") }
  )
}
