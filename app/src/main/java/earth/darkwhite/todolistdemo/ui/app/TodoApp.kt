package earth.darkwhite.todolistdemo.ui.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import earth.darkwhite.todolistdemo.ui.screens.create.CreateScreen
import earth.darkwhite.todolistdemo.ui.screens.home.HomeScreen
import earth.darkwhite.todolistdemo.util.Constants.CREATE_ARG_ROUTE
import earth.darkwhite.todolistdemo.util.Constants.EDIT_ID
import earth.darkwhite.todolistdemo.util.Constants.HOME_ROUTE

@Composable
fun TodoApp(
  appState: TodoAppState = rememberAppState()
) {
  Scaffold { paddingValues ->
    NavHost(
      navController = appState.navController,
      startDestination = HOME_ROUTE,
      modifier = Modifier.padding(paddingValues)
    ) {
      composable(route = HOME_ROUTE) {
        HomeScreen(
          onFabClick = { appState.navigateToCreate() },
          viewModel = hiltViewModel()
        )
      }
      composable(
        route = CREATE_ARG_ROUTE,
        arguments = listOf(navArgument(name = EDIT_ID) { type = NavType.LongType })
      ) {
        CreateScreen(
          onBackClick = { appState.onBackClick() },
          viewModel = hiltViewModel()
        )
      }
    }
  }
}