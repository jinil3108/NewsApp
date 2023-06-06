package com.example.newsapp.db

import android.content.Context
import androidx.room.*
import com.example.newsapp.model.News

@Database(
    entities = [News::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {
        private var instance: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news.db"
                ).fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }
}