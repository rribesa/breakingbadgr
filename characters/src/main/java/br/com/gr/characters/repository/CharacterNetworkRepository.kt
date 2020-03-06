package br.com.gr.characters.repository

import br.com.gr.characters.CharactersAPI
import br.com.gr.characters.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterNetworkRepository(private val api: CharactersAPI) : CharacterRepository {
    override suspend fun getCharacters() = withContext(Dispatchers.IO) {
        try {
            Result.success(api.getCharacters())
        } catch (exception: Exception) {
            Result.failure<MutableList<Character>>(exception)
        }
    }

    override suspend fun searchCharacters(name: String) = withContext(Dispatchers.IO) {
        try {
            Result.success(api.searchCaracters(name))
        } catch (exception: Exception) {
            Result.failure<MutableList<Character>>(exception)
        }
    }
}