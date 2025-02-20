package com.jagteshwar.epistulae

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jagteshwar.epistulae.api.TweetsApi
import com.jagteshwar.epistulae.screens.CategoryScreen
import com.jagteshwar.epistulae.screens.DetailScreen
import com.jagteshwar.epistulae.screens.Screens
import com.jagteshwar.epistulae.ui.theme.EpistulaeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsApi: TweetsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EpistulaeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screens.CategoryScreen.route) {
                    composable(route = Screens.CategoryScreen.route){
                        CategoryScreen {
                            navController.navigate(Screens.DetailScreen.route+"/${it}")
                        }
                    }
                    composable(route = Screens.DetailScreen.route+"/{category}", arguments = listOf(
                        navArgument("category"){
                            type = NavType.StringType
                        }
                    )){
                        DetailScreen()
                    }
                }
            }
        }
    }
}
