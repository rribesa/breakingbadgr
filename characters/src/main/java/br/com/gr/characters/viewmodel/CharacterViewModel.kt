package br.com.gr.characters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gr.characters.model.Character
import br.com.gr.characters.repository.CharacterRepository
import br.com.gr.characters.viewmodel.states.CharacterListInteractor
import br.com.gr.characters.viewmodel.states.CharacterListViewState
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val characterListState: MutableLiveData<CharacterListViewState> = MutableLiveData()
    val characterListStateView: LiveData<CharacterListViewState> = characterListState

    private val characterList: MutableLiveData<MutableList<Character>> = MutableLiveData()
    val characterListResult: LiveData<MutableList<Character>> = characterList

    fun init() {
        viewModelScope.launch {
            characterListState.postValue(CharacterListViewState.Loading())
            val result = repository.getCharacters()
            result.getOrNull()?.let {
                characterList.postValue(it)
            } ?: result.exceptionOrNull()?.let {
                characterListState.postValue(CharacterListViewState.ErrorList(it))
            }
        }
    }

    fun interpret(interactor: CharacterListInteractor) {
        when (interactor) {
            is CharacterListInteractor.ClickItemListaCharacter -> navigateDetail(interactor.character)
            is CharacterListInteractor.ClickImageCharacter -> navigateImage()
        }
    }

    private fun navigateImage() {
    }

    private fun navigateDetail(character: Character) {
        characterListState.postValue(CharacterListViewState.NavigateDetail(character))
    }
}