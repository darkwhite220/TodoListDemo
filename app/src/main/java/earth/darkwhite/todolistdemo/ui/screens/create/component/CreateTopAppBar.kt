package earth.darkwhite.todolistdemo.ui.screens.create.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import earth.darkwhite.todolistdemo.ui.screens.create.CreateEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreenTopAppBar(
  onBackClick: () -> Unit,
  onCreateEvent: (event: CreateEvent) -> Unit
) {
  CenterAlignedTopAppBar(
    title = { Text(text = "Create Screen") },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    navigationIcon = {
      IconButton(onClick = onBackClick) {
        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
      }
    },
    actions = {
      IconButton(onClick = { onCreateEvent(CreateEvent.OnDeleteTask) }) {
        Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
      }
    }
  )
}
