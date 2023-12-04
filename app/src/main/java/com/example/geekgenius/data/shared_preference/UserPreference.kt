package com.geek.app.data.shared_preference

import android.content.SharedPreferences
import androidx.core.content.edit
import com.geek.app.model.User

class UserPreference(
    private val pref: SharedPreferences
) {
    fun saveData(user: User) {
        pref.edit {
            putString(EMAIL_KEY, user.email)
            putString(USERNAME_KEY, user.username)
            putString(PASSWORD_KEY, user.password)
        }
    }

    fun getData(): User {
        return User(
            username = pref.getString(USERNAME_KEY, "") ?: "",
            email = pref.getString(EMAIL_KEY, "") ?: "",
            password = pref.getString(PASSWORD_KEY, "") ?: "",
        )
    }

    fun clearData() {
        pref.edit().clear().apply()
    }

    companion object {
        const val EMAIL_KEY = "email_key"
        const val USERNAME_KEY = "username_key"
        const val PASSWORD_KEY = "password_key"
    }
}