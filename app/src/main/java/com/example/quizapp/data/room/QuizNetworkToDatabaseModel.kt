package com.example.quizapp.data.room

import com.example.quizapp.data.api.QuestionNetworkModel

fun List<QuestionNetworkModel>.asDatabaseModel () :List<QuestionDatabaseModel>{

    return map {
         QuestionDatabaseModel(
             question = it.question,
             answerA =  it.answerA ,
             answerB = it.answerB,
             answerC =  it.answerC,
             correctAnswer = it.correctAnswer
         )
    }
}