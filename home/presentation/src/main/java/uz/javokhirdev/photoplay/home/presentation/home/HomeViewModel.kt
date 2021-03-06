package uz.javokhirdev.photoplay.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import uz.javokhirdev.photoplay.home.domain.usecase.HomeUseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    preferences: Preferences,
    private val homeUseCases: HomeUseCases
) : ViewModel() {

    val uiState = MutableStateFlow(HomeState())

    init {
        preferences.saveShouldShowLogin(false)

        getRandomMovie()
        getWatchings()
    }

    private fun getRandomMovie() {
        viewModelScope.launch {
            homeUseCases.getRandomMovie()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        randomMovie = it
                    )
                }
        }
    }

    private fun getWatchings() {
        viewModelScope.launch {
            homeUseCases.getWatchings()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        watchings = it
                    )
                }
        }
    }
}