package com.example.androiddevcapstone

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class MenuNetworkdata{
    suspend fun get

}
@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Int,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String
)
@Serializable
data class NetworkItems(
    @SerialName("menu")
    val menu: List<MenuItemNetwork>
)