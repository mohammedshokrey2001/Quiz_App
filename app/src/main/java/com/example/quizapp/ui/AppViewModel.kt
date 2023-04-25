package com.example.quizapp.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.room.getDatabase
import com.example.quizapp.domain.AppRepository
import com.example.quizapp.domain.QuestionDomainModel
import com.example.quizapp.domain.asDomainModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AppRepository(getDatabase(application))
    private lateinit var questions: List<QuestionDomainModel>
    private var _score: Int = 0
    val notifyDownloadComplete: MutableLiveData<Boolean> = MutableLiveData(false)
    val score get() = _score
    private lateinit var _question: MutableLiveData<QuestionDomainModel>
    var indx = 0
    var name = "user"
    var questionNumber: Int = 0
    lateinit var data: MutableLiveData<QuestionDomainModel>
  var completeTheQuiz = false
    init {
        viewModelScope.launch {
            repository.cachingData()
            getData()
            data = MutableLiveData(questions[indx])
            questionNumber = questions.size
            notifyDownloadComplete.postValue(true)
        }

    }


    fun notifyStart() {
        Log.i("TAG", "notify: done")
    }


    private suspend fun getData() {
        questions = repository.questions.asDomainModel()
        delay(2000)
        Log.i("TAG254", "getData: $questions")
        _question = MutableLiveData(questions[0])

    }


    fun submit(answer: String, question: QuestionDomainModel) {
        if (answer == question.correctAnswer) {
            _score += 1
        }
        if (indx <questionNumber-1) {
            indx += 1
            data.postValue(questions[indx])

        }else{
            completeTheQuiz = true
        }

        Log.i("QuestionViewTag", "submit: score is : $_score")
    }


}

