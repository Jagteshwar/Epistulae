package com.jagteshwar.epistulae.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jagteshwar.epistulae.R
import com.jagteshwar.epistulae.models.TweetListItem
import com.jagteshwar.epistulae.viewmodels.CategoryViewModel
import com.jagteshwar.epistulae.viewmodels.DetailViewModel

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val tweets: State<List<TweetListItem>> = detailViewModel.tweets.collectAsState()


    LazyColumn(
            content = {
                items(tweets.value){tweet->
                    DetailItem(tweet = tweet.text)
                    
                }
            }
    )
}

@Composable
fun DetailItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(text = tweet,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge)
        }
    )

}