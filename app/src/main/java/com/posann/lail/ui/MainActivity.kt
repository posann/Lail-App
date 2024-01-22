package com.posann.lail.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.posann.lail.R
import com.posann.lail.data.local.UserPreferences
import com.posann.lail.data.response.ResponseLogin
import com.posann.lail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // menambahkan auth firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mb.root)

        // inisialisasi auth firebase
        auth = Firebase.auth

        mb.cardMorning.setOnClickListener {
            val intent = Intent(this, MorningActivity::class.java)
            intent.putExtra(MorningActivity.MODE, "morning")
            startActivity(intent)
        }

        mb.cardEvening.setOnClickListener {
            val intent = Intent(this, MorningActivity::class.java)
            intent.putExtra(MorningActivity.MODE, "evening")
            startActivity(intent)
        }

        mb.btnLogout.setOnClickListener {
            val database = UserPreferences(this)
            val user = ResponseLogin()
            user.username = null
            user.password = null
            database.setUser(user)

            // menambahkan action signOut
            auth.signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        mb.tvUsername.text = UserPreferences(this).getUser().username
    }
}







