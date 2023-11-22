package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.model.Teacher

class TeachersViewModel : ViewModel() {
    private val teacherList = listOf(
        Teacher(
            name = "Иван Маланьин",
            isLeader = true,
            profession = "Ведущий преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher
        ),
        Teacher(
            name = "Наталья Алекперова",
            isLeader = true,
            profession = "Ведущий преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher
        ),
        Teacher(
            name = "Игорь Буйлин",
            isLeader = false,
            profession = "Преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher
        ),
        Teacher(
            name = "Екатерина Брякунова",
            isLeader = false,
            profession = "Преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher
        ),
        Teacher(
            name = "Юлия Ланкина",
            isLeader = false,
            profession = "Преподаватель по ДЖАЗ-ФАНКУ и STRIP",
            photo_min = R.drawable.img_min_teacher
        ),
        Teacher(
            name = "Юлия Ланкина",
            isLeader = false,
            profession = "Преподаватель по ДЖАЗ-ФАНКУ и STRIP",
            photo_min = R.drawable.img_min_teacher
        ),
    )
    private val _teacherListLiveData = MutableLiveData<List<Teacher>>()
    val teacherListLiveData: LiveData<List<Teacher>> = _teacherListLiveData

    init {
        _teacherListLiveData.postValue(teacherList)
    }
}