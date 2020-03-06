package br.com.gr.characters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.gr.characters.repository.CharacterRepository

@Suppress("UNCHECKED_CAST")
class CharacterViewModelFactory(private val repository: CharacterRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CharacterViewModel(repository) as T
    }
}