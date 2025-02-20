package com.jagteshwar.epistulae.repository

import com.jagteshwar.epistulae.api.TweetsApi
import com.jagteshwar.epistulae.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(
    private val api: TweetsApi
) {

    private val _catoegories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _catoegories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories() {
        val response = api.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _catoegories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = api.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}