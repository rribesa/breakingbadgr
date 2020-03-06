package br.com.gr.characters.viewmodel.states

import br.com.gr.characters.model.Character

sealed class CharacterListInteractor {
    data class ClickItemListaCharacter(val character: Character):CharacterListInteractor()
    object ClickImageCharacter:CharacterListInteractor()
}