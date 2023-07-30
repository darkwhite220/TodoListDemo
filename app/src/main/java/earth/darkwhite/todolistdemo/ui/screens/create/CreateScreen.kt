package earth.darkwhite.todolistdemo.ui.screens.create

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import earth.darkwhite.todolistdemo.database.Todo
import earth.darkwhite.todolistdemo.model.Resource
import earth.darkwhite.todolistdemo.ui.component.mediumPad
import earth.darkwhite.todolistdemo.ui.screens.create.component.CreateScreenFab
import earth.darkwhite.todolistdemo.ui.screens.create.component.CreateScreenTopAppBar
import earth.darkwhite.todolistdemo.ui.screens.create.component.CreateTaskContent

@Composable
fun CreateScreen(
  onBackClick: () -> Unit,
  viewModel: CreateViewModel
) {
  val todo by viewModel.todo.collectAsStateWithLifecycle()
  val dbResponse by viewModel.dbCUDResponse
  
  CreateScreenContent(
    todo = todo,
    onCreateEvent = viewModel::onEvent,
    onBackClick = onBackClick
  )
  
  when (val response = dbResponse) {
    Resource.Pending -> {}
    
    is Resource.Failure -> {
      Toast.makeText(LocalContext.current, response.e, Toast.LENGTH_SHORT).show()
    }
    
    is Resource.Success -> {
      onBackClick()
    }
  }
}

@Composable
fun CreateScreenContent(
  todo: Todo,
  onCreateEvent: (event: CreateEvent) -> Unit,
  onBackClick: () -> Unit
) {
  Scaffold(
    topBar = {
      CreateScreenTopAppBar(
        onBackClick = onBackClick,
        onCreateEvent = onCreateEvent
      )
    },
    floatingActionButton = { CreateScreenFab(onCreateEvent) }
  ) { innerPad ->
    Column(
      modifier = Modifier
        .padding(innerPad)
        .padding(mediumPad)
    ) {
      CreateTaskContent(
        todo = todo,
        onCreateEvent = onCreateEvent
      )
    }
  }
}


