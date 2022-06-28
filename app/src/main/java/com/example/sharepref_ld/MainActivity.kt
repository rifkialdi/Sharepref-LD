package com.example.sharepref_ld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharepref_ld.databinding.ActivityMainBinding
import com.example.sharepref_ld.helper.Constant
import com.example.sharepref_ld.helper.Helper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharepref: Helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharepref = Helper(this)

        binding.idbtnEnter.setOnClickListener {
            if (binding.idedtUsername.text.isNotEmpty() && binding.idedtPassword.text.isNotEmpty()) {
                saveSession()
                moveIntent()
                showMessage("Berhasil Masuk")
            }
        }
    }

    /* Untuk mengecek apakah user sudah pernah login ? */
    override fun onStart() {
        super.onStart()
        if (sharepref.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    fun moveIntent() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    fun saveSession() {
        sharepref.putString(Constant.PREF_IS_USERNAME, binding.idedtUsername.text.toString())
        sharepref.putString(Constant.PREF_IS_PASSWORD, binding.idedtPassword.text.toString())
        sharepref.putBoolean(Constant.PREF_IS_LOGIN, true)
    }

    fun showMessage(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }
}