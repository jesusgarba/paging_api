package com.example.pagingapis.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingapis.presentation.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickyRepository @Inject constructor(val api: RickMortyApiService) {

    companion object{
        const val  MAX_ITEM = 10
        const val PREFECTH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>{
        return Pager(config = PagingConfig(pageSize = MAX_ITEM, prefetchDistance = PREFECTH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            }).flow
    }
}