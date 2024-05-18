package com.example.composableuiscrollablerow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composableuiscrollablerow.ui.theme.ComposableUiScrollableRowTheme


data class Item(val id: Int, val imageResId: Int, val title: String, val subtitle: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList()
        }
    }

    //Defined an Individual Card View
    @Composable
    fun ItemView(item: Item) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .size(150.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }


    //Recycler View of Items
    @Composable
    fun ItemList() {
        val items = listOf(
            Item(1, R.drawable.ic_launcher_background, "Title 1", "Subtitle 1"),
            Item(2, R.drawable.ic_launcher_background, "Title 2", "Subtitle 2"),
            Item(3, R.drawable.ic_launcher_background, "Title 3", "Subtitle 3"),
            Item(3, R.drawable.ic_launcher_background, "Title 3", "Subtitle 3"),
            Item(3, R.drawable.ic_launcher_background, "Title 3", "Subtitle 3"),

        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(items) { item ->
                ItemView(item)
            }
        }
    }
}


//Preview Func to see the preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    MainActivity().ItemList()
}