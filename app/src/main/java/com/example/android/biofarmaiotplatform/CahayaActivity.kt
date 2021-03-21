package com.example.android.biofarmaiotplatform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_cahaya.*
import kotlin.random.Random

class CahayaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cahaya)
        readingsThread().start()
    }

    var handler: Handler = Handler { msg ->
        when (msg.what) {
            1-> lux_1.setText(msg.obj.toString())
            2-> lux_2.setText(msg.obj.toString())
        }
        true
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    inner class readingsThread : Thread() {
        override fun run() {
            super.run()
            while (true){
                var message1 = Message.obtain()
                message1.obj = rand(6060,6079)
                message1.what = 1
                handler.sendMessage(message1)
                var message2 = Message.obtain()
                message2.obj = rand(5060,6111)
                message2.what = 2
                handler.sendMessage(message2)
                sleep(1000)
            }
        }
    }
}