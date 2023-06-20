package com.season.winter.dummydata.generator

import com.season.winter.dummydata.model.MixedDummyData
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface MixedDummyRepositoryProvider {

    fun getRandomData(): MixedDummyData

    suspend fun getRandomList(): List<MixedDummyData>
//    suspend fun getRandomList(callback: (List<MixedDummyData>) -> Unit)
//    suspend fun getRandomList(continuation: Continuation<List<MixedDummyData>>)
}