package ru.yesds.yesdsapp.data.mapper

import ru.yesds.yesdsapp.data.model.CatResponse
import ru.yesds.yesdsapp.model.Cat

object CatMapper {
    fun CatResponse.toCat() = Cat(this[0].url)
}