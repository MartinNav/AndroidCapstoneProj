package com.example.androiddevcapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


    @Composable
    fun HomeScreen(){
        Column {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little lemon logo", modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(0.dp, 10.dp))
                }
            }
        }
    }