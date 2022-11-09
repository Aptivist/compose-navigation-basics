package com.aptivist.navigationbasics.ui.views.inputview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InputView(navigateToDetails: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        val text = remember {
            mutableStateOf("")
        }

        TextField(value = text.value, onValueChange = { text.value = it })

        Button(onClick = {
            if(text.value.isNotEmpty())
                navigateToDetails(text.value)
        }) {
            Text(text = "Navigate to detail")
        }
    }
}