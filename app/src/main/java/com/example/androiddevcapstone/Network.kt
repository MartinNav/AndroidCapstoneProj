package com.example.androiddevcapstone

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.BodyProgress.Plugin.install
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class MenuNetworkdata{
    suspend fun getMenuData(client:HttpClient):NetworkItems{
        val response:HttpResponse = client.request("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
        {
            method = HttpMethod.Get
        }
        return response.body()
    }

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