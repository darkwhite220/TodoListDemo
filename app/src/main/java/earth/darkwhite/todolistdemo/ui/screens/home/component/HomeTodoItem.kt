package earth.darkwhite.todolistdemo.ui.screens.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.ui.component.mediumPad
import earth.darkwhite.todolistdemo.util.Util.dueDateFormatted


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeTodoItem(
  item: Todo,
  onClick: (itemId: Long) -> Unit
) {
  item.apply {
    OutlinedCard(
      onClick = { onClick(index) },
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(mediumPad)) {
        Text(
          text = title,
          fontWeight = FontWeight.W600,
          style = TextStyle(
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            textDecoration = if (isDone) TextDecoration.LineThrough else TextDecoration.None
          ),
          overflow = TextOverflow.Ellipsis,
          maxLines = 1
        )
        if (!isDone) {
          Text(
            text = description,
            style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
          )
        }
        Text(
          modifier = Modifier.fillMaxWidth(),
          text = dueDate.dueDateFormatted(),
          style = TextStyle(fontSize = MaterialTheme.typography.bodySmall.fontSize),
          textAlign = TextAlign.End
        )
      }
    }
  }
}
