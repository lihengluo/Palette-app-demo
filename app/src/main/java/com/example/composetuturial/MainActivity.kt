package com.example.composetuturial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetuturial.ui.theme.ComposeTuturialTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTuturialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    create_slider()

                }
            }

        }
    }

    external fun stringFromJNI(): String
    companion object {
        init {
            System.loadLibrary("palette")
        }
    }
}


@Composable
fun create_slider() {

    var hue by remember{ mutableStateOf(0f)}
    var chroma by remember{ mutableStateOf(0f)}
    var tone by remember{ mutableStateOf(0f)}
    Column {
        Column (modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center){
            Text(text = "Hue: $hue")
            Text(text = "Chroma: $chroma")
            Text(text = "Tone: $tone")

        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column (modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.onSurface)
            .height(400.dp)
            .width(500.dp)
            .padding(30.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Row (modifier = Modifier.padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Hue")
                    Spacer(Modifier.padding(horizontal = 20.dp))
                    Text(text = hue.toString())
                }
                Slider(value = hue,
                    onValueChange = {hue = it},
                    valueRange = 0f..360f,
                    //modifier = Modifier.weight(1f)
                )
            }
            Column() {
                Row(modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Chroma")
                    Spacer(Modifier.padding(horizontal = 10.dp))

                    Text(text = chroma.toString())
                }
                Slider(value = chroma,
                    onValueChange = {chroma = it},
                    valueRange = 0f..100f,
                    steps = 0,
                    //modifier = Modifier.weight(1f)
                )
            }
            Column() {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Tone")
                    Spacer(Modifier.padding(horizontal = 10.dp))

                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Text(text = tone.toString())
                }
                Slider(
                    value = tone,
                    onValueChange = { tone = it },
                    valueRange = 0f..100f,
                    steps = 0,
                    //modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column (modifier = Modifier
            .padding(20.dp)
            .size(150.dp)
            .border(1.dp, MaterialTheme.colorScheme.onSurface)
            .background(
                color = Color(red = hue / 360, green = chroma / 100, blue = tone / 100),
                shape = MaterialTheme.shapes.medium
            ),
            verticalArrangement = Arrangement.Center){

        }

    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTuturialTheme {
        create_slider()
    }
}