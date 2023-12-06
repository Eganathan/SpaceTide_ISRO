package dev.eknath.spacetide_isro.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import dev.eknath.spacetide_isro.presentation.SpaceCraftsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceCraftListScreen(
    viewModel: SpaceCraftsViewModel, navigator: NavController
) {
    val content = viewModel.spaceCraft.collectAsState(null)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "ISRO-SpaceTide") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                    }
                }
            )
        },
    ) {
        if (content.value == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(top = 15.dp)
            ) {
                item { Spacer(modifier = Modifier.height(15.dp)) }
                items(items = content.value.orEmpty(), key = { it.id }) {
                    ListCardItem(entity = it, onClick = {
                        viewModel::selectSpaceCraft.invoke(it)
                        navigator.navigate("detail")
                    })
                }
                item { Spacer(modifier = Modifier.height(150.dp)) }
            }
        }
    }
}

@Composable
private fun ListCardItem(
    entity: SpacecraftEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .heightIn(min = 80.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                text = entity.name,
                style = MaterialTheme.typography.displaySmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Row(modifier = Modifier.padding(top = 10.dp)) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    tint = Color.Unspecified,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Launch Date: ${entity.launchDate}")
            }
            Text(text = "Purpose:  ${entity.application}")
            Text(text = "Status :${entity.missionStatus}")
        }

    }
}