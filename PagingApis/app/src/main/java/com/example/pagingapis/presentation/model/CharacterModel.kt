package com.example.pagingapis.presentation.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val image: String,
)
