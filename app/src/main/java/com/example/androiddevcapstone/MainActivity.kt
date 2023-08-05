package com.example.androiddevcapstone

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.androiddevcapstone.ui.theme.AndroidDevCapstoneTheme
import com.example.androiddevcapstone.ui.theme.onboarding.Onboarding
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine
import kotlin.system.*


class MainActivity : ComponentActivity() {
    val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("text","plain"))
        }
    }
    val db by lazy{ Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,"littlelemon-db"
    ).build()
    }
    /*val dishData =  Thread(object :Runnable{
        override fun run() {


            val d = db.dishDao().getAll()
            if (d.isEmpty()) {
                //val network_data = GetSynchedData(httpClient)
                //println(network_data.menu.toString())

                val d2 = runBlocking { GetMenuData(httpClient) }
                SaveNetworkItemsToDB(d2, db)
            }
            return@Runnable (db.dishDao().getAll())
        }
    })*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevCapstoneTheme {
                MyNavigation()

        }

        }

    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        AndroidDevCapstoneTheme {
            Greeting("Android")
        }
    }

    @Composable
    fun MyNavigation(){
        val navController = rememberNavController()
        //TODO: is loged in logic
        val context = LocalContext.current
        val sharedPref = context.getSharedPreferences("little_lemon_preferences", Context.MODE_PRIVATE)
        val fname = sharedPref.getString("FNAME","none")
        var st =OnBoardingD.route
        //TODO in finished version uncomment
        var menuList = emptyList<Dish>()
    lifecycleScope.launch (Dispatchers.IO){
        if (db.dishDao().getAll().isEmpty()){
            SaveNetworkItemsToDB(GetMenuData(httpClient), db)
        }
        menuList = db.dishDao().getAll()
    }




        if (fname==null||fname==""){
            st = OnBoardingD.route
        }else{
            st = HomeD.route
        }
        NavHost(navController = navController, startDestination =st ){
            composable(OnBoardingD.route){
                Onboarding(navController)
            }
            composable(HomeD.route){
                HomeScreen(navController,menuList)
            }
            composable(ProfileD.route){
                Profile(navController)
            }
        }
    }


}
