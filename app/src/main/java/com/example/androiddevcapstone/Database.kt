package com.example.androiddevcapstone

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.serialization.SerialName

@Entity
data class Dish(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name="title")
    var title: String,
    @ColumnInfo(name="description")
    var description: String,
    @ColumnInfo(name="price")
    var price: Int,
    @ColumnInfo(name="image")
    var image: String,
    @ColumnInfo(name = "category")
    var category: String
)
@Dao
interface DishDao{
    @Query("SELECT * FROM dish")
    fun getAll():List<Dish>

    @Insert
    fun insertAll(dishes: List<Dish>)
}
@Database(entities = [Dish::class], version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun dishDao():DishDao
}

public fun SaveNetworkItemsToDB(nitems:NetworkItems, db:AppDatabase){
    var disheList = nitems.menu.map {
        Dish(it.id,it.title,it.description,it.price,it.image,it.category)
    }
    db.dishDao().insertAll(disheList)

}