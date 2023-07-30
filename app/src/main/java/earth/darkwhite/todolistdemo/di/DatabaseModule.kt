package earth.darkwhite.todolistdemo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import earth.darkwhite.todolistdemo.database.TodoDao
import earth.darkwhite.todolistdemo.database.TodoDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
  
  @Singleton
  @Provides
  fun provideRoomDatabase(@ApplicationContext context: Context): TodoDatabase =
    Room.databaseBuilder(
      context = context,
      klass = TodoDatabase::class.java,
      name = context.packageName
    )
      .createFromAsset("todo_table.db")
      .build()
  
  @Singleton
  @Provides
  fun provideTodoDao(database: TodoDatabase): TodoDao =
    database.todoDao
}