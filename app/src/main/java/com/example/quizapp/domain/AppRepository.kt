package com.example.quizapp.domain

import android.util.Log
import androidx.fragment.app.activityViewModels
import com.example.quizapp.data.api.AppApi
import com.example.quizapp.data.api.QuestionNetworkModel
import com.example.quizapp.data.room.QuestionDatabaseModel
import com.example.quizapp.data.room.QuizRoom
import com.example.quizapp.data.room.asDatabaseModel
import com.example.quizapp.ui.AppViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository (private val database:QuizRoom){


 var questions: List<QuestionDatabaseModel> = database.quizDao.getAllQuizzes()
    private  val TAG = "caching"

    suspend fun cachingData(){

        withContext(Dispatchers.IO){

            val responseCache :List<QuestionNetworkModel> = AppApi.quizApi.getQuiz()

            Log.i(TAG, "cachingData: ${responseCache.toString()}")


            database.quizDao.insertAll(*responseCache.asDatabaseModel().toTypedArray())
        }



    }

}