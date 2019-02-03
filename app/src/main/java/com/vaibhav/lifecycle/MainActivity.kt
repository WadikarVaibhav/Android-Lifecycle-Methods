package com.vaibhav.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var onCreateCount = getValue(Constants.ON_CREATE_COUNT);
        setValue(Constants.ON_CREATE_COUNT, ++onCreateCount);
        showAllRecords();

        reset.setOnClickListener {
            val sharedPref = getSharedPreferences(packageName+".lifecycle", Context.MODE_PRIVATE)
            var editor=sharedPref.edit()
            editor.clear()
            editor.apply()
            showAllRecords();
        }
    }

    fun getValue(key: String): Int {
        val sharedPreferences = getSharedPreferences(packageName+".lifecycle", Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key,0);
    }

    fun setValue(key: String, value: Int) {
        val sharedPreferences = getSharedPreferences(packageName+".lifecycle", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(key, value);
        editor.apply()
    }

    override fun onStart() {
        super.onStart()
        var onStartCount = getValue(Constants.ON_START_COUNT);
        setValue(Constants.ON_START_COUNT, ++onStartCount);
        onStart.text = onStartCount.toString()
    }

    override fun onResume() {
        super.onResume()
        var onResumeCount = getValue(Constants.ON_RESUME_COUNT);
        setValue(Constants.ON_RESUME_COUNT, ++onResumeCount);
        onResume.text = onResumeCount.toString()
    }

    override fun onRestart() {
        super.onRestart()
        var onRestartCount = getValue(Constants.ON_RESTART_COUNT);
        setValue(Constants.ON_RESTART_COUNT, ++onRestartCount);
        onRestart.text = onRestartCount.toString()
    }

    override fun onPause() {
        super.onPause()
        var onPauseCount = getValue(Constants.ON_PAUSE_COUNT);
        setValue(Constants.ON_PAUSE_COUNT, ++onPauseCount);
        onPause.text = onPauseCount.toString()
    }

    override fun onStop() {
        super.onStop()
        var onStopCount = getValue(Constants.ON_STOP_COUNT);
        setValue(Constants.ON_STOP_COUNT, ++onStopCount);
        onStop.text = onStopCount.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        var onDestroyCount = getValue(Constants.ON_DESTROY_COUNT);
        setValue(Constants.ON_DESTROY_COUNT, ++onDestroyCount);
        onDestroy.text = onDestroyCount.toString()
    }

    fun showAllRecords() {
        val sharedPreferences = getSharedPreferences(packageName+".lifecycle", Context.MODE_PRIVATE)
        onCreate.text = sharedPreferences.getInt(Constants.ON_CREATE_COUNT, 0).toString();
        onStart.text = sharedPreferences.getInt(Constants.ON_START_COUNT, 0).toString();
        onResume.text = sharedPreferences.getInt(Constants.ON_RESUME_COUNT, 0).toString();
        onRestart.text = sharedPreferences.getInt(Constants.ON_RESTART_COUNT, 0).toString();
        onPause.text = sharedPreferences.getInt(Constants.ON_PAUSE_COUNT, 0).toString();
        onStop.text = sharedPreferences.getInt(Constants.ON_STOP_COUNT, 0).toString();
        onDestroy.text = sharedPreferences.getInt(Constants.ON_DESTROY_COUNT, 0).toString();
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
