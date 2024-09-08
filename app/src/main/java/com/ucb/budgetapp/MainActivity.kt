package com.ucb.budgetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucb.budgetapp.ui.theme.InventoryappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventoryappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InventoryappTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Counter: $count", style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = { count++ }) {
            Text(text = "Increment" )
        }
        Row {
          Text(text = "Android")
          Text(text = "Kotlin")
          Text(text = "Compose")
        }
        Box(modifier = Modifier.size(100.dp),
            contentAlignment = Alignment.Center) {
            Icon(modifier = Modifier.size(80.dp),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
                tint = Color.Green)
            Text(text = "$count")
        }
        LazyColumn {
            items(100) {
                Text(text = "Item number is $it")
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
        ) {
            items(100){
                Text(modifier = Modifier.padding(8.dp), text = " Item number is $it" )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
           items(30) {
               Text(
                   modifier = Modifier.padding(9.dp),
                   text = "Item is $it")
           }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(100) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "item is $it")
            }
        }
    }
}