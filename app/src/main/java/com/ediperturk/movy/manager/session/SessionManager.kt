package com.ediperturk.movy.manager.session

import android.content.Context
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.ediperturk.movy.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object {
        const val GUEST_SESSION_ID = "guest_session_id"
    }

    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getApiKey(): String {
        return BuildConfig.API_KEY
    }

    fun saveGuestSessionId(guestSessionId: String) {
        preferences.edit {
            putString(GUEST_SESSION_ID, guestSessionId)
            commit()
        }
    }
}