package com.example.core.base.resource

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map


fun <T> baseReadFlowResource(flow: Flow<Preferences>, key: Preferences.Key<T>): Flow<T?> =
    flow.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }
    .map { preferences ->
        val data: T? = preferences[key]
        data
    }

