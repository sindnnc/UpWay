package com.example.core.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.core.constant.auth.AuthPreferenceKeys
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow


//TODO if ı wanna add to any type of save data on local storage add it in here
abstract class StorageService {

    abstract val dataStore: DataStore<Preferences>

    //String
    abstract suspend fun writeStringData(key: Preferences.Key<String>, data: String)
    abstract fun readStringData(key: Preferences.Key<String>): Flow<String?>

    //Int
    abstract suspend fun writeIntData(key: Preferences.Key<Int>, data: Int)
    abstract fun readIntData(key: Preferences.Key<Int>): Flow<Int?>

    //Boolean
    abstract suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean)
    abstract fun readBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean?>


}