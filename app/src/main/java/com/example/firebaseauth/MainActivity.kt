package com.example.firebaseauth

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    lateinit var username: TextView
    lateinit var password: TextView
    lateinit var btn: Button


    lateinit var firebaseAuthobj: FirebaseAuth
//    lateinit var firebaseDatabase: FirebaseDatabase
//    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.pass)
        btn = findViewById(R.id.button)

//        firebaseDatabase = FirebaseDatabase.getInstance()
//        databaseReference = firebaseDatabase.getReference().child("Users")

        btn.setOnClickListener {
            firebaseAuthobj = FirebaseAuth.getInstance()

            val email: String = username.text.toString().trim()
            val pass: String = username.text.toString().trim()

            firebaseAuthobj.createUserWithEmailAndPassword(email, pass).addOnSuccessListener {
                Toast.makeText(this@MainActivity, "user register", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_LONG).show()

            }

        }

    }
}