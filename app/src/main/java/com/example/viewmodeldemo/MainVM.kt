package com.example.viewmodeldemo

import android.content.Context
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVM() : ViewModel() {
    private lateinit var timer : CountDownTimer

    var timerValue = MutableLiveData<Long>()
    var finished = MutableLiveData<Boolean>()
    var secondsLeft = MutableLiveData<Long>()

    fun increment(){
        secondsLeft.value = 3241
    }

    fun startTime(context: Context){
        timer = object : CountDownTimer(timerValue.value!!.toLong()   , 1000){
            override fun onTick(p0: Long) {
                secondsLeft.value = p0/1000
            }

            override fun onFinish() {

                finished.value = true
            }

        }.start()
    }

}