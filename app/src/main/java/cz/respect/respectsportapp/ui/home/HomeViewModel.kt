package cz.respect.respectsportapp.ui.home

import androidx.lifecycle.*
import cz.respect.respectsportapp.data.model.User
import cz.respect.respectsportapp.data.model.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text
}