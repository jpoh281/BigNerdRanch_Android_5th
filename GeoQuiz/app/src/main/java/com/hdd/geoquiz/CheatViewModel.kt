package com.hdd.geoquiz
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
private  const val ANSWER_SHOWN = "ANSWER_SHOWN"

class CheatViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var answerShown
        get() = savedStateHandle[ANSWER_SHOWN] ?: false
        set(value) = savedStateHandle.set(ANSWER_SHOWN, value)

}