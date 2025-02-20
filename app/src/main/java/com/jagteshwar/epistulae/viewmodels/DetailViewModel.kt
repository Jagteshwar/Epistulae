package com.jagteshwar.epistulae.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagteshwar.epistulae.models.TweetListItem
import com.jagteshwar.epistulae.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets

    init {
        val category = savedStateHandle.get<String>("category")
        viewModelScope.launch {
            repository.getTweets(category = category!!)
        }
    }

}