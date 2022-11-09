package com.aptivist.navigationbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aptivist.navigationbasics.ui.theme.NavigationBasicsTheme
import com.aptivist.navigationbasics.ui.views.detailview.DetailView
import com.aptivist.navigationbasics.ui.views.inputview.InputView
import com.aptivist.navigationbasics.ui.views.navigation.NavigationBasicsViews

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationBasicsTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = NavigationBasicsViews.InputView.route){
                    composable(NavigationBasicsViews.InputView.route) { InputView {
                        val route = NavigationBasicsViews.DetailView.route + "/$it"
                        navController.navigate(route)
                    } }
                    composable(NavigationBasicsViews.DetailView.route + "/{text}", arguments = listOf(
                        navArgument("text") {
                            type = NavType.StringType
                        }
                    )) { backstackEntry -> DetailView(backstackEntry.arguments?.getString("text")) {
                        navController.navigate(NavigationBasicsViews.InputView.route) {
                            popUpTo(NavigationBasicsViews.InputView.route)
                            launchSingleTop = true
                        }
                    } }
                }
            }
        }
    }
}

//uri=android-app://androidx.navigation/input_view
//uri=android-app://androidx.navigation/detail_view/{parameter}/{parameter2}/{parameter3}