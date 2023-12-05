package dev.eknath.spacetide_isro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.eknath.spacetide_isro.presentation.SpaceCraftsViewModel
import dev.eknath.spacetide_isro.ui.theme.SpaceTide_ISROTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceTide_ISROTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel = hiltViewModel<SpaceCraftsViewModel>()
                    val content = viewModel.spaceCraft.collectAsState(initial = null)

                    LazyColumn(modifier = Modifier.fillMaxSize()) {


                        if (content.value == null) {
                            item {
                                CircularProgressIndicator()
                            }
                        } else {
                            items(items = content.value.orEmpty()) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp)
                                        .heightIn(min = 80.dp),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {
                                    Column(modifier = Modifier.padding(5.dp)) {
                                        Text(text = it.name, style = MaterialTheme.typography.displaySmall)
                                        Text(text = "orbitType:${it.orbitType}")
                                        Text(text = "Date: ${it.launchDate}")
                                        Text(text = "application: ${it.application}")
                                        Text(text = "vechile: ${it.launchVehicle}")
                                        Text(text = "status :${it.missionStatus}")
                                    }

                                }
                            }
                        }
                    }

                }
            }
        }
    }
}