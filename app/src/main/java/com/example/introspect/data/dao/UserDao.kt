package com.example.introspect.data.dao

import androidx.room.*
import com.example.introspect.data.local_models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query(value = "SELECT * FROM USERTABLE")
    fun readAllData(): Flow<User>

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM USERTABLE")
    fun deleteAllItems()

}