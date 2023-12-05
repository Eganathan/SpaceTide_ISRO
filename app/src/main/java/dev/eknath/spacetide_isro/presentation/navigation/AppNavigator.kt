package dev.eknath.spacetide_isro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.eknath.spacetide_isro.presentation.SpaceCraftsViewModel
import dev.eknath.spacetide_isro.presentation.screens.DetailScreen
import dev.eknath.spacetide_isro.presentation.screens.SpaceCraftListScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val viewModel: SpaceCraftsViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "list_screen") {
        composable("list_screen") { SpaceCraftListScreen(viewModel, navController) }
        composable("detail") { DetailScreen(viewModel.selectedSpaceCraft.value!!, onBackPressed = {navController.navigate("list_screen")}) }
    }
}
