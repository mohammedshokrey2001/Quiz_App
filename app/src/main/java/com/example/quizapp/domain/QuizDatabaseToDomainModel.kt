package com.example.quizapp.domain

import com.example.quizapp.data.room.QuestionDatabaseModel

fun List<QuestionDatabaseModel>.asDomainModel():List<QuestionDomainModel>{
    return map {
        QuestionDomainModel(
            question = it.question,
            answerC = it.answerC,
            answerA = it.answerA,
            answerB = it.answerB,
            correctAnswer = it.correctAnswer
        )
    }
}