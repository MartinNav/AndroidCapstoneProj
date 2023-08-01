package com.example.androiddevcapstone.ui.theme.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevcapstone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(){
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

            OutlinedTextField(value = uname, onValueChange = {uname = it},label={ Text(text = "First name")}, placeholder = {Text(text="First name")},textStyle= TextStyle(color = Color.Black) )
        }
        Row {
            OutlinedTextField(value = lname, onValueChange = {lname = it},label={ Text(text = "Last name")}, placeholder = {Text(text="Last name")},textStyle= TextStyle(color = Color.Black))
        }
        Row {
            OutlinedTextField(value = email, onValueChange = {email = it},label={ Text(text = "email")}, placeholder = {Text(text="email")},textStyle= TextStyle(color = Color.Black))
        }
        Row (modifier = Modifier.padding(15.dp,80.dp,15.dp,0.dp)){
            Button(onClick = { /*TODO*/ },colors =ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20)) {
                Text(text = "Register")
            }
        }
    }

}
}

@Preview
@Composable
fun OnboardingPreview(){
    Onboarding()
}