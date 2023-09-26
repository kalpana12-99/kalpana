package com.example.rentingacycle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rentingacycle.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var database: DatabaseReference

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerbutton.setOnClickListener {
            val firstname = binding.userNameTextEt.text.toString()
            val lastname = binding.lastTextEt.text.toString()
            val age = binding.ageTextEt.text.toString()
            val username = binding.userNameTextEt.text.toString()

            database = FirebaseDatabase.getInstance().getReference("users")
           // val user = User(firstname, lastname , age, username)
         //   database.child(username).setValue(user).addOnSuccessListener {
           //     binding.nameTextEt.text.clear()
             //   binding.lastTextEt.text.clear()
               // binding.ageTextEt.text.clear()
                //binding.userNameTextEt.text.clear()

            val user=User(firstname,lastname,age,username)
            database.child(username).setValue(user).addOnSuccessListener {
                binding.nameTextEt.text.clear()
                binding.lastTextEt.text.clear()
                binding.ageTextEt.text.clear()
                binding.userNameTextEt.text.clear()
                Toast.makeText(this, " Successfully Saved ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun User(firstname: String, lastname: String, age: String, username: String) {

        return
    }
}