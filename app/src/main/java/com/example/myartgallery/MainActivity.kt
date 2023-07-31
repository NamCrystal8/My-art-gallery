package com.example.myartgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myartgallery.ui.theme.MyArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ArtGalleryScreen()
                }
            }
        }
    }
}

@Composable
fun ArtGalleryScreen() {
    var currentImageIndex by remember {
        mutableStateOf(0)
    }
    var currentImage =
        when (currentImageIndex) {
            0 -> R.drawable.arona
            1 -> R.drawable.aronawithgems
            2 -> R.drawable.shiroko
            else -> R.drawable.hifumi
        }
    var currentTitle =
        when (currentImageIndex) {
            0 -> R.string.arona
            1 -> R.string.arona_smiling
            2 -> R.string.shiroko
            else -> R.string.hifumi
        }
    var currentDesc =
        when (currentImageIndex) {
            0 -> R.string.arona_desc
            1 -> R.string.arona_smiling_desc
            2 -> R.string.shiroko_desc
            else -> R.string.hifumi_desc
        }
    var image = painterResource(id = currentImage)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            Modifier
                .weight(3.5f)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = image, contentDescription = "Image",

                contentScale = ContentScale.FillBounds,
                modifier =
                Modifier
                    .border(
                        BorderStroke(4.dp, Color.Yellow),
                        CircleShape
                    )
                    .padding(4.dp)
                    .clip(CircleShape)
                    .size(300.dp)
            )
        }

        Surface(color = Color.LightGray, modifier = Modifier.weight(1f)) {
            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = stringResource(id = currentTitle), fontSize = 36.sp)
                Text(text = stringResource(id = currentDesc), fontSize = 24.sp, textAlign = TextAlign.Center)
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (currentImageIndex == 0) {
                        currentImageIndex = 3
                    } else currentImageIndex--
                }, modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if (currentImage == R.drawable.hifumi) {
                        currentImageIndex = 0
                    } else currentImageIndex++
                }, modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryScreen()
}