package com.example.androiddevcapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
    fun HomeScreen(navController: NavHostController){
        Column {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little lemon logo", modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(0.dp, 10.dp))
                }

            }
            Row (modifier = Modifier.fillMaxWidth()){
                Column (modifier = Modifier.fillMaxWidth()
                    .padding(300.dp,2.dp,10.dp,2.dp), horizontalAlignment = Alignment.End){


                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(100.dp)
                            .clip(CircleShape)
                            //.align(Alignment.TopEnd)
                            //.padding(0.dp, 50.dp)
                            .clickable { navController.navigate(ProfileD.route) },
                    )
                }
            }
        }
    }