package com.shakivhusain.listyourwork

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

@Entity(tableName = "word_table")
data class Word(
//    @PrimaryKey(autoGenerate = true) val idn: Int = 0,
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)

