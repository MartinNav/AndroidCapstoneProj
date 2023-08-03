package com.example.androiddevcapstone.ui.theme.onboarding

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevcapstone.HomeD
import com.example.androiddevcapstone.ProfileD
import com.example.androiddevcapstone.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController) {
    var uname by remember {
        mutableStateOf("")
    }
    var lname by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
Column {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little lemon logo", modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(0.dp, 10.dp))
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color(0xFF495E57))
            .wrapContentSize(Alignment.Center)){
            Text(text = "Let's get to know you",textAlign = TextAlign.Center, fontSize = 30.sp, color = Color(0xFFFFFFFF))
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)){
            Text(text = "Personal information", modifier = Modifier.padding(5.dp,30.dp), fontWeight = FontWeight.Bold)

        }

        Row {

            OutlinedTextField(value = uname, onValueChange = {uname = it},label={ Text(text = "First name")}, placeholder = {Text(text="First name")},textStyle= TextStyle(color = Color.Black),colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF333333),
                unfocusedBorderColor = Color(0xFF71807B)) )
        }
        Row {
            OutlinedTextField(value = lname, onValueChange = {lname = it},label={ Text(text = "Last name")}, placeholder = {Text(text="Last name")},textStyle= TextStyle(color = Color.Black),colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF333333),
                unfocusedBorderColor = Color(0xFF71807B)))
        }
        Row {
            OutlinedTextField(value = email, onValueChange = {email = it},label={ Text(text = "email")}, placeholder = {Text(text="email")},textStyle= TextStyle(color = Color.Black),colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF333333),
                unfocusedBorderColor = Color(0xFF71807B)))
        }
        Row (modifier = Modifier.padding(15.dp,80.dp,15.dp,0.dp)){
            val context = LocalContext.current
            Button(onClick = {
                if (uname==""||lname==""|| !CheckEmailAddress(email)){
                    Toast.makeText(context, "Please fill in correct info", Toast.LENGTH_SHORT).show()
                }else {
                   /* coroutineScope.launch{
                        withContext(Dispatchers.IO){
                            var lc = this
                        }
                    }*/
                    var sharedprefs  =context.getSharedPreferences("little_lemon_preferences",Context.MODE_PRIVATE)
                    with (sharedprefs.edit()){
                        putString("FNAME",uname)
                        putString("LNAME",lname)
                        putString("MAIL",email)
                        apply()

                    }

                    //TODO:save login state using shared preferences
                    navController.navigate(ProfileD.route)
                }
                             },colors =ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20)) {
                Text(text = "Register")
            }
        }
    }

}
}

fun CheckEmailAddress(mail:String) : Boolean{
    val reg = Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    return reg.matches(mail)
}
/*
@Preview
@Composable
fun OnboardingPreview(){
    Onboarding(navController)
}*/