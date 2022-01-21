package com.example.advandcedlayoutlesson7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         initViews()
         listener()

    }

    private fun initViews() {
        action.doOnTextChanged { text, start, before, count ->
                 if (text!!.length > 11) tryAction.error = "no more"
                 else if (text.length < 10) tryAction.error = null
        }

    }
    private fun listener(){


        name.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {

                if (p1 == EditorInfo.IME_ACTION_DONE){
                    Toast.makeText(this@MainActivity,"pressed",Toast.LENGTH_SHORT).show()}

                return false
            }
        })


        et_listen.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {

                if (p1 == EditorInfo.IME_ACTION_PREVIOUS){
                    Toast.makeText(this@MainActivity,"pressed",Toast.LENGTH_SHORT).show()}

                return false
            }
        })

        et_listen.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val str:String = et_listen.text.toString()
                tv_show.text = str
            }
        })
   }
}