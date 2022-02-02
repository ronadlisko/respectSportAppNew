package cz.respect.respectsportapp.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import cz.respect.respectsportapp.MainActivity
import cz.respect.respectsportapp.data.model.User
import cz.respect.respectsportapp.data.model.UserRepository
import cz.respect.respectsportapp.network.LOCALHOST_SERVER_URL
import cz.respect.respectsportapp.network.LOCALHOST_TEST_URL
import cz.respect.respectsportapp.network.RespectSportApi
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel() : ViewModel() {

    val status = MutableLiveData<String>()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragments"
    }

    private val _response = MutableLiveData<String>().apply {
        //value = "This is another Fragments"
    //getMarsPhotos()
    }
    init {
        getMatches()
    }

    private fun getMatches() {
        viewModelScope.launch {
            try {
                val listResult = RespectSportApi.retrofitService.getMatches()
                //Log.i("API response OK", "Zápasy načteny")
                status.value = "Zápasy úspěšně načteny z internetu"
                _response.value = listResult
            }
            catch (e: Exception) {
                val error = "Chyba při načítání zápasů z internetu: " + e.message
                _response.value = error
                status.value = error
                //Log.i("Exception", e.message.toString())
            }
        }
    }

    val text: LiveData<String> = _text
    val response: LiveData<String> = _response
}