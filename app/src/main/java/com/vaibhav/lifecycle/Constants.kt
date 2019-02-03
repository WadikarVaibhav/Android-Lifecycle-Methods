package com.vaibhav.lifecycle

class Constants {
    companion object {
        const val ON_CREATE_COUNT = "onCreateCount"
        const val ON_START_COUNT = "onStartCount"
        const val ON_RESUME_COUNT = "onResumeCount"
        const val ON_RESTART_COUNT = "onRestartCount"
        const val ON_PAUSE_COUNT = "onPauseCount"
        const val ON_STOP_COUNT = "onStopCount"
        const val ON_DESTROY_COUNT = "onDestroyCount"
        const val ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState"
        const val ON_SAVE_INSTANCE_STATE = "onSaveInstanceState"
        const val SHARED_PREF_FILE = ".lifecycle"
    }
}