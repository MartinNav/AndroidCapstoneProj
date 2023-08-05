package com.example.androiddevcapstone

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevcapstone.ui.theme.onboarding.CheckEmailAddress

@Composable
fun Profile(navController: NavHostController){
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("little_lemon_preferences", Context.MODE_PRIVATE)
    val fname = sharedPref.getString("FNAME","none")
    val lname = sharedPref.getString("LNAME","none")
    val email = sharedPref.getString("MAIL","none")
    Column {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row (modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little lemon logo", modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(0.dp, 10.dp)
                    .clickable { navController.navigate(HomeD.route) })
            }
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Profile picture", modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
            .padding(0.dp,50.dp))
            Text(text = "Profile Information", fontWeight = FontWeight.Bold, fontSize = 35.sp)
            Row {
                Text(text = "First name:", fontWeight = FontWeight.Bold)
                Text(text = UnNullString(fname))
            }
            Row {
                Text(text = "Last name:", fontWeight = FontWeight.Bold)
                Text(text = UnNullString(lname))
            }
            Row {
                Text(text = "Email:", fontWeight = FontWeight.Bold)
                Text(text = UnNullString(email))
            }


            Row (modifier = Modifier.padding(15.dp,80.dp,15.dp,0.dp)) {
                val context = LocalContext.current
                Button(
                    onClick = {
                        with(sharedPref.edit()) {
                            putString("FNAME", "")
                            putString("LNAME", "")
                            putString("MAIL", "")
                            apply()

                        }
                        navController.navigate(OnBoardingD.route)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(text = "Log Out")

                }
            }

            Row (modifier = Modifier.padding(15.dp,30.dp,15.dp,0.dp)) {

                Button(
                    onClick = {
                        navController.navigate(HomeD.route)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20)
                ) {
                    Text(text = "Go Home")

                }
            }
        }
    }
}
fun UnNullString(str:String?): String{
    if(str!=null){
        return str
    }
    return "not found"
}