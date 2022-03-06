package com.example.walmart

import User
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_shopping_catagory.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var users: ArrayList<User> = ArrayList(
        Arrays.asList(
            User("John", "Smith", "sjohn@mail.com", "1234"),
            User("Jack", "Mathew", "mjack@mail.com", "1234"),
            User("Amanda", "Michelson", "mamanda@mail.com", "1234"),
            User("Kate", "Williams", "wkate@mail.com", "1234"),
            User("Maria", "Rodriguez", "rmaria@mail.com", "1234"),

            )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                if (result.resultCode == Activity.RESULT_OK) {
                    users.add(result.data?.getSerializableExtra("newAccount") as User)
                    Toast.makeText(this, "Account Created!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Sorry Can't create Account!", Toast.LENGTH_LONG).show()

                }

            }
        createAccount.setOnClickListener {
            var intent = Intent(this, CreateAccount::class.java)
            resultContracts.launch(intent)
        }

    }

    fun signInHandler(view: View) {
        var userName = userNameId?.text.toString();
        var password = password?.text.toString();
        var memberToSignIn = User(null, null, userName, password);
        var valid: Boolean = false;
        for (user in users) {
            if (user.userName.equals(userName) && user.password.equals(password)) {
                valid = true;
                println("valid true")
                break
            }
        }

        if (valid) {
            println("call intent")
            var intent = Intent(this, ShoppingCatagory::class.java)
            intent.putExtra("user", memberToSignIn?.userName)
            startActivity(intent)
        }
    }

    fun createAccountHandler(view: View) {
        var intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }

    fun forgotPasswordHandler(view: View) {
        var userName = userNameId.text?.toString()
        var password: String = ""
        for (user in users) {
            if (user.userName.equals(userName)) {
                password = "Your password is ${user?.password.toString()}"
                break
            }
        }
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, password)
        startActivity(intent)
//        ShareCompat.IntentBuilder
//            .from(this)
//            .setType("text/plain")
//            .setChooserTitle("Please choose app to share it with: ")
//            .setType(password)
//            .startChooser()
    }
}