package com.example.studentdb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var name_text: EditText
    lateinit var age_text: EditText
    lateinit var add_button: Button
    lateinit var db_button: Button
    lateinit var student_list: TextView

    lateinit var db:StudentDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db=StudentDB.getDBObject(applicationContext)!!


        name_text = findViewById(R.id.name_text)
        age_text = findViewById(R.id.age_text)
        add_button = findViewById(R.id.add_button)
        db_button = findViewById(R.id.db_button)
        student_list = findViewById(R.id.list_text)

        updateStudentList()

        add_button.setOnClickListener {
            if(name_text.text.isNotEmpty() && age_text.text.isNotEmpty()){
                val student = Student()
                student.name = name_text.text.toString()
                student.age = age_text.text.toString().toInt()
                db.getDAO().insert(student)

            }
            updateStudentList()
        }
        db_button.setOnClickListener {
            //db.getDAO().deleteAll()
//            db.getDAO().updateStudentAgeByName(name_text.text.toString(),
//                age_text.text.toString().toInt())
//            updateStudentList()
//            val students = db.getDAO().countStudentAboveAge(age_text.text.toString().toInt())
//            Toast.makeText(this,"student # ${students.size}", Toast.LENGTH_SHORT).show()
            db.getDAO().deleteTwentyAndThirty()
        }

    }



    fun updateStudentList() {
        val students = db.getDAO().getAll()
        var students_text=""
        for(stu in students){
            students_text +="${stu.name} ${stu.age}\n"
        }
        student_list.text = students_text

    }
}
