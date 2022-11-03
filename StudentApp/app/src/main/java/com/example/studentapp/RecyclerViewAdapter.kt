package com.example.studentapp


import Student
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(var studentData:Array<Student>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>()
{
    lateinit var clickLambda:(Student)->Unit
    class RecyclerViewHolder(val viewItem:View): RecyclerView.ViewHolder(viewItem)
    {

        fun bind(student:Student, clickLambda:(Student)->Unit)
        {
            viewItem.findViewById<TextView>(R.id.sv_name).text = student.name
            viewItem.findViewById<TextView>(R.id.sv_phone).text = student.phone
            if(student.gender == "Male")
                viewItem.findViewById<ImageView>(R.id.sv_pic).setImageResource(R.drawable.male)
            else
                viewItem.findViewById<ImageView>(R.id.sv_pic).setImageResource(R.drawable.female)
            viewItem.setOnClickListener{
                clickLambda(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder{
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.studentview, parent, false)
        val rholder = RecyclerViewHolder(viewItem)
        return rholder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(studentData[position], clickLambda)
    }

    override fun getItemCount(): Int {
        return studentData.size
    }

}