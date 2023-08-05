package com.example.androiddevcapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun HomeScreen(navController: NavHostController, menuList: List<Dish>){
    var searchTerm by remember{
        mutableStateOf("")
    }
    var filteredList by remember{
        mutableStateOf(menuList)
    }
        Column {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little lemon logo", modifier = Modifier
                        //.fillMaxWidth()
                        .fillMaxWidth(0.85f)
                        .height(70.dp)
                        .padding(0.dp, 10.dp, 0.dp, 0.dp))

                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                //.fillMaxWidth()
                                //.size(100.dp)
                                .padding(0.dp, 15.dp, 0.dp, 0.dp)
                                .width(50.dp)
                                .height(50.dp)
                                .clip(CircleShape)

                                //.align(Alignment.TopEnd)
                                //.padding(0.dp, 50.dp)
                                .clickable { navController.navigate(ProfileD.route) },
                        )


                }

            }

            Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp), modifier = Modifier.padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF0495E57))) {
                Row (modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp)){
                Column {
                    Row {
                       // Text(text = "Restaurant:", fontWeight = FontWeight.Bold)

                        Text(text = "Little Lemon", color = Color(0xFFF4CE14), fontSize = 38.sp)
                    }
                    Row {
                        //Text(text = "City:", fontWeight = FontWeight.Bold)

                        Text(text = "Chicago",color = Color(0xFFFFFFFF), fontSize = 20.sp)
                    }
                    /*Row {

                        Text(text = "Description:", fontWeight = FontWeight.Bold)
                    }*/
                    Row (modifier = Modifier.width(200.dp)){

                        Text(text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist", color= Color(0xFFFAFAFA), fontSize = 15.sp)

                    }
                }
                    Image(painter = painterResource(id = R.drawable.hero_image), contentDescription = "Hero image", modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(50.dp, 0.dp, 0.dp, 0.dp))

                }
                Row(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()) {
                    TextField(value = searchTerm, onValueChange = {searchTerm =it
                                                                  filteredList = menuList.filter {
                                                                      di->
                                                                      di.title.contains(searchTerm,true)
                                                                  }
                                                                  filteredList.sortedBy { it.title }},modifier = Modifier.fillMaxWidth(), placeholder = { Row{
                        Icon(Icons.Rounded.Search, contentDescription = "Search field")
                        Text(
                        text = "Enter search phrase"
                    )}},colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFAFAFA), textColor = Color(0xFF333333)))
                }

                /*Row (modifier = Modifier.padding(10.dp,1.dp,10.dp,10.dp)){
                    Text(text = "Description:", fontWeight = FontWeight.Bold)

                    Text(text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist")
                }*/
            }
            Row(modifier = Modifier.padding(15.dp,0.dp)) {
                Text(text = "Order for your delivery", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Row (modifier = Modifier.fillMaxWidth()){
                LazyRow{
                    item {
                        Button(onClick = {
                            filteredList =menuList
                        }, modifier = Modifier.padding(10.dp,0.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAFAFAF), contentColor = Color(0xFF333333)) ){
                            Text(text = "All")
                        }
                    }
                    item {
                        Button(onClick = {
                                         filteredList =menuList.filter { it.category=="starters" }
                        }, modifier = Modifier.padding(10.dp,0.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAFAFAF), contentColor = Color(0xFF333333)) ){
                            Text(text = "Starters")
                        }
                    }
                    item {
                        Button(onClick = { filteredList =menuList.filter { it.category=="mains" } }, modifier = Modifier.padding(10.dp,0.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAFAFAF), contentColor = Color(0xFF333333)) ){
                            Text(text = "Mains")
                        }
                    }
                    item {
                        Button(onClick = { filteredList =menuList.filter { it.category=="desserts" } }, modifier = Modifier.padding(10.dp,0.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAFAFAF), contentColor = Color(0xFF333333))) {
                            Text(text = "Desserts")
                        }
                    }
                    item {
                        Button(onClick = { filteredList =menuList.filter { it.category=="drinks" } }, modifier = Modifier.padding(10.dp,0.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFAFAFAF), contentColor = Color(0xFF333333))) {
                            Text(text = "Drinks")
                        }
                    }
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(items=filteredList,
                    itemContent={
                        it ->
                        HomeMenuItem(item = it)
                    }
                    )
            }
        }
    }


@Composable
fun HomeMenuItem(item:Dish){
    Card (elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 2.dp)
        ,colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
        , shape = RoundedCornerShape(3.dp)
    ){


        Row (modifier = Modifier.padding(5.dp,5.dp)){
            Column(modifier = Modifier.fillMaxWidth(0.7f)) {
                Text(text = item.title, fontWeight = FontWeight.Bold)
                Text(text = item.description)
                Text(text = "\$${item.price}.99")
            }
            AsyncImage(
                model = item.image, contentDescription = item.title, modifier = Modifier
                    .width(100.dp)
                    .fillMaxWidth()
            )
        }
    }
}