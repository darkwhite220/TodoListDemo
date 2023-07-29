package earth.darkwhite.todolistdemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import earth.darkwhite.todolistdemo.domain.DbRepository
import earth.darkwhite.todolistdemo.repository.DbRepoImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindModule {
  
  @Binds
  @Singleton
  abstract fun bindDbRepositoryImpl(impl: DbRepoImpl): DbRepository
}