package ru.yesds.yesdsapp.data.mapper

import ru.yesds.yesdsapp.data.db.UserEntity
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.data.model.TeacherResponse
import ru.yesds.yesdsapp.domain.model.Teacher
import ru.yesds.yesdsapp.domain.model.User

object AuthMapper {
    fun AuthResponse.toUser() = User(
        username = this.userName,
        password = "",
        token = this.token
    )

    fun AuthResponse.toUserEntity() = UserEntity(
        id = this.id,
        userName = this.userName,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName,
        gender = this.gender,
        image = this.image,
        token = this.token
    )

    fun TeacherResponse.toTeacher() = Teacher(
        name = this.userName,
        isLeader = false,
        profession = this.postUser,
        photo_big = this.userPhoto.toInt(),
        photo_min = this.userPhoto.toInt(),
        description = "",
        dances_since = "",
        teaches_since = ""
    )
}