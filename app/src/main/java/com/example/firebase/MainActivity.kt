package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference


        //lave "ejemplo", primer valor "hola mundo"
        //myRef.child("ejemplo").setValue ("hola mundo")
        //myRef.child("ejemplo").child("1").setValue ("hola mundo")
        //myRef.child("ejemplo").child("2").setValue ("hola mundo")
        //myRef.child("ejemplo").child("3").setValue ("hola mundo")

        //myRef.child("ejemplo").child("1").setValue (Card("1", "rojo", "corazones"))
        //myRef.child("ejemplo").child("2").setValue (Card("2", "negro", "corazones"))
        //myRef.child("ejemplo").child("3").setValue (Card("3", "rojo", "diamantes"))
        //myRef.child("ejemplo").child("4").setValue (Card("4", "negro", "picas"))
        //myRef.child("ejemplo").child("5").setValue (Card("5", "negro", "treboles"))

        myRef.child("ejemplo").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }
}