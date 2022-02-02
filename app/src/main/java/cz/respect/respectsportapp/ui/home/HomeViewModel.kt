package cz.respect.respectsportapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import cz.respect.respectsportapp.data.model.User
import cz.respect.respectsportapp.data.model.UserRepository
import cz.respect.respectsportapp.network.RespectSportApi
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragments"
    }

    private val _response = MutableLiveData<String>().apply {
        //value = "This is another Fragments"
    //getMarsPhotos()
    }
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            val listResult = RespectSportApi.retrofitService.getPhotos()
            Log.i("AVRIL",listResult)
            _response.value = listResult
            //response = listResult.toString()
        }
    }

    val text: LiveData<String> = _text
    val response: LiveData<String> = _response
}