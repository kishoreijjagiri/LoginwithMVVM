package com.example.loginwithmvvm.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loginwithmvvm.ActivityViewModel
import com.example.loginwithmvvm.ActivityViewmodelfactory
import com.example.loginwithmvvm.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ActivityViewModel
    lateinit var viewmodelfactory: ActivityViewmodelfactory
    lateinit var login:Button
    lateinit var companyName:EditText
    lateinit var userName:EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initialize()

        login.setOnClickListener{


            if(!(companyName.text.toString().isEmpty())){
                if(!(userName.text.toString().isEmpty())){

                    if(!(password.text.toString().isEmpty())){
                        viewModel.login("2015")
                    }else{
                        Toast.makeText(applicationContext,"enter password", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(applicationContext,"enter username", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(applicationContext,"enter company", Toast.LENGTH_LONG).show()
            }
        }


       viewModel.successData.observe(this, Observer {
         //  companyName.text=it.toString()
       })


    }

    private fun initialize() {
        viewmodelfactory= ActivityViewmodelfactory(applicationContext)
        viewModel=ViewModelProvider(this,viewmodelfactory).get(ActivityViewModel::class.java)
        login=findViewById(R.id.login)
        companyName=findViewById(R.id.companyName)
        userName=findViewById(R.id.username)
        password=findViewById(R.id.password)

    }
}
