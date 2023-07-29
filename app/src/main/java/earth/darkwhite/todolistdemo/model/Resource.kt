package earth.darkwhite.todolistdemo.model

sealed class Resource<out T> {
  object Pending : Resource<Nothing>()
  
  data class Success<out T>(val data: T) : Resource<T>()
  
  data class Failure(val e: String) : Resource<Nothing>()
}