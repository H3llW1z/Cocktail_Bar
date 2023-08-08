package com.panassevich.cocktailbar.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
data class IngredientDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cocktailId: Long,
    val description: String
)
