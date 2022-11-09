package com.aptivist.navigationbasics.ui.views.detailview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailView(receivedText : String?, navigateBack : () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        val text = remember {
            mutableStateOf(receivedText)
        }

        Text(text = text.value ?: "")

        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = { navigateBack.invoke() }) {
            Text(text = "Navigate to input")
        }
    }
}