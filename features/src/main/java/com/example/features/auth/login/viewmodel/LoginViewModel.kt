package com.example.features.auth.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.remote.auth.login.LoginRemoteService
import com.example.core.data.repository.auth.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRemoteService: LoginRemoteService
) : ViewModel() {

    fun userLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            val value = loginRemoteService.login()
            Log.d("FakeRepositoryTest", value.data.toString())
        }
    }

}