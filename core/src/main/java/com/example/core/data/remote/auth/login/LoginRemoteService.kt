package com.example.core.data.remote.auth.login

import com.example.core.data.entities.auth.LoginResponseModel
import com.example.core.data.entities.fake.FakeModel
import com.example.core.utils.BaseResult

interface LoginRemoteService {

    suspend fun login(): BaseResult<List<FakeModel>>
}