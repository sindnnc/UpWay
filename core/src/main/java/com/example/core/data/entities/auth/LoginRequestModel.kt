package com.example.core.data.entities.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(val email: String, val password: String)