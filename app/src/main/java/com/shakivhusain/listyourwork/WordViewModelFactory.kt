package com.shakivhusain.listyourwork

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UnCheck CAST")
            return WordViewModel(repository = repository) as T
        }

        throw IllegalArgumentException("Unknown View Mdoel Classs")
    }
}