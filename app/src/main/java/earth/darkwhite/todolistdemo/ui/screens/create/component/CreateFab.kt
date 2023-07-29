package earth.darkwhite.todolistdemo.ui.screens.create.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import earth.darkwhite.todolistdemo.ui.screens.create.CreateEvent


@Composable
fun CreateScreenFab(
  onCreateEvent: (event: CreateEvent) -> Unit
) {
  FloatingActionButton(onClick = { onCreateEvent(CreateEvent.OnCreateTask) }) {
    Icon(imageVector = Icons.Rounded.Done, contentDescription = null)
  }
}
