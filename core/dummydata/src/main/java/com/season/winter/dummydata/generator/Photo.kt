package com.season.winter.dummydata.generator

import com.season.winter.dummydata.unslash.UnsplashService

suspend fun getRandomPhoto(
    getCount: Int,
    keyword: List<String>
): List<String> {
    val call = UnsplashService.create().searchPhotos(
        keyword.random(),
        perPage = getCount
    )
    val list = mutableListOf<String>()
    call.results.forEach { list.add(it.urls.small) }
    return list
}

