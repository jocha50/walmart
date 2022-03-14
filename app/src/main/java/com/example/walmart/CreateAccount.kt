package com.example.walmart

import model.User
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    fun createAccountHandler(view : View){
        var firstName = newUserFirstName?.text.toString()
        var lastName = newUserLastName?.text.toString()
        var email = newUserEmail?.text.toString()
        var password = newUserPassword?.text.toString();

        var createdAccount = User(firstName,lastName,email,password);

        var intent = intent
        intent.putExtra("newAccount",createdAccount)

        setResult(Activity.RESULT_OK,intent)
        finish()

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}