package cz.respect.respectsportapp.ui.gallery

import androidx.lifecycle.*
import cz.respect.respectsportapp.data.model.User
import cz.respect.respectsportapp.data.model.UserRepository
import cz.respect.respectsportapp.ui.home.HomeViewModel
import kotlinx.coroutines.launch

class GalleryViewModel(private val repository: UserRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }

    val text: LiveData<String> = _text
}