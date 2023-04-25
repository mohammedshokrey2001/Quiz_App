package com.example.quizapp.data.api

import retrofit2.http.GET

interface AppApiService {

    @GET("question")
   suspend fun getQuiz() : List<QuestionNetworkModel>

}