package br.com.gr.characters.repository

import br.com.gr.characters.model.Character

interface CharacterRepository {

    suspend fun getCharacters(): Result<MutableList<Character>>

    suspend fun searchCharacters(name: String): Result<MutableList<Character>>
}