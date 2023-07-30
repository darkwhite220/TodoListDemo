package earth.darkwhite.todolistdemo.ui.screens.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreenFab(
  showFab: Boolean,
  onClick: () -> Unit
) {
  AnimatedVisibility(
    visible = showFab,
    enter = scaleIn() + fadeIn(),
    exit = scaleOut() + fadeOut(),
  ) {
    ExtendedFloatingActionButton(
      text = { Text(text = "Create Task") },
      icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = null) },
      onClick = onClick
    )
  }
}
