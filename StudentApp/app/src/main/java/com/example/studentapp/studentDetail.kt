package com.example.studentapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class studentDetail : AppCompatActivity() {
    companion object
    {
        var student_gender = "gender"
        var student_name = "student_name"
        var student_phone = "student_phone"
        var student_email = "email"
        var student_address = "address"
    }

    lateinit var sdPic : ImageView
    lateinit var sdName : TextView
    lateinit var sdPhone: TextView
    lateinit var sdEmail: TextView
    lateinit var sdAddress: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        sdPic = findViewById(R.id.sd_pic)
        sdName = findViewById(R.id.sd_name)
        sdPhone = findViewById(R.id.sd_phone)
        sdEmail = findViewById(R.id.sd_email)
        sdAddress = findViewById(R.id.sd_address)

        if(intent.getStringExtra(student_gender) == "Male")
            sdPic.setImageResource(R.drawable.male)
        else
            sdPic.setImageResource(R.drawable.female)
        sdName.text = intent.getStringExtra(student_name)
        sdPhone.text = intent.getStringExtra(student_phone)
        sdEmail.text = intent.getStringExtra(student_email)
        sdAddress.text = intent.getStringExtra(student_address)

    }
}