package com.ipca.combustivel.apploja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textViewRegister = findViewById<TextView>(R.id.textViewRegister)
        textViewRegister.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        val btn_login = findViewById<Button>(R.id.btn_login)
        val et_login_email = findViewById<EditText>(R.id.et_login_email)
        val ed_login_password = findViewById<EditText>(R.id.ed_login_password)
        btn_login.setOnClickListener {
            when{
                TextUtils.isEmpty(et_login_email.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                    this@LoginActivity,
                    "Por favor coloque um email.",
                    Toast.LENGTH_SHORT
                    ).show()
                }


                TextUtils.isEmpty(ed_login_password.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Por favor coloque uma password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    val email : String = et_login_email.text.toString().trim { it <= ' '}
                    val password: String = ed_login_password.text.toString().trim { it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "You are logged in",
                                    Toast.LENGTH_SHORT
                                ).show()


                                val intent =
                                    Intent(this@LoginActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT

                                ).show()
                            }

                        }

                }
            }
        }
    }
}