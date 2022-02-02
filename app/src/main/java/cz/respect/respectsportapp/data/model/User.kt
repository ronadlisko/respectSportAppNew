package cz.respect.respectsportapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
@PrimaryKey @ColumnInfo(name = "id") val id: String
)