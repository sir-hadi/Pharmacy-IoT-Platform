package com.example.android.biofarmaiotplatform

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener{
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            if (username.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert Username and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(username == "admin" || password == "admin"){
                val progressDialog = ProgressDialog(this,
                    R.style.Theme_MaterialComponents_Light_Dialog)
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Loading...")
                progressDialog.show()
                val intent = Intent (this,RoomActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}