package com.thingthing.thatthing.utils

import com.thingthing.thatthing.dispatcher.MockRequestDispatcher
import com.thingthing.thatthing.network.TmdbService
import mockwebserver3.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class BaseTest {

    lateinit var tmdbService: TmdbService
    private lateinit var mockWebServer: MockWebServer

    @Before
    @Throws(IOException::class)
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockRequestDispatcher()
        mockWebServer.start(8080)
        val loggingInterceptor = LoggingInterceptor.create()
        val okHttpClient = HttpClient.create(loggingInterceptor)
        tmdbService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("http://127.0.0.1:8080/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbService::class.java)
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        mockWebServer.shutdown()
    }
}