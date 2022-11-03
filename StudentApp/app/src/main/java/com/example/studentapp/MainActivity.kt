package com.example.studentapp

import Student
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var studentArray = ArrayList<Student>()
    val studentClickLambda = { student:Student->
        val intent = Intent(this, studentDetail::class.java)
        intent.putExtra(studentDetail.student_name, student.name)
        intent.putExtra(studentDetail.student_phone, student.phone)
        intent.putExtra(studentDetail.student_email, student.email)
        intent.putExtra(studentDetail.student_address, student.address)
        intent.putExtra(studentDetail.student_gender, student.gender)
        startActivity(intent)
    }

    lateinit var viewAdapter: RecyclerViewAdapter
    lateinit var studentRecycler: RecyclerView
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = RecyclerViewAdapter(studentArray.toTypedArray())
        studentRecycler = findViewById(R.id.student_recycler)
        viewManager = LinearLayoutManager(this)

        studentRecycler.layoutManager = viewManager
        studentRecycler.adapter = viewAdapter

        viewAdapter.clickLambda = studentClickLambda
        loadData()
        viewAdapter.studentData = studentArray.toTypedArray()
        viewAdapter.notifyDataSetChanged()
    }
    /**
     * read the CSV data
     * */
    fun loadData() {
        val dataString =
            resources.openRawResource(R.raw.student).bufferedReader()
                .use { it.readText() }// read the entire file as a string
        var lines = dataString.trim().split("\n") // split each line
        lines = lines.subList(1, lines.size) // get rid of the header line
        //Add to the student Array.
        lines.forEach { line:String->
            val cells = line.split(",")
            val student = Student(
                cells[0],
                cells[1],
                cells[2],
                cells[3],
                cells[4]
            )
            studentArray.add(student)
        }
    }

}