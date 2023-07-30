package earth.darkwhite.todolistdemo.ui.screens.create.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.ui.component.mediumPad
import earth.darkwhite.todolistdemo.ui.screens.create.CreateEvent
import earth.darkwhite.todolistdemo.util.Util
import earth.darkwhite.todolistdemo.util.Util.dueDateFormatted


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskContent(
  todo: Todo,
  onCreateEvent: (event: CreateEvent) -> Unit,
) {
  todo.apply {
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(mediumPad),
      value = title,
      onValueChange = { onCreateEvent(CreateEvent.OnUpdateTitle(it)) },
      label = { Text(text = "Task title") },
      singleLine = true,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
      )
    )
    
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(mediumPad),
      value = description,
      onValueChange = { onCreateEvent(CreateEvent.OnUpdateDescription(it)) },
      label = { Text(text = "Task Description") },
      minLines = 5,
      maxLines = 8,
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Done
      )
    )
    
    var displayDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
      initialSelectedDateMillis = Util.nextDayDueDateMillis()
    )
    
    Row {
      Text(
        modifier = Modifier.padding(mediumPad),
        text = "Due date:"
      )
      Text(
        modifier = Modifier
          .padding(mediumPad)
          .clickable { displayDatePicker = true },
        text = dueDate.dueDateFormatted(),
        style = TextStyle(
          textDecoration = TextDecoration.Underline
        )
      )
    }
    
    Row(verticalAlignment = Alignment.CenterVertically) {
      Checkbox(
        checked = isDone,
        onCheckedChange = { onCreateEvent(CreateEvent.OnUpdateIsDone(it)) }
      )
      Text(text = "Task done")
    }
    
    if (displayDatePicker) {
      DatePickerDialog(
        onDismissRequest = { displayDatePicker = false },
        confirmButton = {
          Button(onClick = {
            onCreateEvent(
              CreateEvent.OnUpdateDueDate(datePickerState.selectedDateMillis ?: Util.nextDayDueDateMillis())
            )
            displayDatePicker = false
          }) {
            Text(text = "Confirm")
          }
        }) {
        DatePicker(state = datePickerState)
      }
    }
  }
}
