package com.example.core.data.repository.auth.login

import com.example.core.data.entities.fake.FakeModel
import com.example.core.data.remote.auth.login.LoginRemoteService
import com.example.core.utils.BaseResult
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository(private val client: HttpClient) : LoginRemoteService {

    override suspend fun login(): BaseResult<List<FakeModel>> {
        return withContext(Dispatchers.IO) {
            val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")
            when (response.status.value) {
                200 -> BaseResult.Success(_data = response.receive<List<FakeModel>>())
                else -> BaseResult.Error(response.status.toString())
            }
        }
    }
}