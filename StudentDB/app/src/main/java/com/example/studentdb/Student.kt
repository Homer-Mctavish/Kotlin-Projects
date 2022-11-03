package com.example.studentdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "studentTable")
class Student {
    @PrimaryKey
    var sid:String= UUID.randomUUID().toString()
    var name: String = ""
    var age: Int = 0
}