package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.model.Style

class StylesViewModel : ViewModel() {
    private val styleList = listOf(
        Style("ХАСТЛ", R.drawable.img_style),
        Style("ВОГ", R.drawable.img_style),
        Style("TEXT", R.drawable.img_style),
        Style("TEXT", R.drawable.img_style),
        Style("TEXT", R.drawable.img_style)
    )
    private val _styleListLiveData = MutableLiveData<List<Style>>()
    val styleListLiveData: LiveData<List<Style>> = _styleListLiveData

    init {
        _styleListLiveData.postValue(styleList)
    }
}