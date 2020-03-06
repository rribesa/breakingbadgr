package br.com.gr.characters.repository

import br.com.gr.characters.CharactersAPI
import br.com.gr.characters.model.Character
import br.com.gr.characters.toGson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CharacterNetworkRepositoryTest {
    @MockK
    lateinit var apiSuccess: CharactersAPI
    @MockK
    lateinit var apiError: CharactersAPI
    private val exception = java.lang.NullPointerException("teste mock")

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        coEvery { apiSuccess.getCharacters() } returns mock()
        coEvery { apiError.getCharacters() } throws exception
        coEvery { apiSuccess.searchCaracters("walther") } returns mock()
        coEvery { apiError.searchCaracters("walther") } throws exception
    }

    @Test
    fun `ao getCharacters com api com sucesso, deve retornar Result com a lista de Character`() =
        runBlocking {
            //PREPARA
            val repository = CharacterNetworkRepository(apiSuccess)

            //EXECUTA
            val result = repository.getCharacters()

            //VALIDA
            Assert.assertTrue(result.isSuccess)
            Assert.assertFalse(result.isFailure)
            Assert.assertEquals(mock(), result.getOrNull())
            Assert.assertNull(result.exceptionOrNull())
        }

    @Test
    fun `ao getCharacters com api com error, deve retornar Result com NullpointerException`() =
        runBlocking {
            //PREPARA
            val repository = CharacterNetworkRepository(apiError)

            //EXECUTA
            val result = repository.getCharacters()

            //VALIDA
            Assert.assertTrue(result.isFailure)
            Assert.assertFalse(result.isSuccess)
            Assert.assertNull(result.getOrNull())
            Assert.assertEquals(exception, result.exceptionOrNull())
        }

    @Test
    fun `ao searchCharacters com o termo walther e api com sucesso, deve retornar Result com a lista de Character`() =
        runBlocking {
            //PREPARA
            val repository = CharacterNetworkRepository(apiSuccess)

            //EXECUTA
            val result = repository.searchCharacters("walther")

            //VALIDA
            Assert.assertTrue(result.isSuccess)
            Assert.assertFalse(result.isFailure)
            Assert.assertEquals(mock(), result.getOrNull())
            Assert.assertNull(result.exceptionOrNull())
        }

    @Test
    fun `ao searchCharacters com o termo walther e api com error, deve retornar Result com NullpointerException`() =
        runBlocking {
            //PREPARA
            val repository = CharacterNetworkRepository(apiError)

            //EXECUTA
            val result = repository.searchCharacters("walther")

            //VALIDA
            Assert.assertTrue(result.isFailure)
            Assert.assertFalse(result.isSuccess)
            Assert.assertNull(result.getOrNull())
            Assert.assertEquals(exception, result.exceptionOrNull())
        }

    private fun mock(): MutableList<Character> =
        "characters.json".toGson<MutableList<Character>>() ?: ArrayList()
}