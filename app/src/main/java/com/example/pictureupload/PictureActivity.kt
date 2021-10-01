package com.example.pictureupload

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pictureupload.ui.theme.PictureUploadTheme

class PictureActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val path = intent.getStringExtra("img")?:""
            PictureScreen(path)
        }
    }

    @Composable
    fun PictureScreen(img: String){
        PictureUploadTheme {
            Column(modifier = Modifier
                .background(color = colorResource(id = R.color.black))
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val inputStream = assets.open(img)
                val bitmap = BitmapFactory.decodeStream(inputStream).asImageBitmap()

                Image(bitmap = bitmap, contentDescription = ""
                    ,modifier = Modifier.fillMaxWidth()
                    ,contentScale = ContentScale.Crop
                )
            }

            UploadButton(isVisible = true)
        }
    }

    @Composable
    fun UploadButton(isVisible: Boolean){
        if(isVisible){
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {}) {
                    Text(text = "Upload to Cloud")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PictureScreen("img/img2.jpeg")
    }
}