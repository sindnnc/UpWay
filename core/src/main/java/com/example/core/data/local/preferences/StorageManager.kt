package com.example.core.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.core.base.resource.baseReadFlowResource
import com.example.core.base.resource.baseWriteFlowResource
import com.example.core.constant.app.AppConstant
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = AppConstant.LOCAL_STORAGE_NAME)


class StorageManager @Inject constructor(@ApplicationContext val context: Context) : StorageService() {

    override val dataStore: DataStore<Preferences> get() = context.dataStore


    override suspend fun writeStringData(key: Preferences.Key<String>, data: String) =
        baseWriteFlowResource(context, key, data)

    override fun readStringData(key: Preferences.Key<String>): Flow<String?> =
        baseReadFlowResource(dataStore.data, key)

    override suspend fun writeIntData(key: Preferences.Key<Int>, data: Int) =
        baseWriteFlowResource(context, key, data)

    override fun readIntData(key: Preferences.Key<Int>): Flow<Int?> =
        baseReadFlowResource(dataStore.data, key)

    override suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean) =
        baseWriteFlowResource(context, key, data)

    override fun readBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean?> =
        baseReadFlowResource(dataStore.data, key)


}
