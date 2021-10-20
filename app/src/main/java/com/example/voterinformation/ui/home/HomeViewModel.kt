package com.example.voterinformation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voterinformation.network.LowerBodyListService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val lowerBodyListService: LowerBodyListService) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        Log.d("init"," made it")
        viewModelScope.launch(Dispatchers.IO) {
            data()
        }
        Log.d("where", " you at bb?")
    }

    suspend fun data() {
        try {
            Log.d("items", lowerBodyListService.getLowerBodyList().toString())
        } catch (e: Exception) {
            Log.d("Exception: ", e.toString())
        }
    }
}