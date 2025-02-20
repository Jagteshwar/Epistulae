package com.jagteshwar.epistulae.screens

sealed class Screens(val route: String) {
    object DetailScreen: Screens("detail_screen")
    object CategoryScreen: Screens("category_screen")
}