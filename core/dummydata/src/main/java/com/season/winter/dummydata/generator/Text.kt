package com.season.winter.dummydata.generator

import com.season.winter.common.util.random.getRandomNumber
import net.datafaker.Faker

fun getRandomText(): String = Faker().run {
    val min = getRandomNumber()
    val max = getRandomNumber(30, 100)
    text().text(min, max)
}

