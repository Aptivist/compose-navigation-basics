package com.aptivist.navigationbasics.ui.views.navigation

sealed class NavigationBasicsViews(val route: String) {
    object InputView : NavigationBasicsViews("input_view")
    object DetailView : NavigationBasicsViews("detail_view")
}
