package com.example.pagingapis.data.response

import com.google.gson.annotations.SerializedName

data class ResponseWrapper (
    @SerializedName("info") val information: InfoResponse,
    @SerializedName("results") val results:List<CharacterResponse>
)