package com.example.core.base.resource

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.core.data.local.preferences.dataStore

suspend fun <T> baseWriteFlowResource(context: Context, key: Preferences.Key<T>, data: T) {
    context.dataStore.edit { preferences ->
        preferences[key] = data
    }
}