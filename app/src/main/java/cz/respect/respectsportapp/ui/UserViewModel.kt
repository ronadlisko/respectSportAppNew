package cz.respect.respectsportapp.ui

import androidx.lifecycle.*
import cz.respect.respectsportapp.data.model.User
import cz.respect.respectsportapp.data.model.UserRepository
import cz.respect.respectsportapp.ui.gallery.GalleryViewModel
import cz.respect.respectsportapp.ui.home.HomeViewModel
import kotlinx.coroutines.launch

class UserViewModel (private val repository: UserRepository) : ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allUsers.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

}

class GalleryViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GalleryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}