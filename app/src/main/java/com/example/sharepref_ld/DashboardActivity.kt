package com.example.sharepref_ld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharepref_ld.databinding.ActivityDashboardBinding
import com.example.sharepref_ld.helper.Constant
import com.example.sharepref_ld.helper.Helper

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    private lateinit var rvDashBoard: RecyclerView
    lateinit var dataName: ArrayList<String>
    lateinit var dataAge: ArrayList<Int>
    private lateinit var sharePref: Helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Yang berhubungan dengan recycler view */
        dataName = arrayListOf<String>(
            "Rifki",
            "Sila",
            "Farha",
            "Najwa",
            "Indra",
            "Yusuf",
            "Radar",
            "Ricard",
            "Ibnu",
            "fauzi",
            "Nabila",
            "Vigo"
        )
        dataAge = arrayListOf<Int>(
            18,
            18,
            19,
            19,
            22,
            28,
            22,
            18,
            21,
            12,
            12,
            22
        )
        val data = arrayListOf<DashboardModel>()
        for (i in dataName.indices) {
            data.add(DashboardModel(dataName[i], dataAge[i]))
        }

        rvDashBoard = binding.idrvDashboard
        val adapter = DashboardAdapter(data)
        rvDashBoard.adapter = adapter
        rvDashBoard.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickCallBack(object : DashboardAdapter.IOnAdapterListener {
            override fun onClick(data: DashboardModel) {
                showMessage("click " + data.name)
            }
        })
        /* Yang berhubungan dengan recycler view */

        sharePref = Helper(this)
        binding.idtvWelcome.text = sharePref.getString(Constant.PREF_IS_USERNAME)

        binding.idbtnLogout.setOnClickListener {
            sharePref.clearr()
            showMessage("Anda Logout")
            moveIntent()
        }

    }

    fun showMessage(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}