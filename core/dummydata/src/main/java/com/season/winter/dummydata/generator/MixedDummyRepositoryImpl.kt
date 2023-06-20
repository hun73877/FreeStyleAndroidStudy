package com.season.winter.dummydata.generator

import com.season.winter.dummydata.model.MixedDummyData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MixedDummyRepositoryModule {
    @Provides
    @Singleton
    fun provideMixedDummyRepository(dao: MixedDummyDao): MixedDummyRepositoryImpl {
        return MixedDummyRepositoryImpl(dao)
    }
}

@Module
@InstallIn(SingletonComponent::class)
class MixedDummyRepositoryImpl @Inject constructor(
    private val dao: MixedDummyDao
): MixedDummyRepositoryProvider {

    override fun getRandomData(): MixedDummyData {
        return dao.getRandomData()
    }

    override suspend fun getRandomList(): List<MixedDummyData> {
        return dao.getRandomList()
    }

//    override suspend fun getRandomList(callback: (List<MixedDummyData>) -> Unit) {
//        callback(dao.getRandomList())
//    }

//    override suspend fun getRandomList(continuation: Continuation<List<MixedDummyData>>){
//        continuation.resume(dao.getRandomList())
//    }
}