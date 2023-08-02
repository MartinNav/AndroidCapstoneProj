package com.example.androiddevcapstone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevcapstone.ui.theme.AndroidDevCapstoneTheme
import com.example.androiddevcapstone.ui.theme.onboarding.Onboarding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevCapstoneTheme {
                MyNavigation()
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }*/
            }
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
    NavHost(navController = navController, startDestination =OnBoardingD.route ){
        composable(OnBoardingD.route){
            Onboarding(navController)
        }
        composable(HomeD.route){
            HomeScreen()
        }
    }
}