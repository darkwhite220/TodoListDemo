package earth.darkwhite.todolistdemo.util

object Constants {
  const val HOME_ROUTE = "home_route"
  const val CREATE_ROUTE = "create_route"
  const val TODO_ITEM = "edit_id"
  const val CREATE_ARG_ROUTE = "$CREATE_ROUTE/{$TODO_ITEM}"
  const val EDIT_ID_DEFAULT_VALUE = -1L
  
  const val MILLIS_IN_DAY = 86400000L
}