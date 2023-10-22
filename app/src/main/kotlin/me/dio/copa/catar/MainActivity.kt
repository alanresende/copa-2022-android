package me.dio.copa.catar

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.LaunchedEffect
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.dio.copa.catar.ui.theme.Copa2022Theme
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            Copa2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }

}

@Composable
fun MatchList() {
    val viewModel: MainViewModel = viewModel()
    val matches = viewModel.matchesState.value

    Column {
        // Exiba a lista de partidas no Composable
        for (match in matches) {
            // Exiba detalhes da partida
        }
    }
}
