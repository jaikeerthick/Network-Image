package com.jaikeerthick.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaikeerthick.networkimage.component.NetworkImage
import com.jaikeerthick.networkimage.ui.theme.NetworkImageComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        NetworkImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp),
                            url = "https://cdn.dribbble.com/users/721278/screenshots/15785802/astronauts_dribbble.png",
                            contentScale = ContentScale.Crop,
                            placeHolderContent = {
                                Image(
                                    painter = painterResource(id = R.drawable.placeholder),
                                    contentDescription = "placeholder"
                                )
                            }
                        )
                    }

                }
            }
        }
    }
}