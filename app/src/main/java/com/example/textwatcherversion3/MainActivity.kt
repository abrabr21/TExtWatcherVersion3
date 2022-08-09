 package com.example.textwatcherversion3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.textwatcherversion3.databinding.ActivityMainBinding
import com.example.textwatcherversion3.screens.Fragment1
import com.example.textwatcherversion3.screens.Fragment_2

 class MainActivity : AppCompatActivity() ,Communictor,UpdateTitle {
    lateinit var binding: ActivityMainBinding
    private lateinit var communictor: Communictor
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment1= Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment1).commit()

    }

    override fun passData(editTextInput: String) {
        val bundle =Bundle()
        bundle.putString("message",editTextInput)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment2 = Fragment_2()
        fragment2.arguments=bundle
        transaction.replace(R.id.container,fragment2)
        transaction.commit()
    }

    override fun updateTitle(updateTitle: String) {
        title=updateTitle
    }
}