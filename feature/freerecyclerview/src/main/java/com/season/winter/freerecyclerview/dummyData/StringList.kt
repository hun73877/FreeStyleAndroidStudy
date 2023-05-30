package com.season.winter.freerecyclerview.dummyData


private fun createDummyStringList(itemCount: Int): List<String> {
    val list = mutableListOf<String>()
    repeat(itemCount) { i ->
        list.add(i.toString())
    }
    return list
}

val stringDummyItem = createDummyStringList(8)

