package com.example.quizapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDao {

    @Query("SELECT * FROM quiz_table")
     fun getAllQuizzes() :List<QuestionDatabaseModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg quiz: QuestionDatabaseModel)

//        @Query("DELETE FROM quiz_table")
//         fun clear()
}