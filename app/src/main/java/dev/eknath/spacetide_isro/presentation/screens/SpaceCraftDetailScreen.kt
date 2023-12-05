package dev.eknath.spacetide_isro.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import dev.eknath.spacetide_isro.presentation.util.URLHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(entity: SpacecraftEntity, onBackPressed: () -> Unit) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = entity.name) }, navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                })
        },
    ) {
        Surface(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp)
                        .wrapContentHeight()
                        .align(Alignment.TopCenter)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .padding(top = 5.dp)
                    ) {
                        DetailInfoComponent(
                            name = "Serial Number", value = entity.serialNumber.toString()
                        )
                        DetailInfoComponent(name = "Name", value = entity.name)
                        DetailInfoComponent(name = "Launch Date", value = entity.launchDate)
                        DetailInfoComponent(name = "Orbit Type", value = entity.orbitType)
                        DetailInfoComponent(name = "Launch Vehicle", value = entity.launchVehicle)
                        DetailInfoComponent(name = "Status", value = entity.missionStatus)


                        Divider()
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 5.dp),
                            onClick = { URLHandler(url = entity.link, context = context) }) {
                            Text(text = "Click for more Info")
                        }

                    }
                }
            }

        }
    }
}

@Composable
private fun DetailInfoComponent(name: String, value: String) {
    if (value.isNotEmpty()) {
        Text(
            "$name:",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(start = 10.dp)
                .alpha(0.8f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 20.dp),
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )
        Divider(
            color = MaterialTheme.colorScheme.surface,
            thickness = 2.dp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp)
                .clip(CircleShape)
        )
    }
}