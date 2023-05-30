package com.season.winter.dummydata.generator

import com.season.winter.common.util.random.getRandomNumber
import com.season.winter.dummydata.model.MixedDummyData
import com.season.winter.dummydata.model.MixedType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MixedDummyGenerator {

    private var photoUrls: List<String>? = null

    fun getRandomData(): MixedDummyData = MixedDummyData(
        type = MixedType.getRandom(),
        contents = getRandomText(),
        photoUrl = photoUrls?.random(),
    )

    // 사진 url이 준비될 떄까지 기다리기 (runBlocking)
    suspend fun getRandomList(): List<MixedDummyData> = withContext(Dispatchers.IO) {
        val setRandomNumber = getRandomNumber()
        photoUrls = getRandomPhoto((setRandomNumber + 5)) // 사진 중복률 줄이기 위해 5장 더 다양한 이미지 불러오기
        val list = mutableListOf<MixedDummyData>().apply {
            repeat(setRandomNumber) { add(getRandomData()) }
        }
        list
    }
}