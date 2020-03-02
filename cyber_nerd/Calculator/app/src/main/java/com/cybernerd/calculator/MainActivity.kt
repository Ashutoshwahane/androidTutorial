package com.cybernerd.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for Numbers
        tvone.setOnClickListener { appendOnExpresstion("1", true)}
        tvtwo.setOnClickListener { appendOnExpresstion("2", true)}
        tvthree.setOnClickListener { appendOnExpresstion("3", true)}
        tvfour.setOnClickListener { appendOnExpresstion("4", true)}
        tvfive.setOnClickListener { appendOnExpresstion("5", true)}
        tvsix.setOnClickListener { appendOnExpresstion("6", true)}
        tvseven.setOnClickListener { appendOnExpresstion("7", true)}
        tveight.setOnClickListener { appendOnExpresstion("8", true)}
        tvnine.setOnClickListener { appendOnExpresstion("9", true)}
        tvzero.setOnClickListener{ appendOnExpresstion("0", true)}


        // for operations
        tvdot.setOnClickListener{ appendOnExpresstion(".", true)}
        tvplus.setOnClickListener{ appendOnExpresstion("+", false)}
        tvminus.setOnClickListener{ appendOnExpresstion("-", false)}
        tvmultiply.setOnClickListener{ appendOnExpresstion("*", false)}
        tvdivide.setOnClickListener{ appendOnExpresstion("/", false)}
        tvopen.setOnClickListener{ appendOnExpresstion("(", false)}
        tvclose.setOnClickListener{ appendOnExpresstion(")", false)}

        tvce.setOnClickListener{
            tvInput.text = ""
            tvoutput.text = ""
        }

        tvback.setOnClickListener {
            val string = tvInput.text.toString()
            if (string.isNotEmpty()){
                tvInput.text = string.substring(0, string.length-1)
            }

            tvoutput.text = ""
        }

        tvequalto.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvInput.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()){
                    tvoutput.text = longResult.toString()
                }
                else{
                    tvoutput.text = result.toString()
                }
            }catch (e: Exception){
                Log.d("Exception", "message" + e.message)
            }
        }




    }

    fun appendOnExpresstion(string: String, canClear: Boolean){
        if(canClear){
            tvoutput.text = ""
            tvInput.append(string)
        }
        else{
            tvInput.append(tvoutput.text)
            tvInput.append(string)
            tvoutput.text = ""
        }
    }
}
