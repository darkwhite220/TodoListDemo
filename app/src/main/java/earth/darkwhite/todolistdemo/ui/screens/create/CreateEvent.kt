package earth.darkwhite.todolistdemo.ui.screens.create

sealed class CreateEvent {
  data class OnUpdateTitle(val newValue: String) : CreateEvent()
  data class OnUpdateDescription(val newValue: String) : CreateEvent()
  data class OnUpdateIsDone(val newValue: Boolean) : CreateEvent()
  data class OnUpdateDueDate(val newValue: Long) : CreateEvent()
  object OnCreateTask : CreateEvent()
  object OnDeleteTask : CreateEvent()
}
