package br.com.gr.characters.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import br.com.gr.breakingbadservice.WebClient
import br.com.gr.characters.CharactersAPI

import br.com.gr.characters.R
import br.com.gr.characters.repository.CharacterNetworkRepository
import br.com.gr.characters.viewmodel.CharacterViewModel
import br.com.gr.characters.viewmodel.CharacterViewModelFactory

class CharacterListFragment : Fragment() {
    lateinit var api:CharactersAPI
    val repository by lazy { CharacterNetworkRepository(api) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        api = WebClient.service()
        initObservers()
    }

    private fun initObservers() {
    }
}
