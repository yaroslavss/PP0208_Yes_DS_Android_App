package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.yesds.yesdsapp.App
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.data.repository.AuthRepositoryImpl
import ru.yesds.yesdsapp.domain.model.Teacher
import java.io.IOException
import javax.inject.Inject

class TeachersViewModel : ViewModel() {

    @Inject
    lateinit var remoteRepositoryImpl: AuthRepositoryImpl

    private val description = "О танцевальном пути Екатерины:\n" +
            "За свою танцевальную карьеру танцует такие стили как Hip-hop, Jazz-Funk, Dancehall и TWERK. \n" +
            "Участвовала в фестивалях Project 818,Fame your Choreo, также на различных городских фестивалях. На данный момент танцует и преподает TWERK и dancehall. Старается развиваться и в других стилях, \n" +
            "но предпочтение отдает более женственным направлениям.❤\n" +
            "\n" +
            "Проходила мастер-классы у потрясающих танцоров, таких как: Андрей Бойко, Паша Трутнев, DHK Mad Mike, Riley Legacy, Карина Галлямова, DHQ Daha Ice-Cream, Shorty Explora, Саныч Степченко, JEO,Nargiz Radz,Крис и Алия Bangrang, Лилу Кравцова, Claudio Blackeagle, Keatlin, Rafa Redvolcon, Claudio Blackeagle.";
    private val teacherList = listOf(
        Teacher(
            name = "Иван Маланьин",
            isLeader = true,
            profession = "Ведущий преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
        Teacher(
            name = "Наталья Алекперова",
            isLeader = true,
            profession = "Ведущий преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
        Teacher(
            name = "Игорь Буйлин",
            isLeader = false,
            profession = "Преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
        Teacher(
            name = "Екатерина Брякунова",
            isLeader = false,
            profession = "Преподаватель по ХАСТЛУ",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
        Teacher(
            name = "Юлия Ланкина",
            isLeader = false,
            profession = "Преподаватель по ДЖАЗ-ФАНКУ и STRIP",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
        Teacher(
            name = "Юлия Ланкина",
            isLeader = false,
            profession = "Преподаватель по ДЖАЗ-ФАНКУ и STRIP",
            photo_min = R.drawable.img_min_teacher,
            photo_big = R.drawable.img_big_teacher,
            description = description,
            dances_since = "Танцует с 2012 года",
            teaches_since = "Преподает с 2016 года"
        ),
    )
    private val _teacherListLiveData = MutableLiveData<List<Teacher>>()
    val teacherListLiveData: LiveData<List<Teacher>> = _teacherListLiveData

    init {
        App.instance.dagger.inject(this)
        _teacherListLiveData.postValue(teacherList)
    }

    fun getTeachers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = remoteRepositoryImpl.getTeachers()
                if (response.isSuccessful) {
                    //_loginResult.postValue(Resource.Success(response.body()!!))
                    println("!!! ${response.body()}")
                } else {
                    //_loginResult.postValue(Resource.Error(response.message()))
                }
            } catch (e: HttpException) {
                // request exception
                //_loginResult.postValue(Resource.Error(e.toString()))
            } catch (e: IOException) {
                // no internet exception
                //_loginResult.postValue(Resource.Error(e.toString()))
            }
        }
    }
}