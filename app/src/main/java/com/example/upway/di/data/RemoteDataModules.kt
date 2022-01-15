package com.example.upway.di.data

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.websocket.*

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModules {

    fun provideKtorClient() : HttpClient =
        HttpClient(CIO) {
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }




}