package earth.darkwhite.todolistdemo.util

import earth.darkwhite.todolistdemo.util.Constants.MILLIS_IN_DAY
import java.text.DateFormat

object Util {
  
  fun Long.dueDateFormatted(): String = DateFormat.getDateTimeInstance().format(this)
  fun nextDayDueDateMillis(): Long = System.currentTimeMillis() + MILLIS_IN_DAY
}