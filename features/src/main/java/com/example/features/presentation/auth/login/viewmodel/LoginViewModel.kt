package com.example.features.presentation.auth.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.constant.auth.AuthPreferenceKeys
import com.example.core.data.local.preferences.StorageManager
import com.example.core.data.remote.auth.login.LoginRemoteService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRemoteService: LoginRemoteService,
    private val storageManager: StorageManager
) : ViewModel() {


    fun writeData() {
        viewModelScope.launch(Dispatchers.IO) {
            storageManager.writeStringData(AuthPreferenceKeys.MAIL, "Sinandinc333@gmail.com")
        }
    }

    fun readData() {
        viewModelScope.launch {
            storageManager.readStringData(AuthPreferenceKeys.MAIL).flowOn(Dispatchers.IO).collect {
                Log.d("DataStoreTest", it.toString())
            }
        }
    }
}