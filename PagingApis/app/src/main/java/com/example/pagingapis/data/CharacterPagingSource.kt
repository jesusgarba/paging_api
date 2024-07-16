package com.example.pagingapis.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingapis.data.response.CharacterResponse
import com.example.pagingapis.data.response.ResponseWrapper
import com.example.pagingapis.presentation.model.CharacterModel
import okio.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val api: RickMortyApiService) :
    PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response: ResponseWrapper = api.getCharacters(page)
            val characters: List<CharacterResponse> = response.results

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.information.next != null) page + 1 else null

            LoadResult.Page(
                data = characters.map { it.toPresentation() },
                prevKey = prevKey, nextKey = nextKey
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }


}