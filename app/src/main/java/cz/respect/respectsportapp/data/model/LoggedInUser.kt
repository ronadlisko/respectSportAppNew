package cz.respect.respectsportapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Entity(tableName = "loggedUsers")
data class LoggedInUser(
    @PrimaryKey @ColumnInfo(name = "id") val userId: String,
    @ColumnInfo(name = "name") val displayName: String
)