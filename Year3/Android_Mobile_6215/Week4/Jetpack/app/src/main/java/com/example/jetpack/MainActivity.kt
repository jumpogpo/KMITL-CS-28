package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.ui.theme.JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackApp(
                        firstText = stringResource(R.string.first),
                        secondText = stringResource(R.string.seconds),
                        thirdText = stringResource(R.string.thirds),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetpackAppPreview() {
    JetpackTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            JetpackApp(
                firstText = stringResource(R.string.first),
                secondText = stringResource(R.string.seconds),
                thirdText = stringResource(R.string.thirds),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun JetpackApp(
    firstText: String,
    secondText: String,
    thirdText: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        // Image
        val image = painterResource(R.drawable.composearticle_background)

        Image(
            painter = image,
            contentDescription = null
        )

        // First Text
        Text(
            text = firstText,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )

        // Second Text
        Text(
            text = secondText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )

        // Third Text
        Text(
            text = thirdText,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}