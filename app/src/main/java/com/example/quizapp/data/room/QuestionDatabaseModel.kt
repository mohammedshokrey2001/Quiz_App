package com.example.quizapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_table")
data class QuestionDatabaseModel( @PrimaryKey val question :String, val answerA:String, val answerB: String, val answerC: String, val correctAnswer:String)
