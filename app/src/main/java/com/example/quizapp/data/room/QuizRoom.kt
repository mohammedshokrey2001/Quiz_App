package com.example.quizapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase








@Database(entities = [QuestionDatabaseModel::class], version = 2, exportSchema = false)
abstract class QuizRoom():RoomDatabase (){

    abstract val quizDao:QuizDao
}

private lateinit var INSTANCE :QuizRoom


fun getDatabase(context: Context):QuizRoom{

    synchronized(QuizRoom::class) {
        if (!::INSTANCE.isInitialized) {

            INSTANCE = Room.databaseBuilder(context, QuizRoom::class.java, "quizDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
        return INSTANCE

    }














//@Database(entities = [QuestionDatabaseModel::class], version = 1, exportSchema = false)
//abstract class QuizRoom : RoomDatabase() {
//
//    abstract val quizDao: QuizDao
//}
//
//
//private lateinit var INSTANCE :QuizRoom
//
//
//fun getDatabase(context: Context):QuizRoom{
//
//
//
//    synchronized(QuizRoom::class.java){
//
//         if (!::INSTANCE.isInitialized){
//             INSTANCE = Room.databaseBuilder(
//                 context,QuizRoom::class.java,
//                 "quizDB"
//             ).fallbackToDestructiveMigration()
//                 .build()
//         }
//    }
//
//}