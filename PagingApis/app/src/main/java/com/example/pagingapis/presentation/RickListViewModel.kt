package com.example.pagingapis.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.pagingapis.data.RickyRepository
import com.example.pagingapis.presentation.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickListViewModel @Inject constructor(rickyRepository: RickyRepository) :ViewModel(){

    val characters: Flow<PagingData<CharacterModel>> = rickyRepository.getAllCharacters()
}