package earth.darkwhite.todolistdemo.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import earth.darkwhite.todolistdemo.util.Constants.CREATE_ROUTE
import earth.darkwhite.todolistdemo.util.Constants.EDIT_ID_DEFAULT_VALUE

@Composable
fun rememberAppState(
  navController: NavHostController = rememberNavController(),
) = remember(
  navController
) {
  TodoAppState(
    navController
  )
}

@Stable
class TodoAppState(
  val navController: NavHostController
) {
  
  fun navigateToCreate(todoId: Int = EDIT_ID_DEFAULT_VALUE) {
    onNavigateClick("$CREATE_ROUTE/$todoId")
  }
  
  private fun onNavigateClick(route: String) {
    val navOption = navOptions {
      popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
      }
      launchSingleTop = true
      restoreState = true
    }
    navController.navigate(route = route, navOptions = navOption)
  }
  
  fun onBackClick() {
    navController.popBackStack()
  }
}
