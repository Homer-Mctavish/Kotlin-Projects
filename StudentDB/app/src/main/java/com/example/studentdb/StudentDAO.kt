package com.example.studentdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student:Student)

    @Query("SELECT * FROM studentTable")
    fun getAll(): List<Student>

    @Query("DELETE FROM studentTable")
    fun deleteAll()

    @Query("UPDATE studentTable SET age=:age WHERE name=:name")
    fun updateStudentAgeByName(name:String, age: Int)

    @Query("SELECT * FROM studentTable WHERE age  >=:age")
    fun countStudentAboveAge(age: Int):List<Student>

    //delete students between 20 and 30
    @Query("DELETE FROM studentTable where age <=30 AND age >=20")
    fun deleteTwentyAndThirty()
}