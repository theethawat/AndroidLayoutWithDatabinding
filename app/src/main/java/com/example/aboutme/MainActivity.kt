package com.example.aboutme


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Theethawat Savastham")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //Wrong Arrange can make fatal error to the app
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName //link to variable Name

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        binding.apply {
            myName?.nickname = nicknameInput.text.toString()
            invalidateAll() /* to invaluate data (Get new data) when Refresh UI */
            binding.nicknameInput.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameShow.visibility = View.VISIBLE
        }



        //Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
