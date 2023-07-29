package earth.darkwhite.todolistdemo.ui.screens.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateScreen(
  onBackClick: () -> Unit,
  viewModel: CreateViewModel
) {
  CreateScreenContent(
    onBackClick = onBackClick
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreenContent(
  onBackClick: () -> Unit
) {
  Scaffold(
    topBar = { CreateScreenTopAppBar(onClick = onBackClick) }
  ) { innerPad ->
    Column(modifier = Modifier.padding(innerPad)) {
    
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreenTopAppBar(
  onClick: () -> Unit
) {
  CenterAlignedTopAppBar(
    title = { Text(text = "Create Screen") },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    navigationIcon = {
      IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
      }
    }
  )
}


