package ru.yesds.yesdsapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.model.Style

class StylesViewModel : ViewModel() {
    private val description = "Хастл - это современный парный социальный танец.\n" +
            "Хастл достаточно прост в изучении и не требует дополнительного опыта танцевания. Его можно танцевать с любым партнером или партнершей, не заучивая предварительно схемы. За два месяца человек, пришедший в танцы, без подготовки сможет изучить основные принципы и фигуры хастла и уже смело сможет танцевать на дискотеках.\n" +
            "Хастл можно танцевать под любую музыку, в выборе музыкальных направлений практически нет ограничений: поп, диско, хаус, RnB.\n" +
            "На начальном этапе обучения хастл не требует больших физических нагрузок. Поэтому танцевать хастл могут люди всех возрастов.\n" +
            "Танцевать хастл можно где угодно, в любом кафе или клубе. Так же наша Танцевальная студия YES! проводит регулярные вечеринки, а летом любой желающий может потанцевать на open air, который мы проводим на городской набережной.\n" +
            "В России хастл активно развивается около десяти лет. Хастл очень популярен и если вы окажетесь в каком-то другом городе, то вероятнее всего там есть хастл - клуб.\n" +
            "Помимо социальной составляющей в хастле активно развита спортивная часть. Практически каждый месяц на территории России проходят 1-2 рейтинговых турнира. Самые крупные конкурсы набирают до нескольких сотен участников.";
    private val styleList = listOf(
        Style("ХАСТЛ", R.drawable.img_style, description),
        Style("ВОГ", R.drawable.img_style, description),
        Style("TEXT", R.drawable.img_style, description),
        Style("TEXT", R.drawable.img_style, description),
        Style("TEXT", R.drawable.img_style, description)
    )
    private val _styleListLiveData = MutableLiveData<List<Style>>()
    val styleListLiveData: LiveData<List<Style>> = _styleListLiveData

    init {
        _styleListLiveData.postValue(styleList)
    }
}