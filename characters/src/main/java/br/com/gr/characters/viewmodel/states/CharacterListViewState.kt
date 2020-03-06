package br.com.gr.characters.viewmodel.states

import android.view.View
import br.com.gr.characters.model.Character

sealed class CharacterListViewState {
    data class ErrorList(val error: Throwable): CharacterListViewState()
    data class Loading(val loading: Int = View.VISIBLE) : CharacterListViewState()
    data class NavigateDetail(val character: Character): CharacterListViewState()
    data class NavigatePhoto(val navigate: Boolean = true): CharacterListViewState()
}