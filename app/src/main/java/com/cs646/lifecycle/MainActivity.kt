package com.cs646.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var onCreateCount = getValueFromSharedPrefs(Constants.ON_CREATE_COUNT)
        setValueInSharedPrefs(Constants.ON_CREATE_COUNT, ++onCreateCount)
        showAllRecords()
        Log.i(Constants.TAG, Constants.ON_CREATE)

        reset.setOnClickListener {
            reset()
        }
    }

    override fun onStart() {
        super.onStart()
        var onStartCount = getValueFromSharedPrefs(Constants.ON_START_COUNT)
        setValueInSharedPrefs(Constants.ON_START_COUNT, ++onStartCount)
        onStart.text = onStartCount.toString()
        Log.i(Constants.TAG, Constants.ON_START)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            setValueInSharedPrefs(Constants.ON_CREATE_COUNT, savedInstanceState.getInt(Constants.ON_CREATE_COUNT))
            setValueInSharedPrefs(Constants.ON_START_COUNT, savedInstanceState.getInt(Constants.ON_START_COUNT))
            setValueInSharedPrefs(Constants.ON_RESUME_COUNT, savedInstanceState.getInt(Constants.ON_RESUME_COUNT))
            setValueInSharedPrefs(Constants.ON_RESTART_COUNT, savedInstanceState.getInt(Constants.ON_RESTART_COUNT))
            setValueInSharedPrefs(Constants.ON_PAUSE_COUNT, savedInstanceState.getInt(Constants.ON_PAUSE_COUNT))
            setValueInSharedPrefs(Constants.ON_STOP_COUNT, savedInstanceState.getInt(Constants.ON_STOP_COUNT))
            setValueInSharedPrefs(Constants.ON_DESTROY_COUNT, savedInstanceState.getInt(Constants.ON_DESTROY_COUNT))
            setValueInSharedPrefs(Constants.ON_SAVE_INSTANCE_STATE_COUNT, savedInstanceState.getInt(Constants.ON_SAVE_INSTANCE_STATE_COUNT))
            setValueInSharedPrefs(Constants.ON_RESTORE_INSTANCE_STATE_COUNT, savedInstanceState.getInt(Constants.ON_RESTORE_INSTANCE_STATE_COUNT))
        }
        var onRestoreInstanceStateCount = getValueFromSharedPrefs(Constants.ON_RESTORE_INSTANCE_STATE_COUNT)
        setValueInSharedPrefs(Constants.ON_RESTORE_INSTANCE_STATE_COUNT, ++onRestoreInstanceStateCount)
        onSaveInstanceState.text = onRestoreInstanceStateCount.toString()
        Log.i(Constants.TAG, Constants.ON_RESTORE_INSTANCE_STATE)
    }

    override fun onResume() {
        super.onResume()
        var onResumeCount = getValueFromSharedPrefs(Constants.ON_RESUME_COUNT)
        setValueInSharedPrefs(Constants.ON_RESUME_COUNT, ++onResumeCount)
        onResume.text = onResumeCount.toString()
        Log.i(Constants.TAG, Constants.ON_RESUME)
    }

    override fun onRestart() {
        super.onRestart()
        var onRestartCount = getValueFromSharedPrefs(Constants.ON_RESTART_COUNT)
        setValueInSharedPrefs(Constants.ON_RESTART_COUNT, ++onRestartCount)
        onRestart.text = onRestartCount.toString()
        Log.i(Constants.TAG, Constants.ON_RESTART)
    }

    override fun onPause() {
        super.onPause()
        var onPauseCount = getValueFromSharedPrefs(Constants.ON_PAUSE_COUNT)
        setValueInSharedPrefs(Constants.ON_PAUSE_COUNT, ++onPauseCount)
        onPause.text = onPauseCount.toString()
        Log.i(Constants.TAG, Constants.ON_PAUSE)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        var onSaveInstanceStateCount = getValueFromSharedPrefs(Constants.ON_SAVE_INSTANCE_STATE_COUNT)
        setValueInSharedPrefs(Constants.ON_SAVE_INSTANCE_STATE_COUNT, ++onSaveInstanceStateCount)
        onSaveInstanceState.text = onSaveInstanceStateCount.toString()
        Log.i(Constants.TAG, Constants.ON_SAVE_INSTANCE_STATE)
        if (outState != null) {
            outState.putInt(Constants.ON_CREATE_COUNT, getValueFromSharedPrefs(Constants.ON_CREATE_COUNT))
            outState.putInt(Constants.ON_START_COUNT, getValueFromSharedPrefs(Constants.ON_START_COUNT))
            outState.putInt(Constants.ON_RESUME_COUNT, getValueFromSharedPrefs(Constants.ON_RESUME_COUNT))
            outState.putInt(Constants.ON_RESTART_COUNT, getValueFromSharedPrefs(Constants.ON_RESTART_COUNT))
            outState.putInt(Constants.ON_PAUSE_COUNT, getValueFromSharedPrefs(Constants.ON_PAUSE_COUNT))
            outState.putInt(Constants.ON_STOP_COUNT, getValueFromSharedPrefs(Constants.ON_STOP_COUNT))
            outState.putInt(Constants.ON_DESTROY_COUNT, getValueFromSharedPrefs(Constants.ON_DESTROY_COUNT))
            outState.putInt(Constants.ON_SAVE_INSTANCE_STATE_COUNT, getValueFromSharedPrefs(Constants.ON_SAVE_INSTANCE_STATE_COUNT))
            outState.putInt(Constants.ON_RESTORE_INSTANCE_STATE_COUNT, getValueFromSharedPrefs(Constants.ON_RESTORE_INSTANCE_STATE_COUNT))
        }
    }

    override fun onStop() {
        super.onStop()
        var onStopCount = getValueFromSharedPrefs(Constants.ON_STOP_COUNT)
        setValueInSharedPrefs(Constants.ON_STOP_COUNT, ++onStopCount)
        onStop.text = onStopCount.toString()
        Log.i(Constants.TAG, Constants.ON_STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        var onDestroyCount = getValueFromSharedPrefs(Constants.ON_DESTROY_COUNT)
        setValueInSharedPrefs(Constants.ON_DESTROY_COUNT, ++onDestroyCount)
        onDestroy.text = onDestroyCount.toString()
        Log.i(Constants.TAG, Constants.ON_DESTROY)
    }

    private fun getValueFromSharedPrefs(key: String): Int {
        val sharedPreferences = getSharedPreferences(packageName+Constants.SHARED_PREF_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key,0)
    }

    private fun setValueInSharedPrefs(key: String, value: Int) {
        val sharedPreferences = getSharedPreferences(packageName+Constants.SHARED_PREF_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    private fun showAllRecords() {
        val sharedPreferences = getSharedPreferences(packageName+Constants.SHARED_PREF_FILE, Context.MODE_PRIVATE)
        onCreate.text = sharedPreferences.getInt(Constants.ON_CREATE_COUNT, 0).toString()
        onStart.text = sharedPreferences.getInt(Constants.ON_START_COUNT, 0).toString()
        onResume.text = sharedPreferences.getInt(Constants.ON_RESUME_COUNT, 0).toString()
        onRestart.text = sharedPreferences.getInt(Constants.ON_RESTART_COUNT, 0).toString()
        onPause.text = sharedPreferences.getInt(Constants.ON_PAUSE_COUNT, 0).toString()
        onStop.text = sharedPreferences.getInt(Constants.ON_STOP_COUNT, 0).toString()
        onDestroy.text = sharedPreferences.getInt(Constants.ON_DESTROY_COUNT, 0).toString()
        onSaveInstanceState.text = sharedPreferences.getInt(Constants.ON_SAVE_INSTANCE_STATE_COUNT, 0).toString()
        onRestoreInstanceState.text = sharedPreferences.getInt(Constants.ON_RESTORE_INSTANCE_STATE_COUNT, 0).toString()
    }

    private fun reset() {
        val sharedPref = getSharedPreferences(packageName+Constants.SHARED_PREF_FILE, Context.MODE_PRIVATE)
        var editor=sharedPref.edit()
        editor.clear()
        editor.apply()
        showAllRecords()
    }
}