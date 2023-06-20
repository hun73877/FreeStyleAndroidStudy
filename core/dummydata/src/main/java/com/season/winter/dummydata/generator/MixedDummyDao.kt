package com.season.winter.dummydata.generator

import com.season.winter.common.util.random.getRandomNumber
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.dummydata.model.MixedType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Module // Hilt 모듈임을 선언함
@InstallIn(SingletonComponent::class) // Application 에 설치 한다는 의미다. and 중복 실행 방지.
class MixedDummyDao {

    var cachePhotoUrls: List<String>? = null

    @Provides
    @Singleton
    fun getRandomData(): MixedDummyData {
        return MixedDummyData(
            type = MixedType.getRandom(),
            contents = getRandomText(),
            photoUrl = cachePhotoUrls?.random(),
        )
    }

    @Provides
    @Singleton
    suspend fun getRandomList(
        keyword: List<String> = listOf("cat", "dog", "animal"),
        maxTextSize: Int = 40,
    ): List<MixedDummyData> = withContext(Dispatchers.IO) {

        val setRandomNumber = getRandomNumber(
            maxValue = maxTextSize
        )
        cachePhotoUrls = getRandomPhoto(
            getCount = setRandomNumber + 5, // 사진 중복률 줄이기 위해 5장 더 다양한 이미지 불러오기
            keyword  = keyword
        )
        List(setRandomNumber) { getRandomData() }
    }
}