package com.shakivhusain.listyourwork

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Word::class], version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {


    abstract fun wordDao(): WordDao


    private class WordsDatabaseCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { db ->
                scope.launch {

                }
            }
        }

        suspend fun populateDatabase(wordDao: WordDao) {
            // Delete all the content here
            wordDao.deleteAll()

            // Add Sample Word Here
            var word = Word(  word = "Hello")
            wordDao.insert(word)
            word = Word( "World")
            wordDao.insert(word)


        }
    }


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.

        @Volatile private var INSTANCE: WordRoomDatabase? = null


        fun getDatabase(context: Context, scope: CoroutineScope): WordRoomDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext, WordRoomDatabase::class.java, "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }


    }


}