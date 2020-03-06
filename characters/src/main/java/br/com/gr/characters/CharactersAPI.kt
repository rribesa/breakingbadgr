package br.com.gr.characters

import br.com.gr.characters.model.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersAPI {

    @GET("characters")
    suspend fun getCharacters(): MutableList<Character>

    @GET("characters")
    suspend fun searchCaracters(
        @Query("name") name: String
    ): MutableList<Character>
}